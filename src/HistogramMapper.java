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
              String cra = tokenizer.nextToken();
              String sadida = tokenizer.nextToken();
              
              word.set(sadida);
              output.collect(word, one);
          }
     }
}
