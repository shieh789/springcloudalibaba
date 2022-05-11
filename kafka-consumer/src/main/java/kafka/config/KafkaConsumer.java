package kafka.config;

import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Component;

@Component
public class KafkaConsumer {

    private final static String TOPIC_NAME="kafka_topic";

    @KafkaListener(topics = TOPIC_NAME,groupId = "test")
    public void receiveMessage(ConsumerRecord<String,String> record, Acknowledgment acknowledgment){
        String value = record.value();
        System.out.println(value);
        System.out.println(record);
    }
}
