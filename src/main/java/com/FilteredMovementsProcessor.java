package streams.abhi.account;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Locale;
import java.util.Properties;

public class FilteredMovementsProcessor {






    public static void main(String[] args) throws IOException {
        FilteredMovementsProcessor accountMovementsAndTypeProducer = new FilteredMovementsProcessor();
        accountMovementsAndTypeProducer.produce();
    }


    private void produce() throws IOException {
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

        int i =0;
        for (AccountMovementType accountMovementType: accountMovements){
            System.out.println("Sending the movement at time " + LocalDateTime.now());
            producer.send(new ProducerRecord<String, String>("filtered-account-movements",
                    accountMovements[i].getAccountId(), objectMapper.writeValueAsString(accountMovements[i])));
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //i++;

        }


//        Arrays.stream(accountMovements).forEach(t -> producer.send(new ProducerRecord<String,
//                String>("account-movements", t.getAccountId(), t.toString())));

        producer.close();

    }
}
