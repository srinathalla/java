package com.hadoop;

import java.io.IOException;
import java.util.logging.Logger;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

public class MaxTemperature {
	
	
	private static Logger logger = Logger.getAnonymousLogger();
	
	public static void main(String[] args) throws Exception {
	
		// String[] files = new GenericOptionsParser(c, args).getRemainingArgs();
		Path input = new Path(args[0]);
		Path output = new Path(args[1]);
		Job j = Job.getInstance();
		j.setJobName("MaxTemperature");
		
		j.setJarByClass(MaxTemperature.class);
		j.setMapperClass(MapForMaxTemperature.class);
		j.setReducerClass(ReduceForMaxTemperature.class);
		j.setOutputKeyClass(IntWritable.class);
		j.setOutputValueClass(IntWritable.class);
		FileInputFormat.addInputPath(j, input);
		FileOutputFormat.setOutputPath(j, output);
		System.exit(j.waitForCompletion(true) ? 0 : 1);
	}

	public static class MapForMaxTemperature extends Mapper<LongWritable, Text, IntWritable, IntWritable> {
		
		public void map(LongWritable key, Text value, Context con) throws IOException, InterruptedException {
			logger.info("value :" + value);
			
			String line = value.toString().trim();
			String[] words = line.split(" ");
		
			 if(words.length == 2)
			 {		
				IntWritable outputKey = new IntWritable(Integer.valueOf(words[0]));
				IntWritable outputValue = new IntWritable(Integer.valueOf(words[1]));
				con.write(outputKey, outputValue);
			 }
			
		}
	}

	public static class ReduceForMaxTemperature extends Reducer<IntWritable, IntWritable, IntWritable, IntWritable> {
		
		public void reduce(IntWritable year, Iterable<IntWritable> values, Context con)
				throws IOException, InterruptedException {
			int max = 0;
			for (IntWritable value : values) {
				max = Math.max(max, value.get());
			}
			con.write(year, new IntWritable(max));
		}
	}

}
