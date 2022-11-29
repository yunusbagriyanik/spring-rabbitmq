package com.yunusbagriyanik.springrabbitmq.service.notification;

import com.yunusbagriyanik.springrabbitmq.model.notification.Notification;
import com.yunusbagriyanik.springrabbitmq.producter.notification.NotificationProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.UUID;

@Service
public class NotificationServiceImpl implements NotificationService {

    @Autowired
    private NotificationProducer notificationProducer;

    @Override
    public void sendNotification(Object data) {
        Notification notification = new Notification();
        notification.setNotificationId(UUID.randomUUID().toString());
        notification.setCreatedDate(new Date());
        notification.setMessage(data.toString());

        this.notificationProducer.sendNotificationToQueue(notification);
    }
}