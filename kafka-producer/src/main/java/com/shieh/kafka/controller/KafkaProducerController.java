package com.shieh.kafka.controller;

import org.apache.kafka.clients.producer.RecordMetadata;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.lang.Nullable;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class KafkaProducerController {

    private final static String TOPIC_NAME="kafka_topic";

    @Autowired
    private KafkaTemplate<String,String> kafkaTemplate;


    @RequestMapping("/kafka")
    public void sendMessage(){
        ListenableFuture<SendResult<String, String>> send = kafkaTemplate.send(TOPIC_NAME,"key","hello" );
        send.addCallback(new ListenableFutureCallback<SendResult<String, String>>() {
            @Override
            public void onFailure(Throwable throwable) {
                System.out.println("生产者发送消息失败");
            }

            @Override
            public void onSuccess(@Nullable SendResult<String, String> stringObjectSendResult) {
                System.out.println("生产者发送消息成功");
                RecordMetadata recordMetadata = stringObjectSendResult.getRecordMetadata();
                long offset = recordMetadata.offset();
                int partition = recordMetadata.partition();
                String topic = recordMetadata.topic();
                System.out.println("offset: "+offset+"---"+"partition: "+partition+"topic: "+topic);
            }
        });
    }


}
