import java.io.IOException;
import java.util.StringTokenizer;
import org.apache.hadoop.io.*;
import org.apache.hadoop.mapreduce.Mapper;

public class WordCountMapper extends  Mapper<LongWritable, Text, Text, IntWritable> {
	
	private static final IntWritable one = new IntWritable(1);
	private Text word = new Text();
	private String[] words={"hackathon","dec","chicago","java"};
	
  public void map(LongWritable key, Text value, Context context)
      throws IOException, InterruptedException {
	
	  String line= value.toString().toLowerCase();
	 
	  for(int i=0;i<words.length;i++)
	  {
		  context.write(new Text(words[i]), new IntWritable(0));
		if(line.contains(words[i]))
			context.write(new Text(words[i]),one);
		
		  
	  }
	  
		 
	 
	  
    /*
     * TODO implement
     */

  }
}
