package streams.abhi.account;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.common.utils.Bytes;
import org.apache.kafka.streams.KafkaStreams;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.StreamsConfig;
import org.apache.kafka.streams.Topology;
import org.apache.kafka.streams.kstream.*;
import org.apache.kafka.streams.state.WindowStore;

import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.CountDownLatch;

public class TumblingWindowConsumer {

    public static void main(String[] args) {
        new TumblingWindowConsumer().process();
    }

    private void process() {
        ObjectMapper objectMapper = new ObjectMapper();
        Properties properties = new Properties();
        properties.put(StreamsConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        properties.put(StreamsConfig.APPLICATION_ID_CONFIG, "streams-business-service1");
        properties.put(StreamsConfig.DEFAULT_KEY_SERDE_CLASS_CONFIG, Serdes.String().getClass());
        properties.put(StreamsConfig.DEFAULT_VALUE_SERDE_CLASS_CONFIG, Serdes.String().getClass());

        final StreamsBuilder streamsBuilder= new StreamsBuilder();

        Duration windowSizeMs = Duration.ofMinutes(1);
        TimeWindows.of(windowSizeMs);

        KStream<String, String> stream = streamsBuilder.stream("filtered-account-movements");

        KGroupedStream<String, String> groupedStream = stream.groupByKey();

        stream.foreach((k,v) -> System.out.println("key :" + k + ", " + " value :" + v));
//

        Aggregator<String, String, Long>  aggregator = (aggKey, newValue, aggValue) -> {
            AccountMovementType accountMovementType = null;
            try {
                accountMovementType = objectMapper.readValue(newValue, AccountMovementType.class);
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }

            return aggValue + Long.valueOf(accountMovementType.getAccountBal());
        };

   //     System.out.println(groupedStream.count());

       /* final KStream<Windowed<String>, Long> windowedLongKStream = groupedStream.windowedBy(TimeWindows.of(Duration.ofSeconds(30)))
                .aggregate(
                        () -> 0L,
                        aggregator
                )
                .suppress(Suppressed.untilWindowCloses(Suppressed.BufferConfig.unbounded()))
                .toStream();*/

      // groupedStream.count().toStream().foreach((key, aggValue) -> System.out.println("Grouped key "+ key + " value" + aggValue));
       KTable<Windowed<String>, Long> count = groupedStream.windowedBy(TimeWindows.of(Duration.ofSeconds(30)))
                .count(Materialized.<String, Long, WindowStore<Bytes, byte[]>>as("time-windowed-store")
                        .withCachingDisabled().withValueSerde(Serdes.Long()));

        count.toStream().foreach((key, aggValue) -> System.out.println("Windowed group key "+ key+ " value" + aggValue));

//         count.suppress(Suppressed.untilWindowCloses(Suppressed.BufferConfig.unbounded()))
//         .toStream()
//                 .foreach((key, val) -> System.out.println("Windowed key "+ key + " value" + val));;

       // suppress.toStream().foreach((key, aggValue) -> System.out.println("Windowed suppressed group key "+ key.key() + " value" + aggValue));
     /*  groupedStream.windowedBy(TimeWindows.of(Duration.ofSeconds(20)))
                .count(Materialized.<String, Long, WindowStore<Bytes, byte[]>>as("time-windowed-aggregated-stream-store") *//* state store name *//*
                        .withCachingDisabled().withValueSerde(Serdes.Long()))
               .suppress(Suppressed.untilWindowCloses(Suppressed.BufferConfig.unbounded()))
            //   .suppress(Suppressed.untilTimeLimit(Duration.ofSeconds(20), Suppressed.BufferConfig.unbounded()))

                .filter((windowedKey, count) -> count >0 )
                .toStream()
               .foreach((key, count) -> System.out.println("Windowed key "+ key + " value" + count));

*/
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
