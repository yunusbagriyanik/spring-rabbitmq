package com.yunusbagriyanik.springrabbitmq.notification;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.yunusbagriyanik.springrabbitmq.model.data.Data;
import com.yunusbagriyanik.springrabbitmq.model.message.Message;
import com.yunusbagriyanik.springrabbitmq.model.notification.Notification;
import com.yunusbagriyanik.springrabbitmq.producter.notification.NotificationProducer;
import com.yunusbagriyanik.springrabbitmq.service.notification.NotificationServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

import java.util.Date;
import java.util.UUID;

import static org.mockito.Mockito.doNothing;

@MockitoSettings(strictness = Strictness.LENIENT)
@ExtendWith(MockitoExtension.class)
public class NotificationServiceTest {

    private static final String ID = UUID.randomUUID().toString();
    private static final String TYPE = "DEFAULT";

    @Spy
    @InjectMocks
    private NotificationServiceImpl notificationService;
    @Mock
    private NotificationProducer notificationProducer;

    @Mock
    private ObjectMapper objectMapper;

    Notification notification;
    Message message;

    @BeforeEach
    public void setUp() {
        notification = new Notification();
        notification.setNotificationId(UUID.randomUUID().toString());
        notification.setCreatedDate(new Date());

        message = new Message();
        message.setId(ID);
        message.setType(TYPE);
        message.setJsonNode(this.objectMapper.valueToTree(new Data(UUID.randomUUID().toString(), "test transfer object", "SPRING_RABBITMQ")));
    }

    @Test
    public void whenSendNotificationWithValidRequest_itShouldSendNotification() {
        this.notificationService.sendNotification(message);

        doNothing().when(this.notificationService).sendNotification(message);
    }
}