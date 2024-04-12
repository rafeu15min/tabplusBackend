package com.api.tabplusBackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = { DataSourceAutoConfiguration.class })
public class TabplusBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(TabplusBackendApplication.class, args);
	}

}
