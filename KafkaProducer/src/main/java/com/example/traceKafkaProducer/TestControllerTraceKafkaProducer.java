package com.example.traceKafkaProducer;

import example.avro.ShippingAddress;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.messaging.Processor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutionException;

@RestController
public class TestControllerTraceKafkaProducer {

    private static final Logger LOGGER = LoggerFactory.getLogger(TestControllerTraceKafkaProducer.class);

    @Autowired
    private Processor processor;

    @GetMapping("/test")
    public String test() {

        return "Testing TestControllerTraceKafkaProducer";
    }

    @GetMapping("/publish")
    public String publishAddress()
    {
        String cart_id = "110";
        String street = "Manyata Road";
        String state = "KA";
        String post_code="560000";
        ShippingAddress address = new ShippingAddress(cart_id,street,state,post_code);

        LOGGER.info("Inside TestControllerTraceKafkaProducer.publishAddress - BEFORE MESSAGE");
        // Publish ShippingAddress to Kafka topic
        Message<ShippingAddress> message = MessageBuilder.withPayload(address).build();
        processor.output().send(message);
        LOGGER.info("Inside TestControllerTraceKafkaProducer.publishAddress - AFTER MESSAGE");
        return "Message published to KAFKA";
    }

    @GetMapping("/exception")
    public void dummyException() throws Exception {

        Thread.sleep(2000);
        throw new Exception("dummy Exception");
    }

}