package streams.abhi.account;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.*;
import org.apache.kafka.streams.kstream.GlobalKTable;
import org.apache.kafka.streams.kstream.KStream;
import org.apache.kafka.streams.kstream.KeyValueMapper;
import org.apache.kafka.streams.kstream.ValueJoiner;

import java.util.Properties;
import java.util.concurrent.CountDownLatch;

public class FilterService {

    public static void main(String[] args) {
        new FilterService().process();
    }

    private void process() {

        ObjectMapper objectMapper = new ObjectMapper();
        Properties properties = new Properties();
        properties.put(StreamsConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        properties.put(StreamsConfig.APPLICATION_ID_CONFIG, "streams-filter-service4");
        properties.put(StreamsConfig.DEFAULT_KEY_SERDE_CLASS_CONFIG, Serdes.String().getClass());
        properties.put(StreamsConfig.DEFAULT_VALUE_SERDE_CLASS_CONFIG, Serdes.String().getClass());

        final StreamsBuilder streamsBuilder= new StreamsBuilder();

        GlobalKTable<String, String> table = streamsBuilder.globalTable("account-types");

        KStream<String, String> stream = streamsBuilder.stream("account-movements");

        stream.foreach((k,v) -> System.out.println("key :" + k + ", " + " value :" + v));

        KeyValueMapper<String, String, String> keyValueMapper =
                (key, value) -> key;

        ValueJoiner<String, String, String> valueJoiner =
                (v1, v2 ) ->  {
            String returnedVal = null;
            AccountMovementType accountMovementType =null;
                    try {
                        AccountMovement accountMovement = objectMapper.readValue(v1, AccountMovement.class);
                        AccountType accountType = objectMapper.readValue(v2, AccountType.class);
                        accountMovementType = new  AccountMovementType(accountMovement.getAccountId(), accountMovement.getAccountBal(),
                                accountMovement.getAccountIdentifier(),

                                accountType.getAccountName(), accountType.getAccountDesc());
                        returnedVal =  objectMapper.writeValueAsString(accountMovementType);
                    } catch (JsonProcessingException e) {
                        e.printStackTrace();
                    }
                   return returnedVal;
                };


        KStream<String, String> joinedStream = stream.join(table, keyValueMapper, valueJoiner);
        joinedStream.foreach((k,v) -> System.out.println("key :" + k + ", " + " value :" + v));

        joinedStream.to("filtered-account-movements");

        Topology topology = streamsBuilder.build();
        System.out.println(topology.describe());

        KafkaStreams kafkaStreams = new KafkaStreams(topology, properties);



        final CountDownLatch countDownLatch = new CountDownLatch(1);

        Runtime.getRuntime().addShutdownHook(new Thread("streams-shutdown-hook"){
            @Override
            public void run() {
                kafkaStreams.close();
                countDownLatch.countDown();
            }
        });

        try {
            kafkaStreams.start();

            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.exit(0);

    }
}
