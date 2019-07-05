package com.kafka.kafkaconnect;

import java.util.Properties;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;

/**
 * Hello world!
 *
 */
public class KafkaProducerClient 
{
    public static void main( String[] args )
    {
        Properties props = new Properties();
        
        props.setProperty("bootstrap.servers", "127.0.0.1:9092");
        props.setProperty("key.serializer", StringSerializer.class.getName());
        props.setProperty("value.serializer", StringSerializer.class.getName());
        props.setProperty("acks", "1");
        props.setProperty("retries", "3");
        props.setProperty("linger.ms", "1");
        
        try(Producer<String , String> producer = new KafkaProducer<>(props))
        {
	        ProducerRecord<String,String> record = new ProducerRecord<>("first_topic","1","Java Producer test_4");  
	        producer.send(record);
        }
       
       
    }
}
