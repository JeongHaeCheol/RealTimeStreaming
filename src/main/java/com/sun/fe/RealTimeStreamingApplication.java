package com.sun.fe;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@PropertySource("config/config.properties")
public class RealTimeStreamingApplication {

	public static void main(String[] args) {
		SpringApplication.run(RealTimeStreamingApplication.class, args);
	}

}
