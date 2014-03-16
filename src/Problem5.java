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
          
          return 0;
    }
	
	public static void main(String[] args) throws Exception
    {
          int res = ToolRunner.run(new Configuration(), new Problem5(),args);
          System.exit(res);
    }
	
}
