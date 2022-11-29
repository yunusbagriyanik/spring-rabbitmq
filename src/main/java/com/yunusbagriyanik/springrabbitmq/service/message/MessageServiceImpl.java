package com.yunusbagriyanik.springrabbitmq.service.message;

import com.yunusbagriyanik.springrabbitmq.model.ProcessResult;
import com.yunusbagriyanik.springrabbitmq.model.message.Message;
import com.yunusbagriyanik.springrabbitmq.producter.message.MessageProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessageServiceImpl implements MessageService {

    @Autowired
    private MessageProducer messageProducer;

    @Override
    public ProcessResult sendMessage(Message message) {
        this.messageProducer.sendMessageToQueue(message);
        return ProcessResult.success("Message Sent");
    }
}