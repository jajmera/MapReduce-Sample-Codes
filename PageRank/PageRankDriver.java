import org.apache.hadoop.mapred.JobConf;
import org.apache.hadoop.mapred.Reducer;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.fs.Path;
public class PageRankDriver {

  public static void main(String[] args) throws Exception {

	  if(args.length !=2){
		  System.err.println("Please enter a value");
		  System.exit(-1);
		  
	  }
	  Job job=new Job();
	 job.setJarByClass(PageRankDriver.class);
	  job.setJobName("PageRank");
	  FileInputFormat.addInputPath(job, new Path(args[0]));
	  FileOutputFormat.setOutputPath(job, new Path(args[1]));
	  job.setMapperClass(PageRankMapper.class);
	  job.setReducerClass(PageRankReducer.class);
	  job.setOutputKeyClass(Text.class);
	  job.setOutputValueClass(Text.class);
	  System.exit(job.waitForCompletion(true)? 0 : 1);
      }
}

