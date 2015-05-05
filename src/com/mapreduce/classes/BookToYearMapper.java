package com.mapreduce.classes;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class BookToYearMapper extends Mapper<Object, Text, Text, IntWritable> {

	private final static IntWritable one = new  IntWritable(1);
	private Text yearOfPublication;

	public void map(Object key, Text value, Context context)
			throws IOException, InterruptedException {

		String[] fields = value.toString().split("\";\"");
		if (fields[3].length() == 4){
		yearOfPublication = new Text(fields[3]);
		context.write(yearOfPublication, one);}
	}
}
