package com.test.mapreduce.program;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class FrequetlyUsedQueryReducer extends Reducer<Text, IntWritable, Text, IntWritable> {
	private TreeMap<Integer, String> tmap2;

	@Override
	protected void reduce(Text key, Iterable<IntWritable> values,
			org.apache.hadoop.mapreduce.Reducer<Text, IntWritable, Text, IntWritable>.Context context)
			throws IOException, InterruptedException {

		Iterator<IntWritable> iterator = values.iterator();
		int sum = 0;
		while (iterator.hasNext()) {
			sum += iterator.next().get();
		}

		tmap2.put(sum, key.toString());

		if (tmap2.size() > 2) {
			tmap2.remove(tmap2.firstKey());
		}

	}

	@Override
	protected void setup(Reducer<Text, IntWritable, Text, IntWritable>.Context context)
			throws IOException, InterruptedException {
		tmap2 = new TreeMap<Integer, String>();
	}

	@Override
	protected void cleanup(Reducer<Text, IntWritable, Text, IntWritable>.Context context)
			throws IOException, InterruptedException {

		for (Map.Entry<Integer, String> e : tmap2.entrySet()) {
			Integer key = e.getKey();
			String value = e.getValue();
			context.write(new Text(value), new IntWritable(key));
		}
	}

}
