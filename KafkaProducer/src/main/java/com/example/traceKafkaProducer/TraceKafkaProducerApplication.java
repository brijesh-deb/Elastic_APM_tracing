package com.example.traceKafkaProducer;

import co.elastic.apm.attach.ElasticApmAttacher;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Processor;

@SpringBootApplication
@EnableBinding(Processor.class)
public class TraceKafkaProducerApplication
{
	public static void main(String[] args) {
		ElasticApmAttacher.attach();
		SpringApplication.run(TraceKafkaProducerApplication.class, args);
	}
}
