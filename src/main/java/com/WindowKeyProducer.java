package streams.abhi.account;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Properties;

public class WindowKeyProducer {






    public static void main(String[] args) throws IOException, InterruptedException {
        WindowKeyProducer accountMovementsAndTypeProducer = new WindowKeyProducer();
        accountMovementsAndTypeProducer.produce();
    }


    private void produce() throws IOException, InterruptedException {
        ObjectMapper objectMapper = new ObjectMapper();
        AccountMovementType[] accountMovements = objectMapper.readValue(
                new File(this.getClass().getClassLoader().getResource("filteredmovements.json").getFile()), AccountMovementType[].class);

        Arrays.stream(accountMovements).forEach(System.out::println);



        Properties props = new Properties();
        props.put("bootstrap.servers", "localhost:9092");
        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");

        Producer<String, String> producer = new KafkaProducer<>(props);
 /*       Arrays.stream(accountTypes).forEach(t -> {
            try {
                producer.send(new ProducerRecord<String,
                        String>("account-types", t.getAccountId(), objectMapper.writeValueAsString(t)));
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
        });*/

        // accountTypes[1].setAccountName("Changed Name");
        //        producer.send(new ProducerRecord<String, String>("account-types",
        //                accountTypes[1].getAccountId(), objectMapper.writeValueAsString(accountTypes[1])));


        producer.send(new ProducerRecord<String, String>("filtered-account-movements",
                "1", "2"));
        Thread.sleep(10000);
        producer.send(new ProducerRecord<String, String>("filtered-account-movements",
                "1", "3"));
        producer.send(new ProducerRecord<String, String>("filtered-account-movements",
                "2", "3"));
        Thread.sleep(10000);
        producer.send(new ProducerRecord<String, String>("filtered-account-movements",
                "1", "4"));
        Thread.sleep(10000);
        producer.send(new ProducerRecord<String, String>("filtered-account-movements",
                "1", "5"));
        producer.send(new ProducerRecord<String, String>("filtered-account-movements",
                "2", "5"));
        Thread.sleep(10000);

        producer.send(new ProducerRecord<String, String>("filtered-account-movements",
                "1", "6"));
        Thread.sleep(10000);
        producer.send(new ProducerRecord<String, String>("filtered-account-movements",
                "1", "7"));
        Thread.sleep(10000);
        producer.send(new ProducerRecord<String, String>("filtered-account-movements",
                "1", "8"));


//        Arrays.stream(accountMovements).forEach(t -> producer.send(new ProducerRecord<String,
//                String>("account-movements", t.getAccountId(), t.toString())));

        producer.close();

    }
}
