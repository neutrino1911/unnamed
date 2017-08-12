package ru.security59.unnamed.controller.entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import ru.security59.unnamed.entities.Message;
import ru.security59.unnamed.service.MessageService;
import ru.security59.unnamed.service.UserService;

import java.util.Date;

@Controller
public class MessageWSController {

    private final MessageService messageService;

    private final UserService userService;


    @Autowired
    public MessageWSController(MessageService messageService, UserService userService) {
        this.messageService = messageService;
        this.userService = userService;
    }

    @MessageMapping("/hello")
    @SendTo("/topic/greetings")
    public Message greeting(String text) throws Exception {
        Message message = new Message();
        message.setText(text);
        message.setDate(new Date());
        return message;
    }

}
