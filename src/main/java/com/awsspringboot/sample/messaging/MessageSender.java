package com.awsspringboot.sample.messaging;

import com.awsspringboot.sample.model.Event;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import io.awspring.cloud.messaging.core.QueueMessagingTemplate;
import org.springframework.stereotype.Service;

@Service
public class MessageSender {
    private static final Logger logger = LoggerFactory.getLogger(MessageSender.class);

    private static final String QUEUE_NAME = "http://localhost:4566/000000000000/order-queue";

    private final QueueMessagingTemplate messagingTemplate;

    @Autowired
    public MessageSender(QueueMessagingTemplate messagingTemplate) {
        this.messagingTemplate = messagingTemplate;
    }

    public void send(final Event event) {
        System.out.println("Message sent::"+event);
        messagingTemplate.convertAndSend(QUEUE_NAME, event);
    }
}
