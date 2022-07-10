package com.example.traceKafkaConsumer;

import co.elastic.apm.attach.ElasticApmAttacher;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Processor;

@SpringBootApplication
@EnableBinding(Processor.class)
public class TraceKafkaConsumerApplication {

	public static void main(String[] args) {
		ElasticApmAttacher.attach();
		SpringApplication.run(TraceKafkaConsumerApplication.class, args);
	}

}
