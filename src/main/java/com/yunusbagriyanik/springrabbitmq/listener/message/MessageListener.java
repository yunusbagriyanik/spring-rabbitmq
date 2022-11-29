package com.yunusbagriyanik.springrabbitmq.listener.message;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.yunusbagriyanik.springrabbitmq.model.message.Message;
import com.yunusbagriyanik.springrabbitmq.producter.notification.NotificationProducer;
import com.yunusbagriyanik.springrabbitmq.service.notification.NotificationService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessageListener {

    protected final Logger logger = LogManager.getLogger(this.getClass());

    @Autowired
    private NotificationService notificationService;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private NotificationProducer notificationProducer;

    @RabbitListener(queues = "${spring-rabbitmq.rabbit.msg.queue.name}")
    public void handleNotification(Message message) {
        this.logger.info("*********************>>> Message received." + message.toString());
        this.notificationService.sendNotification(this.objectMapper.valueToTree(message.getJsonNode()));
    }
}