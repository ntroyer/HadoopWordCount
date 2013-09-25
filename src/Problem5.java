import org.apache.hadoop.fs.Path;
import org.apache.hadoop.conf.*;
import org.apache.hadoop.io.*;
import org.apache.hadoop.mapred.*;
import org.apache.hadoop.util.*;

public class Problem5 extends Configured implements Tool{
	public int run(String[] args) throws Exception
    {
          JobConf conf = new JobConf(getConf(), Problem5.class);
          conf.setJobName("Histogram");

          conf.setOutputKeyClass(Text.class);
          conf.setOutputValueClass(IntWritable.class);

          conf.setMapperClass(Problem5Mapper.class);
          conf.setReducerClass(Problem5Reducer.class);

          FileInputFormat.addInputPath(conf, new Path(args[0]));
          FileOutputFormat.setOutputPath(conf, new Path(args[1]));

          JobClient.runJob(conf);
          
          /*
          JobConf bamf = new JobConf(getConf(), Histogram.class);
          bamf.setJobName("Print Hist");
          
          bamf.setOutputKeyClass(Text.class);
          bamf.setOutputValueClass(IntWritable.class);
          
          bamf.setMapperClass(HistogramMapper.class);
          bamf.setReducerClass(NodeCountReducer.class);
          
          FileInputFormat.addInputPath(bamf, new Path(args[1]));
          FileOutputFormat.setOutputPath(bamf, new Path(args[2]));
          
          JobClient.runJob(bamf);*/
          return 0;
    }
	
	public static void main(String[] args) throws Exception
    {
          int res = ToolRunner.run(new Configuration(), new Problem5(),args);
          System.exit(res);
    }
	
}
