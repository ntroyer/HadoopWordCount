import java.io.IOException;
import java.util.StringTokenizer;

import org.apache.hadoop.io.*;
import org.apache.hadoop.mapred.*;

public class Problem5Mapper extends MapReduceBase implements Mapper<LongWritable, Text, Text, IntWritable>{
	private final static IntWritable one = new IntWritable(1);
    private Text word = new Text();
   
    public void map(LongWritable key, Text value, OutputCollector<Text, IntWritable> output, Reporter reporter) throws IOException
    {
        String line = value.toString();
        StringTokenizer tokenizer = new StringTokenizer(line);
       
        while (tokenizer.hasMoreTokens())
        {
        	String amalia = tokenizer.nextToken();
        	amalia = amalia.toLowerCase();
        	int numVowels = 0;
        	
             //word.set(tokenizer.nextToken());
             
             for (int i = 0; i < amalia.length(); i++){
            	 if (amalia.charAt(i) == 'a' || amalia.charAt(i) == 'e' || amalia.charAt(i) == 'i' || amalia.charAt(i) == 'o' || amalia.charAt(i) == 'u'){
            		 numVowels++;
            	 }
             }
             
             /*
              * The below code is used to convert ints to strings
              * 
              * String str3 = String.valueOf(str2.length());
              * word.set(str3);
              * output.collect(word, new IntWritable(i));
              */
             
             String cleophee = String.valueOf(numVowels);
             word.set(cleophee);
             output.collect(word, one);
        }
     }
}
