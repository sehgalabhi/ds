package streams.abhi.account;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Properties;

public class AccountMovementsAndTypeProducer {






    public static void main(String[] args) throws IOException {
        AccountMovementsAndTypeProducer accountMovementsAndTypeProducer = new AccountMovementsAndTypeProducer();
        accountMovementsAndTypeProducer.produce();
    }


    private void produce() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        AccountMovement[] accountMovements = objectMapper.readValue(
                new File(this.getClass().getClassLoader().getResource("movements.json").getFile()), AccountMovement[].class);

        Arrays.stream(accountMovements).forEach(System.out::println);

        AccountType[] accountTypes = objectMapper.readValue(new File(this.getClass().getClassLoader().getResource("accounttypes.json").getFile()),
                AccountType[].class);
        Arrays.stream(accountTypes).forEach(System.out::println);



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

        producer.send(new ProducerRecord<String, String>("account-movements",
                accountMovements[1].getAccountId(), objectMapper.writeValueAsString(accountMovements[1])));

//        Arrays.stream(accountMovements).forEach(t -> producer.send(new ProducerRecord<String,
//                String>("account-movements", t.getAccountId(), t.toString())));

        producer.close();

    }
}
