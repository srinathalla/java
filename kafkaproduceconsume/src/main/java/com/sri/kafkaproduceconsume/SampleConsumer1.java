package com.sri.kafkaproduceconsume;

import java.util.Arrays;
import java.util.Properties;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

public class SampleConsumer1 {
	
	public static void main(String[] args) throws Exception {
	     /* if(args.length == 0){
	         System.out.println("Enter topic name");
	         return;
	      }*/
	      //Kafka consumer configuration settings
		  String topicName = "employee_topic";
	      Properties props = new Properties();
	      
	      props.put("bootstrap.servers", "10.8.163.111:9092");
	      props.put("group.id", "employee_consumer");
	      props.put("enable.auto.commit", "true");
	      props.put("auto.commit.interval.ms", "1000");
	      props.put("session.timeout.ms", "30000");
	      props.put("key.deserializer", 
	         "org.apache.kafka.common.serialization.StringDeserializer");
	      props.put("value.deserializer", 
	         "org.apache.kafka.common.serialization.StringDeserializer");
	      KafkaConsumer<String, String> consumer = new KafkaConsumer
	         <String, String>(props);
	      
	     // TopicPartition partition2 = new TopicPartition(topicName, 2);
         //	TopicPartition partition1 = new TopicPartition(topicName, 1);
	     // consumer.assign(Arrays.asList(partition2));
	      
	      //Kafka Consumer subscribes list of topics here.
	       consumer.subscribe(Arrays.asList(topicName));      
	      
	      //print the topic name
	      System.out.println("Subscribed to topic " + topicName + "for partions :" +  consumer.assignment());
	      int i = 0;
	      
	      while (true) {
	         ConsumerRecords<String, String> records = consumer.poll(100);
	         for (ConsumerRecord<String, String> record : records)
	         
	         // print the offset,key and value for the consumer records.
	         System.out.printf(" c1, offset = %d, key = %s, partition = %d, value = %s \n", 
	            record.offset(), record.key(),  record.partition(),record.value());
	      }
	   }

}
