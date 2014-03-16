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
        	String curToken = tokenizer.nextToken();
        	curToken = curToken.toLowerCase();
        	curToken.replaceAll(",", "");
        	curToken.replaceAll(".", "");
        	curToken.replaceAll(";", "");
        	int numVowels = 0;
        	
        	
             //word.set(tokenizer.nextToken());
             
             for (int i = 0; i < curToken.length(); i++){
            	 if (curToken.charAt(i) == 'a' || curToken.charAt(i) == 'e' || curToken.charAt(i) == 'i' || curToken.charAt(i) == 'o' || curToken.charAt(i) == 'u'){
            		 numVowels++;
            	 }
             }
             
             String vowels = String.valueOf(numVowels);
             String tokenLength = String.valueOf(curToken.length());
             word.set(tokenLength + " " + vowels);
             output.collect(word, one);
        }
     }
}
