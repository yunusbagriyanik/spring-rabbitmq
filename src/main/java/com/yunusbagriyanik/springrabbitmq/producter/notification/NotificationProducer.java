package com.yunusbagriyanik.springrabbitmq.producter.notification;

import com.yunusbagriyanik.springrabbitmq.model.notification.Notification;
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
public class NotificationProducer {

    protected final Logger logger = LogManager.getLogger(this.getClass());

    @Value("${spring-rabbitmq.rabbit.routing.name}")
    private String routingName;

    @Value("${spring-rabbitmq.rabbit.exchange.name}")
    private String exchangeName;

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @PostConstruct
    public void init() {

    }

    @Scheduled(fixedDelay = 5000, initialDelay = 5000)
    private void produce() {
        Notification notification = new Notification();
        notification.setNotificationId(UUID.randomUUID().toString());
        notification.setMessage("NotificationProducer.produce");
        notification.setCreatedDate(new Date());

        this.sendNotificationToQueue(notification);
    }

    public void sendNotificationToQueue(Notification notification) {
        this.logger.info("=====================>>> Notification sent id: " + notification.getNotificationId());
        this.rabbitTemplate.convertAndSend(exchangeName, routingName, notification);
    }
}