package com.example.config;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Configuration
public class RestClientConfig {

	@Bean
	@LoadBalanced
	public RestTemplate customRestTemplate() {
		List<HttpMessageConverter<?>> messageConverters;
		messageConverters = new ArrayList<>();
		messageConverters.add(new StringHttpMessageConverter(StandardCharsets.UTF_8));
		messageConverters.add(new MappingJackson2HttpMessageConverter());
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.setMessageConverters(messageConverters);
		return restTemplate;
	}


	@Bean
	@ConditionalOnMissingBean
	public HttpMessageConverters messageConverters(ObjectProvider<HttpMessageConverter<?>> converters) {
		return new HttpMessageConverters(converters.orderedStream().collect(Collectors.toList()));
	}


}
