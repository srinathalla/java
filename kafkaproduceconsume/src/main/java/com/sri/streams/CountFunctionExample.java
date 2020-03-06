package com.sri.streams;

import java.util.Properties;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.KafkaStreams;
import org.apache.kafka.streams.KeyValue;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.StreamsConfig;
import org.apache.kafka.streams.kstream.KStream;
import org.apache.kafka.streams.kstream.Produced;

public class CountFunctionExample {
	
	 public static void main(final String[] args) {
		    final String bootstrapServers = args.length > 0 ? args[0] : "localhost:9092";
		    final Properties streamsConfiguration = new Properties();
		    // Give the Streams application a unique name.  The name must be unique in the Kafka cluster
		    // against which the application is run.
		    streamsConfiguration.put(StreamsConfig.APPLICATION_ID_CONFIG, "count-lambda-example");
		    streamsConfiguration.put(StreamsConfig.CLIENT_ID_CONFIG, "count-lambda-example-client");
		    // Where to find Kafka broker(s).
		    streamsConfiguration.put(StreamsConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
		    // Specify default (de)serializers for record keys and for record values.
		    streamsConfiguration.put(StreamsConfig.DEFAULT_KEY_SERDE_CLASS_CONFIG, Serdes.String().getClass().getName());
		    streamsConfiguration.put(StreamsConfig.DEFAULT_VALUE_SERDE_CLASS_CONFIG, Serdes.String().getClass().getName());
		    // Set the commit interval to 500ms so that any changes are flushed frequently. The low latency
		    // would be important for anomaly detection.
		    streamsConfiguration.put(StreamsConfig.COMMIT_INTERVAL_MS_CONFIG, 10*1000);
		    streamsConfiguration.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");

		    final StreamsBuilder builder = new StreamsBuilder();	
		    final KStream<String, String> views = builder.stream("user_region");

		     views
		      // map the user name as key, because the subsequent counting is performed based on the key
		      .map((user, region) -> new KeyValue<>(region, region))
		      .groupByKey()
		      .count()
		      .toStream()
		      .filter((region,count) -> count >= 2)
		      .to("user_region_out", Produced.with(Serdes.String(), Serdes.Long()));

		    final KafkaStreams streams = new KafkaStreams(builder.build(), streamsConfiguration);
		    streams.cleanUp();
		    streams.start();

		    // Add shutdown hook to respond to SIGTERM and gracefully close Kafka Streams
		    Runtime.getRuntime().addShutdownHook(new Thread(streams::close));
		  }


}
