package com.test.mapreduce.program;

import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class Top_10_Movies_Reducer extends Reducer<LongWritable, Text, LongWritable, Text> {

	private TreeMap<Long, String> tmap2;

	@Override
	public void setup(Context context) throws IOException, InterruptedException {
		tmap2 = new TreeMap<Long, String>();
	}

	@Override
	public void reduce(LongWritable key, Iterable<Text> values, Context context)
			throws IOException, InterruptedException {

		// input data from mapper
		// key values
		// movie_name [ count ]
		// String name = key.toString();
		 long count = key.get();
		String name=null;
		for (Text val : values) {
			name += val.toString();
		}

		// insert data into treeMap,
		// we want top 10 viewed movies
		// so we pass count as key
		tmap2.put(count, name);

		// we remove the first key-value
		// if it's size increases 10
		// if (tmap2.size() > 10) {
		// tmap2.remove(tmap2.firstKey());
		// }
	}

	 @Override
	 public void cleanup(Context context) throws IOException, InterruptedException
	 {
	
	 for (Map.Entry<Long, String> entry : tmap2.entrySet()) {
	
	 long count = entry.getKey();
	 String name = entry.getValue();
	 context.write(new LongWritable(count), new Text(name));
	 }
	 }
}
