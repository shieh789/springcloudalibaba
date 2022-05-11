package kafka.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class KafkaConsumerController {

    private final static String TOPIC_NAME="kafka_topic";

    @Autowired
    private KafkaTemplate<String,String> kafkaTemplate;


    @RequestMapping("/kafka")
    public void sendMessage(){
        kafkaTemplate.send(TOPIC_NAME,"key","hello");
    }


}
