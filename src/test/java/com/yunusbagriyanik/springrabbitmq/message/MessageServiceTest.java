package com.yunusbagriyanik.springrabbitmq.message;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.yunusbagriyanik.springrabbitmq.model.ProcessResult;
import com.yunusbagriyanik.springrabbitmq.model.data.Data;
import com.yunusbagriyanik.springrabbitmq.model.message.Message;
import com.yunusbagriyanik.springrabbitmq.producter.message.MessageProducer;
import com.yunusbagriyanik.springrabbitmq.service.message.MessageServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class MessageServiceTest {

    private static final String ID = UUID.randomUUID().toString();
    private static final String TYPE = "DEFAULT";

    @Spy
    @InjectMocks
    private MessageServiceImpl messageService;
    @Mock
    private MessageProducer messageProducer;
    @Mock
    private ObjectMapper objectMapper;

    Message message;

    @BeforeEach
    public void setUp() {
        message = new Message();
        message.setId(ID);
        message.setType(TYPE);
        message.setJsonNode(this.objectMapper.valueToTree(new Data(UUID.randomUUID().toString(), "test transfer object", "SPRING_RABBITMQ")));
    }

    @Test
    public void whenSendMessageCalledWithValidRequest_itShouldReturnProcessResult() {
        assertEquals(ProcessResult.success("Message Sent"), this.messageService.sendMessage(message));

        verify(this.messageService, times(1)).sendMessage(message);
    }
}