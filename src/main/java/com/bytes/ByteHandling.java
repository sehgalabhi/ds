package com.bytes;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class ByteHandling {

    public static void main(String[] args) {
        try(FileInputStream fileInputStream = new FileInputStream(new File("D:\\Personal\\Supercity\\July2016 Payment.PNG"));
            FileOutputStream fileOutputStream = new FileOutputStream(new File("D:\\Personal\\Supercity\\July2016 Payment_copy.PNG"))){
            int data;
            while ((data = fileInputStream.read()) != -1){
                fileOutputStream.write(data);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
