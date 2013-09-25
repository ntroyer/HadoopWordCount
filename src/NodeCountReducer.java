import java.io.IOException;
import java.util.Iterator;
import java.util.StringTokenizer;

import org.apache.hadoop.io.*;
import org.apache.hadoop.mapred.*;

public class NodeCountReducer extends MapReduceBase implements Reducer<Text, IntWritable, Text, IntWritable>{
	public void reduce(Text key, Iterator<IntWritable> values, OutputCollector<Text, IntWritable> output, Reporter reporter) throws IOException
    {
          int sum = 0;
          /*iterates through all the values available with a key and add them together and give the
          final result as the key and sum of its values*/
        while (values.hasNext())
        {
             sum += values.next().get();
        }
        output.collect(key, new IntWritable(sum));
    }
}
