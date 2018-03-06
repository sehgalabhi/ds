package com.spring.dependency;

import org.springframework.stereotype.Component;

/**
 * Created by asehgal on 12/12/2017.
 */
@Component
public class MessageMapper {

    public String getValue(){
        return "Original";
    }
}
