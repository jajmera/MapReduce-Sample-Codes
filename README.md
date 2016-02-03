# MapReduce-Sample-Codes
This repository contains few MapReduce refernce codes for users new to the Hadoop Framework and who want to tackle some of the basic problems where MapReduce is widely used. 
* These codes are  meant purely for reference purposes to people working with basic problems of MapReduce.

* The wordCount Takes in tweets Stored in a .txt format as input and filters according to the words given ie. Hackathon,December etc. in the sample code.

* The pageRank calculation is based on the https://en.wikipedia.org/wiki/PageRank formula provided. the input is in the format
 A B C D E 0.127
 B D E 0.178
 .....
Where the first page is the source and the others are the apge it links to and then the probability of the source page
You can iteratively calculate the pageRanks, that is what is done in this code.

