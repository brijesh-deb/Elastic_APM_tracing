package com.example.traceHTTPClient;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class TestControllerTraceHTTPClient {

    private static final Logger LOGGER = LoggerFactory.getLogger(TestControllerTraceHTTPClient.class);


    @GetMapping("/test")
    public String test() {

        return "Testing TestControllerTraceHTTPClient";
    }

    @GetMapping("/publish")
    public String publishAddressFromHttpClient()
    {
        RestTemplate restTemplate = new RestTemplate();
        String resourceUrl = "http://localhost:8086/publish";
        System.out.println("TestControllerTraceHTTPClient.publishFromHttpClient - START");
        ResponseEntity<String> response
                = restTemplate.getForEntity(resourceUrl, String.class);

        System.out.println("Response from KafkaProducer:" +response.getBody());

        return "TestControllerTraceHTTPClient.publishFromHttpClient - END";
    }

    @GetMapping("/dummyexception")
    public String callProducerDummyException()
    {
        RestTemplate restTemplate = new RestTemplate();
        String resourceUrl = "http://localhost:8086/exception";
        System.out.println("TestControllerTraceHTTPClient.callProducerDummyException - START");
        ResponseEntity<String> response
                = restTemplate.getForEntity(resourceUrl, String.class);

        System.out.println("Response from KafkaProducer:" +response.getBody());

        return "TestControllerTraceHTTPClient.callProducerDummyException - END";
    }
}