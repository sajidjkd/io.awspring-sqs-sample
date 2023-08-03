package com.awsspringboot.sample.controller;

import com.awsspringboot.sample.model.Event;
import com.awsspringboot.sample.model.EventData;
import com.awsspringboot.sample.model.EventType;
import com.awsspringboot.sample.messaging.MessageSender;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.Instant;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;

@Controller
public class OrderController {

    private final AtomicInteger atomicInteger = new AtomicInteger();
    @Autowired
    MessageSender messageSender;

    @GetMapping(value = "/create-order", produces = MediaType.TEXT_PLAIN_VALUE)
    public ResponseEntity<String> createOrder() throws JsonProcessingException {
        Event event = createOrderEvent();
        String payload = new ObjectMapper().writeValueAsString(event);
        System.out.println("event.toString():"+ payload);
        messageSender.send(event);
        return ResponseEntity.ok().body("Sent message to SQS");
    }

    private Event createOrderEvent() {
        return Event.builder()
                .eventId(UUID.randomUUID().toString())
                .occurredAt(Instant.now().toString())
                .version(String.valueOf(atomicInteger.getAndIncrement()))
                .data(EventData
                        .builder()
                        .eventType(EventType.ORDER_CREATED)
                        .orderId(UUID.randomUUID().toString())
                        .owner("SampleProducer")
                        .build())
                .build();
    }
}
