package com.prowings.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableWebMvc
@ComponentScan("com.prowings")
public class SpringBeansConfig {

	@Bean
	public RestTemplate restTemplete()
	{
		return new RestTemplate();
	}
}
