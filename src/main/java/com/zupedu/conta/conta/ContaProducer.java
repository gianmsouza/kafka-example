package com.zupedu.conta.conta;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class ContaProducer {

    @Autowired
    private KafkaTemplate<String, Conta> kafkaTemplate;

    @Value("${spring.kafka.producer.topic-name}")
    private String topicName;

    @Async
    public void sendKafka(Conta conta) {
        kafkaTemplate.send(topicName, conta);
    }
}
