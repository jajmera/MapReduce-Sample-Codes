import java.io.IOException;

import org.apache.hadoop.io.*;
import org.apache.hadoop.mapred.OutputCollector;
import org.apache.hadoop.mapred.Reporter;
import org.apache.hadoop.mapreduce.Mapper;

public class PageRankMapper extends Mapper<LongWritable,Text,Text,Text> {
	
	
	
	
	public void map(LongWritable key, Text value,Context context) throws IOException,InterruptedException
	{
		String line = value.toString();
		String pages[]=line.split(" ");
		double prob = Double.parseDouble(pages[pages.length-1])/(pages.length-2);
		String newString="";
		for(int i=1;i<pages.length-1;i++)
		{
			context.write(new Text(pages[i]),new Text(Double.toString(prob)));
			newString=newString+" "+pages[i];	
		}
	    context.write(new Text(pages[0]),new Text(newString));
	}

}
