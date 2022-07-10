package com.example.traceKafkaConsumer;

import example.avro.ShippingAddress;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Processor;
import org.springframework.stereotype.Service;

@Service
public class Consumer {

    private static final Logger LOGGER = LoggerFactory.getLogger(Consumer.class);

    // Consume ShippingAddress from Kafka topic
    @StreamListener(Processor.INPUT)
    public void consumeShippingDetails(ShippingAddress address) {
        LOGGER.info("Inside TraceKafkaConsumer.Consumer.consumeShippingDetails Cart Id :"+address.getCardId());
        LOGGER.info("Inside TraceKafkaConsumer.Consumer.consumeShippingDetails Street :"+address.getStreet());
        LOGGER.info("Inside TraceKafkaConsumer.Consumer.consumeShippingDetails State:"+address.getState());
        LOGGER.info("Inside TraceKafkaConsumer.Consumer.consumeShippingDetails Pincode :"+address.getPostCode());
    }
}