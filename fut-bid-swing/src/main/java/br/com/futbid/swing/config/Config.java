package br.com.futbid.swing.config;

import java.lang.reflect.Field;
import java.nio.charset.Charset;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

@Configuration
@ComponentScan(basePackages = { "br.com.futbid", "br.com.futbid.integration" })
public class Config {

    private static ConfigurableApplicationContext context;

    public static void init() {
	context = new AnnotationConfigApplicationContext(Config.class);
	setSystemProperties();
    }  

    @Bean
    public ObjectMapper objectMapper() {
        // serializar via field ao inves de getters/setters (JSON)
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, true);
        mapper.configure(DeserializationFeature.UNWRAP_ROOT_VALUE, true);
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        mapper.setVisibility(PropertyAccessor.ALL, Visibility.NONE);
        mapper.setVisibility(PropertyAccessor.FIELD, Visibility.ANY);
        return mapper;
    }
    
    public static <T> T getBean(Class<T> clazz) {
	return context.getBean(clazz); 
    }
    
    private static void setSystemProperties() {
	try {
	    System.setProperty("file.encoding", "UTF-8");
	    Field charset = Charset.class.getDeclaredField("defaultCharset");
	    charset.setAccessible(true);
	    charset.set(null, null);
	} catch (Exception e) {
	    throw new RuntimeException("Can't set default charset");
	}
    }
}
