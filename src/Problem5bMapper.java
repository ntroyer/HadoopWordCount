import java.io.IOException;
import java.util.StringTokenizer;

import org.apache.hadoop.io.*;
import org.apache.hadoop.mapred.*;

public class Problem5bMapper extends MapReduceBase implements Mapper<LongWritable, Text, Text, IntWritable>{
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
        	amalia.replaceAll(",", "");
        	amalia.replaceAll(".", "");
        	amalia.replaceAll(";", "");
        	int numVowels = 0;
        	
        	
             //word.set(tokenizer.nextToken());
             
             for (int i = 0; i < amalia.length(); i++){
            	 if (amalia.charAt(i) == 'a' || amalia.charAt(i) == 'e' || amalia.charAt(i) == 'i' || amalia.charAt(i) == 'o' || amalia.charAt(i) == 'u'){
            		 numVowels++;
            	 }
             }
             
             String cleophee = String.valueOf(numVowels);
             String ecaflip = String.valueOf(amalia.length());
             word.set(ecaflip + " " + cleophee);
             output.collect(word, one);
        }
     }
}
