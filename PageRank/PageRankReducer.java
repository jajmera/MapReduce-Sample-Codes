import java.io.IOException;
import java.util.Iterator;

import org.apache.commons.lang.math.NumberUtils;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class PageRankReducer extends Reducer<Text,Text,Text,Text>{
	
	
	 public void reduce(Text key, Iterable<Text> values,Context context)
		      throws IOException, InterruptedException {
		 	
			String temp ="";
			double prob=0;

			for(Text value:values)
			{
				
				String temp2=value.toString();
				if(isNumber(temp2))
				{
					double page_prob=Double.parseDouble(temp2);
					prob+=page_prob;
				}
				else
				{
					temp=temp+temp2+" ";
				}
					
				
			}
				temp=temp+Double.toString(prob);
				context.write(key, new Text(temp));
			
		
	 
	 }
	 
	 public boolean isNumber(String val)
	 {
		 try
		 {
			 double d= Double.parseDouble(val);
		 }
		 catch(NumberFormatException e )
		 {
			 return false;
		 }
		 return true;
	 }
	}


