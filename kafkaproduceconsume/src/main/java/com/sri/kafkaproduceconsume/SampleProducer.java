package com.sri.kafkaproduceconsume;

import java.util.Properties;

//import KafkaProducer packages
import org.apache.kafka.clients.producer.KafkaProducer;
//import simple producer packages
import org.apache.kafka.clients.producer.Producer;
//import ProducerRecord packages
import org.apache.kafka.clients.producer.ProducerRecord;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class SampleProducer {
	
	private String getEmloyeeJson(int i)
	{

		Employee emp = new Employee();
		emp.setName("sri" + i);
		emp.setAge(10 * i);
		emp.setId(i);

		Gson gson = new GsonBuilder().setPrettyPrinting().create();

		return gson.toJson(emp);
	}
	
	private void sendToEmployeeTopic()
	{
		  //Assign topicName to string variable
	      String topicName = "employee_topic";
	      
	      // create instance for properties to access producer configs   
	      Properties props = new Properties();
	      
	      //Assign localhost id
	      props.put("bootstrap.servers", "localhost:9092");
	      
	      //Set acknowledgements for producer requests.      
	      props.put("acks", "all");
	      
	      //If the request fails, the producer can automatically retry,
	      props.put("retries", 0);
	      
	      //Specify buffer size in config
	      props.put("batch.size", 16384);
	      
	      //Reduce the no of requests less than 0   
	      props.put("linger.ms", 1);
	      
	      //The buffer.memory controls the total amount of memory available to the producer for buffering.   
	      props.put("buffer.memory", 33554432);
	      
	      props.put("key.serializer", 
	         "org.apache.kafka.common.serialization.StringSerializer");
	         
	      props.put("value.serializer", 
	         "org.apache.kafka.common.serialization.StringSerializer");
	      
	      Producer<String, String> producer = new KafkaProducer
	         <String, String>(props);
	            
	      for(long i = 0; i < 10000; i = i + 1)
	      { 
    	     String msg = getEmloyeeJson((int)i);
	         producer.send(new ProducerRecord<String, String>(topicName, 
	            (int)(i % 3), "" + i, msg));
	      }
	      
           System.out.println("Message sent successfully");
           producer.close();
	}
	
	public static void main(String[] args) throws Exception{
	      
	      // Check arguments length value
		SampleProducer sampleProducer = new SampleProducer();
		
		sampleProducer.sendToEmployeeTopic();
		
	   }

}
