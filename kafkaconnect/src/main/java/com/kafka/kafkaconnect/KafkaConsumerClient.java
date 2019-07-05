package com.kafka.kafkaconnect;

import java.util.Arrays;
import java.util.Properties;

import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.StringDeserializer;

public class KafkaConsumerClient {
	
	public static void main( String[] args )
    {
        Properties props = new Properties();
        
        props.setProperty("bootstrap.servers", "127.0.0.1:9092");
        props.setProperty("key.deserializer", StringDeserializer.class.getName());
        props.setProperty("value.deserializer", StringDeserializer.class.getName());
        props.setProperty("group.id", "test");
        props.setProperty("enable.auto.commit", "true");
        props.setProperty("auto.commit.interval.ms", "1000");
        props.setProperty("auto.offset.reset","earliest");
        
        try(Consumer<String , String> consumer = new KafkaConsumer<>(props))
        {
	        consumer.subscribe(Arrays.asList("first_topic"));
	        
	        while(true)
	        {
	        	ConsumerRecords<String, String> records = consumer.poll(100);
	        	
	        	for (ConsumerRecord<String, String> record : records)
	        	{
	        		System.out.print("Key :" + record.key());
	        		System.out.println("Value:" + record.value());
	        		System.out.println("Offset:" + record.offset());
	        		System.out.println("Partitio:" + record.partition());
	        		System.out.println("Topic:" + record.topic());
	        		System.out.println("Timestamp:" + record.timestamp());
	        		System.out.println();
	        	}
	        }
        }
       
       
    }

}
