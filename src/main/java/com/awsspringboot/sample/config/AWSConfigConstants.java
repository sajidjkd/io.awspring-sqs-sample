package com.awsspringboot.sample.config;

import org.springframework.beans.factory.annotation.Value;

public class AWSConfigConstants {
    public static final String ACCESS_KEY = "foo";
    public static final String SECRET_KEY = "bar";
    public static final String ENDPOINT = "http://localhost:4566";
    public static final String EU_WEST_1 = "eu-west-1";

   // @Value("${cloud.aws.sqs.order-queue.url}")
   // public static final String ORDER_QUEUE = "order-queue";

}
