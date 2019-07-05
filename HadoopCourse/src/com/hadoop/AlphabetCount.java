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

import com.hadoop.WordCount.ReduceForWordCount;

public class AlphabetCount {
	
	
	public static void main(String[] args) throws Exception {
		Configuration c = new Configuration();
		// String[] files = new GenericOptionsParser(c, args).getRemainingArgs();
		Path input = new Path(args[0]);
		Path output = new Path(args[1]);
		Job j = new Job(c, "AlphabetCount");
		j.setJarByClass(AlphabetCount.class);
		j.setMapperClass(MapForAlphabetCount.class);
		j.setReducerClass(ReduceForAlphabetCount.class);
		j.setOutputKeyClass(IntWritable.class);
		j.setOutputValueClass(IntWritable.class);
		FileInputFormat.addInputPath(j, input);
		FileOutputFormat.setOutputPath(j, output);
		System.exit(j.waitForCompletion(true) ? 0 : 1);
	}

	public static class MapForAlphabetCount extends Mapper<LongWritable, Text, IntWritable, IntWritable> {
		
		public void map(LongWritable key, Text value, Context con) throws IOException, InterruptedException {
			String line = value.toString();
			String[] words = line.split(" ");
			for (String word : words) {
				 if(!word.trim().isEmpty())
				 {
					word = word.replace(".", "");
					IntWritable outputKey = new IntWritable(word.length());
					IntWritable outputValue = new IntWritable(1);
					con.write(outputKey, outputValue);
				 }
			}
		}
	}

	public static class ReduceForAlphabetCount extends Reducer<IntWritable, IntWritable, IntWritable, IntWritable> {
		
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
