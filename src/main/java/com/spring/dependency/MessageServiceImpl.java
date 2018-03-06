package com.spring.dependency;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * Created by asehgal on 12/5/2017.
 */
@Component

public class MessageServiceImpl implements MessageService{
    @Override
    public String getMessage() {
        return "Hello World";
    }
}
