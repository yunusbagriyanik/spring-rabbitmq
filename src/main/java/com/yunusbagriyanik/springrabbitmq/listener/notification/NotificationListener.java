package com.yunusbagriyanik.springrabbitmq.listener.notification;

import com.yunusbagriyanik.springrabbitmq.model.notification.Notification;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class NotificationListener {

    protected final Logger logger = LogManager.getLogger(this.getClass());

    @RabbitListener(queues = "${spring-rabbitmq.rabbit.queue.name}")
    public void handleNotification(Notification notification) {
        this.logger.info("=====================>>> Notification received." + notification.toString());
    }
}