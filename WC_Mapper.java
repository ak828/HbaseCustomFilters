package com.test.mapreduce.program;

import java.io.IOException;
import java.util.Arrays;
import java.util.StringTokenizer;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.MapReduceBase;
import org.apache.hadoop.mapred.Mapper;
import org.apache.hadoop.mapred.OutputCollector;
import org.apache.hadoop.mapred.Reporter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class WC_Mapper extends MapReduceBase implements Mapper<LongWritable, Text, Text, IntWritable> {
	static Logger logger = LoggerFactory.getLogger(WC_Mapper.class);
	private final static IntWritable one = new IntWritable(1);
	private Text word = new Text();

	@Override
	public void map(LongWritable key, Text value, OutputCollector<Text, IntWritable> output, Reporter reporter)
			throws IOException {
		String line = value.toString();
	
		logger.info("Line {}", line);
		String[] split = line.split(" ");
		logger.error("Mapper Split {}", Arrays.toString(split));

		
//		for (String s : split) {
//			word.set(s);
//			logger.info("Mapper Harshit opt {}", s);
//			output.collect(word, one);
//		}

		logger.info("Mapper Finished");
	}

}
