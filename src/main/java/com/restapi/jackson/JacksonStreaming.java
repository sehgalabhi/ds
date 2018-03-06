package com.restapi.jackson;

import com.fasterxml.jackson.core.*;

import java.io.File;
import java.io.IOException;

/**
 * Created by asehgal on 12/13/2017.
 */
public class JacksonStreaming {

    public static void main(String[] args) {
        new JacksonStreaming().test();
    }

    private void test() {
        JsonFactory jsonFactory = new JsonFactory();
        try {
            final JsonGenerator generator = jsonFactory.createGenerator(new File("student.json"), JsonEncoding.UTF8);

            generator.writeStartObject();;
            generator.writeStringField("name", "Mahesh Kumar");
            generator.writeNumberField("age",  21);

            generator.close();

            final JsonParser parser = jsonFactory.createParser(new File("student.json"));
            while (parser.nextToken() != JsonToken.END_OBJECT){
                final String currentName = parser.getCurrentName();

                System.out.println(currentName);
                System.out.println(parser.getText());
            }


        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
