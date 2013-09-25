HadoopWordCount
===============

Various programs in Hadoop using the Google MapReduce framework done for CS 350 at BU

To run any of the programs, you will need a Hadoop server that runs Hadoop 1.0.4.

Files:

NodeCountMapper
NodeCountReducer

Takes a list of ISPs and will return a count of how many times each IP appears in the list.  

Problem5
Problem5Mapper
Problem5Reducer
Problem5b
Problem5bMapper
Problem5bReducer

Written for the following homework problem:

"The Google MapReduce framework is to be used to derive some statistics about text in a large document in English.
The statistics we need to compute are:

a. Histogram for the number of times (frequency) that a word with k = 0,1,2 vowels appear

b. Fraction of words of length n = 1, 2, 3 that have k = 0, 1, 2, ..., n vowels

Use the text in the preamble of the Declaration of Independence as your source document.  Note: you need to ignore all punctuation"

Histogram
HistogramMapper
HistogramReducer

Produces a histogram of the results produced by the above programs.

WordCount
WordCountMapper
WordCountReducer

Counts the number of words in a given document
