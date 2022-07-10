package com.example.traceHTTPClient;

import co.elastic.apm.attach.ElasticApmAttacher;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TraceHttpClientApplication {

	public static void main(String[] args) {
		ElasticApmAttacher.attach();
		SpringApplication.run(TraceHttpClientApplication.class, args);
	}

}
