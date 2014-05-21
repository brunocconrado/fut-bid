package br.com.futbid.swing.config;

import static br.com.futbid.commons.environment.FutBidEnvironment.APPLICATION_COUNTRY;
import static br.com.futbid.commons.environment.FutBidEnvironment.APPLICATION_COUNTRY_UNSET;
import static br.com.futbid.commons.environment.FutBidEnvironment.APPLICATION_LANGUAGE;
import static br.com.futbid.commons.environment.FutBidEnvironment.APPLICATION_LANGUAGE_UNSET;
import static br.com.futbid.commons.environment.FutBidEnvironment.APPLICATION_ENCODING_DEFAULT;
import static br.com.futbid.commons.environment.FutBidEnvironment.APPLICATION_ENCODING_DEFAULT_UNSET;

import java.io.IOException;
import java.util.Locale;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.core.env.Environment;

@Configuration
@PropertySource("${futbid.env.path:classpath:config/environment.properties}")
// -Dfluxoav.env.path para caminho absoluto
public class PropertiesConfig {

    private static final Logger LOG = LoggerFactory.getLogger(PropertiesConfig.class);

    @Autowired
    private Environment environment;

    @PostConstruct
    public void init() {
	LOG.debug("init() {}", PropertiesConfig.class.getSimpleName());
    }

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertyPlaceholderConfigurer() {
	return new PropertySourcesPlaceholderConfigurer();
    }

    @Bean(name = "messageSource")
    public ReloadableResourceBundleMessageSource bundleMessageSource() throws IOException {

	ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
	messageSource.setBasenames("classpath:messages", "classpath:messages-errors");
	messageSource.setFallbackToSystemLocale(false);
	messageSource.setUseCodeAsDefaultMessage(true);
	messageSource.setDefaultEncoding(environment.getProperty(APPLICATION_ENCODING_DEFAULT,
		APPLICATION_ENCODING_DEFAULT_UNSET));
	return messageSource;
    }

    @Bean(name = "locale")
    public Locale locale() {
	return defaultLocale();
    }

    @Bean(name = "defaultLocale")
    public Locale defaultLocale() {
	return new Locale(environment.getProperty(APPLICATION_LANGUAGE, APPLICATION_LANGUAGE_UNSET),
		environment.getProperty(APPLICATION_COUNTRY, APPLICATION_COUNTRY_UNSET));
    }

    @PreDestroy
    public void destroy() {
	LOG.debug("stop() {}", getClass().getSimpleName());
    }

}
