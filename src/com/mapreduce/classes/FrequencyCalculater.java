package com.mapreduce.classes;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class FrequencyCalculater extends
		Reducer<Text, IntWritable, Text, IntWritable> {
	private IntWritable result = new IntWritable();

	public void reduce(Text key, Iterable<IntWritable> values, Context context)
			throws IOException, InterruptedException {
		int sum = 0;

		//System.out.println("--> In the reducer. key = " + key.toString());

		for (IntWritable val : values) {
			
			if (!val.equals(null))
				sum += val.get();

			
		}

		result.set(sum);

		context.write(key, result);
	}
}
