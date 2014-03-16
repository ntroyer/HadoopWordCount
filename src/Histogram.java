import org.apache.hadoop.fs.Path;
import org.apache.hadoop.conf.*;
import org.apache.hadoop.io.*;
import org.apache.hadoop.mapred.*;
import org.apache.hadoop.util.*;


public class Histogram extends Configured implements Tool{
	public int run(String[] args) throws Exception
    {
          //creating a JobConf object and assigning a job name for identification purposes
          JobConf conf = new JobConf(getConf(), Histogram.class);
          conf.setJobName("Histogram");

          //Setting configuration object with the Data Type of output Key and Value
          conf.setOutputKeyClass(Text.class);
          conf.setOutputValueClass(IntWritable.class);

          //Providing the mapper and reducer class names
          conf.setMapperClass(NodeCountMapper.class);
          conf.setReducerClass(NodeCountReducer.class);

          //the hdfs input and output directory to be fetched from the command line
          FileInputFormat.addInputPath(conf, new Path(args[0]));
          FileOutputFormat.setOutputPath(conf, new Path(args[1]));

          JobClient.runJob(conf);
          
          JobConf histConf = new JobConf(getConf(), Histogram.class);
          histConf.setJobName("Print Hist");
          
          histConf.setOutputKeyClass(Text.class);
          histConf.setOutputValueClass(IntWritable.class);
          
          histConf.setMapperClass(HistogramMapper.class);
          histConf.setReducerClass(NodeCountReducer.class);
          
          FileInputFormat.addInputPath(histConf, new Path(args[1]));
          FileOutputFormat.setOutputPath(histConf, new Path(args[2]));
          
          JobClient.runJob(histConf);
          return 0;
    }
	
	public static void main(String[] args) throws Exception
    {
          int res = ToolRunner.run(new Configuration(), new Histogram(),args);
          System.exit(res);
    }
	
}
