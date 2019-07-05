package com.hadoop;

import java.io.IOException;

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

public class SubPatents {

	
	public static void main(String[] args) throws Exception {
		Configuration c = new Configuration();
		// String[] files = new GenericOptionsParser(c, args).getRemainingArgs();
		Path input = new Path(args[0]);
		Path output = new Path(args[1]);
		Job j = new Job(c, "SubPatents");
		j.setJarByClass(SubPatents.class);
		j.setMapperClass(MapForSubPatents.class);
		j.setReducerClass(ReduceForSubPatents.class);
		j.setOutputKeyClass(IntWritable.class);
		j.setOutputValueClass(IntWritable.class);
		FileInputFormat.addInputPath(j, input);
		FileOutputFormat.setOutputPath(j, output);
		System.exit(j.waitForCompletion(true) ? 0 : 1);
	}

	public static class MapForSubPatents extends Mapper<LongWritable, Text, IntWritable, IntWritable> {
		
		public void map(LongWritable key, Text value, Context con) throws IOException, InterruptedException {
			System.out.println("value :" + value);
			String line = value.toString().trim();
			String[] words = line.split(" ");
			for (String word : words) {
				 if(!word.contains("."))
				 {
					int patent = Integer.valueOf(word);
					IntWritable outputKey = new IntWritable(patent);
					IntWritable outputValue = new IntWritable(1);
					con.write(outputKey, outputValue);
				 }
			}
		}
	}

	public static class ReduceForSubPatents extends Reducer<IntWritable, IntWritable, IntWritable, IntWritable> {
		
		public void reduce(IntWritable word, Iterable<IntWritable> values, Context con)
				throws IOException, InterruptedException {
			int sum = 0;
			for (IntWritable value : values) {
				sum += value.get();
			}
			con.write(word, new IntWritable(sum));
		}
	}
}
