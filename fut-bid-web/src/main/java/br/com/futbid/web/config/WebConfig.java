package br.com.futbid.web.config;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceView;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.thymeleaf.extras.conditionalcomments.dialect.ConditionalCommentsDialect;
import org.thymeleaf.spring3.SpringTemplateEngine;
import org.thymeleaf.spring3.view.ThymeleafViewResolver;
import org.thymeleaf.templateresolver.ServletContextTemplateResolver;

import br.com.futbid.commons.util.SpringConfig;
import br.com.futbid.web.mvc.DefaultResourceView;

import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;

@Configuration
@EnableWebMvc
@Import(PropertiesConfig.class)
@ComponentScan(basePackages = { "br.com.futbid.web", "br.com.futbid.service", "br.com.futbid.integration",
	"br.com.futbid.commons" })
public class WebConfig extends WebMvcConfigurerAdapter implements SpringConfig<WebConfig> {

    private static final Logger LOG = LoggerFactory.getLogger(WebConfig.class);

    public static final String VIEW_PREFIX = "/WEB-INF/view/";
    public static final String CONTENT_TYPE = "text/html; charset=UTF-8";

    public static final int YEAR_IN_SECONDS = 31556926;

    @Autowired
    private WebProperties webProperties;

    @PostConstruct
    @Override
    public void init() {
	LOG.debug("init() {} (debug={})", WebConfig.class.getSimpleName(), webProperties.isDebug());
    }

    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }

    @Bean
    public ViewResolver getJspViewResolver() {
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setContentType(CONTENT_TYPE);
        resolver.setPrefix(VIEW_PREFIX);
        resolver.setSuffix(".jsp");
        resolver.setViewClass(InternalResourceView.class);
        resolver.setOrder(2);
        return resolver;
    }

    @Bean
    public ViewResolver getHtmlViewResolver() {
        ServletContextTemplateResolver templateResolver = new ServletContextTemplateResolver();
        templateResolver.setTemplateMode("LEGACYHTML5");
        templateResolver.setPrefix(VIEW_PREFIX);
        templateResolver.setSuffix(".html");
        templateResolver.setCharacterEncoding(webProperties.getEncoding());
        templateResolver.setOrder(1);

        SpringTemplateEngine engine = new SpringTemplateEngine();
        engine.setTemplateResolver(templateResolver);
        engine.addDialect(new ConditionalCommentsDialect()); // suporte ao IE

        ThymeleafViewResolver viewResolver = new ThymeleafViewResolver();
        viewResolver.setViewNames(new String[] { "/html/*" }); // para ignorar os jsps
        viewResolver.setContentType(CONTENT_TYPE);
        viewResolver.setTemplateEngine(engine);
        if (webProperties.isDebug()) {
            viewResolver.setCache(false);
        }
        viewResolver.setOrder(1);
        return viewResolver;
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
	Integer cacheInSeconds = webProperties.isDebug() ? 0 : YEAR_IN_SECONDS;
	registry.addResourceHandler("/css/**").addResourceLocations("/css/").setCachePeriod(cacheInSeconds);
	registry.addResourceHandler("/img/**").addResourceLocations("/img/").setCachePeriod(cacheInSeconds);
	registry.addResourceHandler("/js/**").addResourceLocations("/js/").setCachePeriod(cacheInSeconds);
    }

    @Bean
    public ObjectMapper objectMapper() {
	// serializar via field ao inves de getters/setters (JSON)
	ObjectMapper mapper = new ObjectMapper();
	mapper.setVisibility(PropertyAccessor.ALL, Visibility.NONE);
	mapper.setVisibility(PropertyAccessor.FIELD, Visibility.ANY);
	return mapper;
    }

    @PreDestroy
    @Override
    public void destroy() {
	LOG.debug("stop() {}", getClass().getSimpleName());
    }

}
