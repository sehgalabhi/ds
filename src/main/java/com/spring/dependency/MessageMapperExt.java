package com.spring.dependency;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

/**;
 * Created by asehgal on 12/12/2017.
 */
@Component
@Primary
public class MessageMapperExt extends MessageMapper{
    public String getValue(){
        return "Ext";
    }

}
