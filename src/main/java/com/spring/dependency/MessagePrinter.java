package com.spring.dependency;

import org.springframework.stereotype.Component;

import javax.inject.Inject;

/**
 * Created by asehgal on 12/5/2017.
 */
@Component
public class MessagePrinter {

    @Inject
    private MessageService messageServiceImpl;

    @Inject
    private MessageMapper messageMapper;

    public void printMessage(){
        System.out.println(this.messageServiceImpl.getMessage());
        System.out.println(messageMapper.getValue());
    }


}
