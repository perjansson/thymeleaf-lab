package com.peejay.config;

import com.peejay.config.formatting.DateFormatter;
import org.springframework.context.annotation.*;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.format.FormatterRegistry;
import org.springframework.format.number.NumberFormatter;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
@ComponentScan(basePackages = {"com.peejay"})
@EnableWebMvc
@Import(ThymeleafConfig.class)
@PropertySource("classpath:spring.properties")
public class AppConfig extends WebMvcConfigurerAdapter {

    // Maps resources path to webapp/resources
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/img/**").addResourceLocations("/WEB-INF/img/");
        registry.addResourceHandler("/css/**").addResourceLocations("/WEB-INF/css/");
        registry.addResourceHandler("/fonts/**").addResourceLocations("/WEB-INF/fonts/");
        registry.addResourceHandler("/js/**").addResourceLocations("/WEB-INF/js/");
    }

    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }

    // Only needed if we are using @Value and ${...} when referencing properties
    @Bean
    public static PropertySourcesPlaceholderConfigurer properties() {
        PropertySourcesPlaceholderConfigurer propertySources = new PropertySourcesPlaceholderConfigurer();
        Resource[] resources = new ClassPathResource[]{new ClassPathResource("spring.properties")};
        propertySources.setLocations(resources);
        propertySources.setIgnoreUnresolvablePlaceholders(true);
        return propertySources;
    }

    // Provides internationalization of messages
    @Bean
    public ResourceBundleMessageSource messageSource() {
        ResourceBundleMessageSource source = new ResourceBundleMessageSource();
        source.setBasename("messages/messages");
        source.setDefaultEncoding("UTF-8");
        return source;
    }

    @Override
    public void addFormatters(FormatterRegistry registry) {
        ResourceBundleMessageSource messageSource = messageSource();
        registry.addFormatter(new DateFormatter(messageSource));
        registry.addFormatter(new NumberFormatter("###.##"));
    }

}
