package com.store.webStore.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;

import java.util.Locale;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry
                .addResourceHandler("/webjars/**")
                .addResourceLocations("/webjars/");


        //
        // Access Bootstrap static resource:
        //

        //
        // http://somedomain/SomeContextPath/jquery/jquery.min.css
        //
        //registry.addResourceHandler("/jquery/**") //
          //      .addResourceLocations("C:\\Users\\Daur\\.m2\\repository\\org\\webjars\\jquery\\3.3.1-1");

        //
        // http://somedomain/SomeContextPath/popper/popper.min.js
        //
        //registry.addResourceHandler("/popper/**") //
          //      .addResourceLocations("C:\\Users\\Daur\\.m2\\repository\\org\\webjars\\popper.js\\1.14.1");

        // http://somedomain/SomeContextPath/bootstrap/css/bootstrap.min.css
        // http://somedomain/SomeContextPath/bootstrap/js/bootstrap.min.js
        //
        //registry.addResourceHandler("/bootstrap/**") //
          //      .addResourceLocations("C:\\Users\\Daur\\.m2\\repository\\org\\webjars\\bootstrap\\4.1.1");

    }
}
