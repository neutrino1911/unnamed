package ru.security59.unnamed.controller.entity;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ru.security59.unnamed.entities.Message;
import ru.security59.unnamed.service.AbstractEntityService;
import ru.security59.unnamed.service.MessageService;
import ru.security59.unnamed.service.UserService;

import java.util.List;

@RestController
@RequestMapping(path = "/messages")
public class MessageController extends AbstractEntityController<Message> {

    private final MessageService messageService;

    private final UserService userService;


    public MessageController(AbstractEntityService<Message> entityService, MessageService messageService, UserService userService) {
        super(entityService);
        this.messageService = messageService;
        this.userService = userService;
    }

    @RequestMapping(path = "/getByUserId/{userId}", method = RequestMethod.GET)
    public List<Message> getMessages(@PathVariable Long userId) {
        List<Message> messages = messageService.getByUserId(userId);
        return messages;
    }
}
