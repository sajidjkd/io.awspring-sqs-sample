package com.awsspringboot.sample.messaging;

import com.awsspringboot.sample.model.Event;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Service;

import com.amazonaws.services.s3.event.S3EventNotification;

import io.awspring.cloud.messaging.listener.SqsMessageDeletionPolicy;
import io.awspring.cloud.messaging.listener.annotation.SqsListener;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class MessageReceiver {

    //http://localhost:4566/000000000000/order-queue
    @SqsListener(value = "http://0.0.0.0:4566/000000000000/order-queue", deletionPolicy = SqsMessageDeletionPolicy.ON_SUCCESS )
    public void receiveStringMessage(final String message,
                                     @Header("SenderId") String senderId) {
        log.info("message received {} {}",senderId,message);
    }/*

    @SqsListener(value = "http://0.0.0.0:4566/000000000000/order-queue", deletionPolicy = SqsMessageDeletionPolicy.ON_SUCCESS )
    public void receiveStringMessage(final String message) {
        log.info("message received {} {}",message);
    }

    @SqsListener(value = "http://0.0.0.0:4566/000000000000/order-queue", deletionPolicy = SqsMessageDeletionPolicy.ON_SUCCESS )
    public void receiveObjectMessage(final Event message,
                                     @Header("SenderId") String senderId) {
        log.info("object message received {} {}",senderId,message);
    }

    @SqsListener(value = "http://0.0.0.0:4566/000000000000/order-queue", deletionPolicy = SqsMessageDeletionPolicy.ON_SUCCESS )
    public void receiveObjectMessage(final Event message) {
        log.info("object message received {} {}",message);
    }*/

}
