package com.sdk;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

//configurasyon için
@Configuration
@EnableWebMvc
@ComponentScan("com.sdk")
public class WebMvcConfig implements WebMvcConfigurer {
	@Bean
    public InternalResourceViewResolver resolver() {
        InternalResourceViewResolver resolvers = new InternalResourceViewResolver();
        resolvers.setViewClass(JstlView.class);
        resolvers.setPrefix("/WEB-INF/views/");
        resolvers.setSuffix(".jsp");
        return resolvers;
    }
	
	
	//js,css,image
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registrys) {
        registrys
            .addResourceHandler("/resources/**")
            .addResourceLocations("/resources/");
    }
}
