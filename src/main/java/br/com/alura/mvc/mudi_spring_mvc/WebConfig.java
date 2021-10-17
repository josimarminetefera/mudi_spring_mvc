package br.com.alura.mvc.mudi_spring_mvc;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import br.com.alura.mvc.mudi_spring_mvc.interceptor.InterceptadorDeAcessos;

@Configuration
public class WebConfig extends WebMvcConfigurationSupport {

	@Override
	protected void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new InterceptadorDeAcessos()).addPathPatterns("/**");
	}
	
}
