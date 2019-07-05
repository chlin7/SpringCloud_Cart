package com.gensoft.apigateway.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.util.Arrays;

/**
 * @ desc：跨域处理
 * @ Author     ：chenhl01.
 * @ Date       ：Created in 15:29 2019/7/5
 */
@Configuration
public class CorsConfig {

	@Bean
	public CorsFilter corsFilter() {
		final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();

		final CorsConfiguration config = new CorsConfiguration();
		config.setAllowCredentials(true);//是否支持Cookie跨域
		config.setAllowedOrigins(Arrays.asList("*"));//原始域，所有就用*
		config.setAllowedHeaders(Arrays.asList("*"));//允许的头
		config.setAllowedMethods(Arrays.asList("*"));//允许的方法GET  OR  POST
		config.setMaxAge(300L);//相同的url跨域请求不再进行检查 间隔检查时间

		source.registerCorsConfiguration("/**", config);
		return new CorsFilter(source);
	}
}
