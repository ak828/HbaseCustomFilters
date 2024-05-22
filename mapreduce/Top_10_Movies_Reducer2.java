package com.test.mapreduce.program;

import java.io.IOException;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class Top_10_Movies_Reducer2 extends Reducer<LongWritable, Text, LongWritable, Text> {
	static int count;

	@Override
	public void setup(Context context) throws IOException, InterruptedException {
		count = 0;
	}

	@Override
	protected void reduce(LongWritable key, Iterable<Text> values,
			Reducer<LongWritable, Text, LongWritable, Text>.Context context) throws IOException, InterruptedException {
		long no_of_views = (-1) * key.get();

		String movie_name = null;

		for (Text val : values) {
			movie_name = val.toString();
		}
		if (count < 10) {
			context.write(new LongWritable(no_of_views), new Text(movie_name));
			count++;
		}
	}
}
