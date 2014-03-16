import java.io.IOException;
import java.util.Iterator;
import java.util.StringTokenizer;

import org.apache.hadoop.io.*;
import org.apache.hadoop.mapred.*;

public class HistogramMapper extends MapReduceBase implements Mapper<LongWritable, Text, Text, IntWritable>{
	private final static IntWritable one = new IntWritable(1);
    private Text word = new Text();
   
    public void map(LongWritable key, Text value, OutputCollector<Text, IntWritable> output, Reporter reporter) throws IOException
    {
          String line = value.toString();
        StringTokenizer tokenizer = new StringTokenizer(line);
       
          while (tokenizer.hasMoreTokens())
          {
              String title = tokenizer.nextToken();
              String sentWord = tokenizer.nextToken();
              
              word.set(sentWord);
              output.collect(word, one);
          }
     }
}
