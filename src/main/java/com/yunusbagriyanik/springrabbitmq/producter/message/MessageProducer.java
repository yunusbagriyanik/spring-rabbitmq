package com.yunusbagriyanik.springrabbitmq.producter.message;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.yunusbagriyanik.springrabbitmq.model.data.Data;
import com.yunusbagriyanik.springrabbitmq.model.message.Message;
import jakarta.annotation.PostConstruct;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.UUID;

@Service
public class MessageProducer {

    protected final Logger logger = LogManager.getLogger(this.getClass());

    @Value("${spring-rabbitmq.rabbit.msg.routing.name}")
    private String routingName;

    @Value("${spring-rabbitmq.rabbit.exchange.name}")
    private String exchangeName;

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private ObjectMapper objectMapper;

    @PostConstruct
    public void init() {

    }

    @Scheduled(fixedDelay = 5000, initialDelay = 5000)
    private void produce() {
        Message message = new Message();
        message.setId(UUID.randomUUID().toString());
        message.setType("DEFAULT");
        message.setJsonNode(this.objectMapper.valueToTree(new Data(UUID.randomUUID().toString(), "test transfer object", "SPRING_RABBITMQ")));
        message.setCreatedAt(new Date());

        this.sendMessageToQueue(message);
    }

    public void sendMessageToQueue(Message message) {
        this.logger.info("*********************>>> Message sent id: " + message.getId());
        this.rabbitTemplate.convertAndSend(exchangeName, routingName, message);
    }
}