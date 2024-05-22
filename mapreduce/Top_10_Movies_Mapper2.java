package com.test.mapreduce.program;

import java.io.IOException;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class Top_10_Movies_Mapper2 extends Mapper<Object, Text, LongWritable, Text> {
	@Override
	protected void map(Object key, Text value, Mapper<Object, Text, LongWritable, Text>.Context context)
			throws IOException, InterruptedException {
		String[] split = value.toString().split(",");
		String name = split[0];
		long count = Integer.parseInt(split[1]);

		context.write(new LongWritable(count), new Text(name));
	
	}
}
