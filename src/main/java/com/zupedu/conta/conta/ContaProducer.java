package com.zupedu.conta.conta;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class ContaProducer {

    @Autowired
    private KafkaTemplate<String, Conta> kafkaTemplate;

    @Async
    public void sendKafka(Conta conta){
        kafkaTemplate.send("NOVA_CONTA", conta);
    }
}
