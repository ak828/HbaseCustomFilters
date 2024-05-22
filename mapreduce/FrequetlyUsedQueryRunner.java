package com.test.mapreduce.program;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.util.GenericOptionsParser;

// this alos aplies for first 10 urls frequntly visited
public class FrequetlyUsedQueryRunner {

	public static void main(String[] args) throws Exception {
		Configuration conf = new Configuration();
		String[] otherArgs = new GenericOptionsParser(conf, args).getRemainingArgs();

		// if less than two paths
		// provided will show error
		if (otherArgs.length < 2) {
			System.err.println("Error: please provide two paths");
			System.exit(2);
		}

		Job job = Job.getInstance(conf, "top 10");
		job.setJarByClass(FrequetlyUsedQueryRunner.class);

		job.setMapperClass(FrequetlyUsedQueryMapper.class);
		job.setReducerClass(FrequetlyUsedQueryReducer.class);

		job.setMapOutputKeyClass(Text.class);
		job.setMapOutputValueClass(IntWritable.class);

		job.setOutputKeyClass(Text.class);
		job.setOutputValueClass(IntWritable.class);

		FileInputFormat.addInputPath(job, new Path(otherArgs[0]));
		FileOutputFormat.setOutputPath(job, new Path(otherArgs[1]));

		System.exit(job.waitForCompletion(true) ? 0 : 1);
	}

}
