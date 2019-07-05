package com.kafka.kafkaconnect;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

import org.apache.kafka.connect.source.SourceRecord;
import org.apache.kafka.connect.source.SourceTask;

public class FileStreamSourceTask extends SourceTask {
  private String filename;
  private InputStream stream;
  private String topic;

  public void start(Map<String, String> props) {
    filename = props.get(FileStreamSourceConnector.FILE_CONFIG);
    stream = openOrThrowError(filename);
    topic = props.get(FileStreamSourceConnector.TOPIC_CONFIG);
  }

  @Override
  public synchronized void stop() {
    stream.close()
  }
