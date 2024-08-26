package com.ahexagram.ollama;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import com.ahexagram.ollama.functions.WeatherConfigProperties;



@EnableConfigurationProperties(WeatherConfigProperties.class)
@SpringBootApplication
public class OllamaApplication {

	public static void main(String[] args) {
		SpringApplication.run(OllamaApplication.class, args);
	}

}
