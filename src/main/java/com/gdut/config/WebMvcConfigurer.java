package com.gdut.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.gdut.utils.AdminSecurityInterceptor;
import com.gdut.utils.UserSecurityInterceptor;

/**
 * 描述：配置spring mvc的拦截器
 * 
 * @author ZListen 20170107
 */
@Configuration
public class WebMvcConfigurer extends WebMvcConfigurerAdapter {

	public void addUserSecurityInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new UserSecurityInterceptor()).addPathPatterns("/**").excludePathPatterns("/login");
	}

	public void addAdminSecurityInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new AdminSecurityInterceptor()).addPathPatterns("/admin/**");
	}

}