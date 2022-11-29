package com.yunusbagriyanik.springrabbitmq.service.message;

import com.yunusbagriyanik.springrabbitmq.model.ProcessResult;
import com.yunusbagriyanik.springrabbitmq.model.message.Message;

public interface MessageService {
    ProcessResult sendMessage(Message message);
}