package org.cccgermantown.web.contact;

import org.cccgermantown.web.contact.controller.Controllers;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.GsonHttpMessageConverter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.servlet.view.UrlBasedViewResolver;

import java.util.List;

/**
 * Created by LeOn on 11/30/14.
 */
@Configuration
@EnableWebMvc
// basePackageClasses is a type safe way of scanning
@ComponentScan(basePackageClasses = Controllers.class)
public class WebAppConfig extends WebMvcConfigurerAdapter
{
    @Bean
    public UrlBasedViewResolver getUrlBasedViewResolver() {
        UrlBasedViewResolver u = new UrlBasedViewResolver();
        u.setPrefix("/WEB-INF/jsp/");
        u.setSuffix(".jsp");
        u.setViewClass(JstlView.class);
        return u;
    }

    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        converters.add(gsonHttpMessageConverter());
    }

    @Bean
    public GsonHttpMessageConverter gsonHttpMessageConverter()
    {
        return new GsonHttpMessageConverter();
    }


}
