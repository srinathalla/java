package com.kafka.kafkaconnect;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.kafka.common.config.ConfigDef;
import org.apache.kafka.common.config.ConfigDef.Importance;
import org.apache.kafka.connect.connector.Task;
import org.apache.kafka.connect.source.SourceConnector;

public class FileStreamSourceConnector  extends SourceConnector
{
	private static final ConfigDef CONFIG_DEF = new ConfigDef()
		    .define(FILE_CONFIG, Type.STRING, Importance.HIGH, "Source filename.")
		    .define(TOPIC_CONFIG, Type.STRING, Importance.HIGH, "The topic to publish data to");

		public ConfigDef config() {
		    return CONFIG_DEF;
		}
		
		
    private static final String FILE_CONFIG = null;
	private String filename;
    private String topic;

	@Override
	public ConfigDef config() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void start(Map<String, String> arg0) {
		 // The complete version includes error handling as well.
	    filename = props.get(FILE_CONFIG);
	    topic = props.get(TOPIC_CONFIG);
		
	}

	@Override
	public void stop() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Class<? extends Task> taskClass() {
	    return FileStreamSourceTask.class;
	}

	@Override
	public List<Map<String, String>> taskConfigs(int arg0) {
		 ArrayList<Map<String, String>> configs = new ArrayList<>();
		    // Only one input stream makes sense.
		    Map<String, String> config = new HashMap<>();
		    if (filename != null)
		        config.put(FILE_CONFIG, filename);
		    config.put(TOPIC_CONFIG, topic);
		    configs.add(config);
		    return configs;
	}

	@Override
	public String version() {
		// TODO Auto-generated method stub
		return null;
	}

}
