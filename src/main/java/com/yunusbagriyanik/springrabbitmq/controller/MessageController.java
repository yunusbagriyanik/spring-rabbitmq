package com.yunusbagriyanik.springrabbitmq.controller;

import com.yunusbagriyanik.springrabbitmq.model.ProcessResult;
import com.yunusbagriyanik.springrabbitmq.model.message.Message;
import com.yunusbagriyanik.springrabbitmq.service.message.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/message")
public class MessageController {

    @Autowired
    public MessageService messageService;

    @PostMapping("/post")
    public ResponseEntity<ProcessResult> sendMessage(@RequestBody Message message) {
        return ResponseEntity.ok(this.messageService.sendMessage(message));
    }
}