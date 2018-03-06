package com.restapi.jackson;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

/**
 * Created by asehgal on 12/13/2017.
 */
public class JacksonUse {

    public static void main(String[] args) {
        new JacksonUse().test();
    }

    private void test() {
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonString = "{\"name\":\"Mahesh\", \"age\":21}";

        try {
            final Student student = objectMapper.readValue(jsonString, Student.class);

            System.out.println(student);
            jsonString = objectMapper.writeValueAsString(student);
            System.out.println(jsonString);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}
