import org.apache.hadoop.fs.Path;
import org.apache.hadoop.conf.*;
import org.apache.hadoop.io.*;
import org.apache.hadoop.mapred.*;
import org.apache.hadoop.util.*;

public class Problem5b extends Configured implements Tool{
	public int run(String[] args) throws Exception
    {
          JobConf conf = new JobConf(getConf(), Problem5b.class);
          conf.setJobName("Print Hist");

          conf.setOutputKeyClass(Text.class);
          conf.setOutputValueClass(IntWritable.class);

          conf.setMapperClass(Problem5bMapper.class);
          conf.setReducerClass(Problem5bReducer.class);

          FileInputFormat.addInputPath(conf, new Path(args[0]));
          FileOutputFormat.setOutputPath(conf, new Path(args[1]));

          JobClient.runJob(conf);
          return 0;
    }
	
	public static void main(String[] args) throws Exception
    {
          int res = ToolRunner.run(new Configuration(), new Problem5b(),args);
          System.exit(res);
    }
	
}
