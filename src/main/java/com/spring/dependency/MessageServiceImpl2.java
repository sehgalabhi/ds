package com.spring.dependency;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

/**
 * Created by asehgal on 12/5/2017.
 */
@Component
@Primary
public class MessageServiceImpl2 implements MessageService {
    @Override
    public String getMessage() {
        return "new world";
    }
}
