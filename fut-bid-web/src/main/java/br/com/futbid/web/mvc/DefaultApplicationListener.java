package br.com.futbid.web.mvc;

import java.util.concurrent.atomic.AtomicLong;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import org.slf4j.ILoggerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ApplicationContextEvent;
import org.springframework.context.event.ContextClosedEvent;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.ContextStartedEvent;
import org.springframework.context.event.ContextStoppedEvent;
import org.springframework.stereotype.Component;

import br.com.futbid.commons.util.LogUtils;
import br.com.futbid.commons.util.LogUtils.DiskUsage;
import br.com.futbid.commons.util.LogUtils.SystemPropertiesInitializer;
import br.com.futbid.web.config.WebProperties;

@Component
@WebListener
@SuppressWarnings("rawtypes")
public class DefaultApplicationListener implements ApplicationListener, HttpSessionListener {

    private static final Logger LOG = LoggerFactory.getLogger(DefaultApplicationListener.class);

    private static final AtomicLong startupMs = new AtomicLong(0L);

    @Override
    public void onApplicationEvent(ApplicationEvent event) {
        LOG.trace("onApplicationEvent({})", event);
        if (event instanceof ApplicationContextEvent) {
            ApplicationContextEvent applicationContextEvent = (ApplicationContextEvent) event;
            ApplicationContext applicationContext = applicationContextEvent.getApplicationContext();
            LOG.warn(applicationContext.getApplicationName() + " " + getStatus((ApplicationContextEvent) event));

            if (isStartupEvent(applicationContextEvent)) {
                logEnvironment(applicationContext);
                long currentTimeMillis = System.currentTimeMillis();
                //boolean isFirstStartup = startupMs.compareAndSet(0L, currentTimeMillis);
                LOG.info("FluxoAV STARTED @{}", currentTimeMillis);
            }

            if (event instanceof ContextStoppedEvent || event instanceof ContextClosedEvent) {
                long stopTime = 0;
                try {
                    ContextStoppedEventHandler.onStop();
                    stopTime = System.currentTimeMillis() - (startupMs == null ? 0 : startupMs.get());
                } catch (Exception e) {
                    LogUtils.error(e.getMessage(), e);
                } finally {
                    LogUtils.error("FluxoAV STOPPED @" + stopTime);
                }
            }

        }
    }

    private boolean isStartupEvent(ApplicationContextEvent applicationContextEvent) {
        // eventos na thread "startStop"
        return applicationContextEvent instanceof ContextStartedEvent
                || applicationContextEvent instanceof ContextRefreshedEvent;
    }

    private static void logEnvironment(ApplicationContext applicationContext) {
        // log das propriedades de sistema
        WebProperties webProperties = applicationContext.getBean(WebProperties.class);
        LOG.info("applicationContext={} webProperties={}", applicationContext, webProperties);
        // verifica a partição identificada por "/dev/mapper"
        DiskUsage.printUsage();
        // configura propriedades adicionais, caso não estejam definidas via "-D"
        SystemPropertiesInitializer.reset(webProperties.isDebug());
    }

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        LOG.debug("sessionCreated({})", se.getSession() == null ? null : se.getSession().getId());
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        LOG.debug("sessionDestroyed({})", se.getSession() == null ? null : se.getSession().getId());
    }

    public static void onStop() {
        // LOG finalizado
        LogUtils.error("filter stopped");
    }

    protected static String getStatus(ApplicationContextEvent event) {
        try {
            // ContextStartedEvent, ContextStoppedEvent, ContextRefreshedEvent, ContextClosedEvent
            return event.getClass().getSimpleName().replaceAll("Context|Event", "").toUpperCase();
        } catch (Exception e) {
            LOG.error("event=" + event, e);
            return "";
        }
    }

    public static class ContextStoppedEventHandler {

        public static boolean onStop() {
            ILoggerFactory loggerFactory = LoggerFactory.getILoggerFactory();
            if (loggerFactory instanceof ch.qos.logback.classic.LoggerContext) {
                // finaliza o contexto async do logback
                LogUtils.error("loggerFactory stopped");
                ((ch.qos.logback.classic.LoggerContext) loggerFactory).stop();
                return true;
            }
            return false;
        }

    }

}