package com.test.mapreduce.program;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class FrequetlyUsedQueryMapper extends Mapper<Object, Text, Text, IntWritable> {
	@Override
	protected void map(Object key, Text value, Mapper<Object, Text, Text, IntWritable>.Context context)
			throws IOException, InterruptedException {
		// suppose cuurent time is 6pm and we want only two hours data
		int time = 6;
		String[] split = value.toString().split(",");
		String qry = split[0];
		int val = Integer.parseInt(split[1]);
		if ((time-val) < 3) {
			context.write(new Text(qry), new IntWritable(1));
		}

	}
}
