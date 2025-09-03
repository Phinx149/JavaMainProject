import java.io.*;  // add for file i/o and exception handling

import java.util.Scanner;

public class WordFrequencyAddSearch {
	
   private static int totalWords = 0;

   public static String [] getWords() throws Exception {
	   //Scanner s = new Scanner(System.in);
	   // make the array big enough to hold the
	   // your estimate of the largest number of 
	   // words the file has
	   String [] words = new String [250];
	   String line;
	   
	   /* Create relationship (reference) between   
	    * the identifier f, of type File in this 
		* java program, and the file ShuttlePilot.txt
		* which resides in the same directory as the
		* file with this program (HFwordCountuency.java)
		*/
	   File f = new File("ShuttlePilot.txt");
	   
	   // next, create a scanner and tell it to 
	   // read from the file referenced by f
	   
	   Scanner s = new Scanner(f);
	   
	   totalWords = 0;
	   while (s.hasNextLine()){ // is there another line in file f
			line = s.nextLine(); // if so, read line
			line = line.trim().replaceAll("^[\n\r]$","");
			String wordsOnLine [] = line.split(" "); //split out the words
			for (String word : wordsOnLine) {
				words[totalWords] = word.toLowerCase();
				totalWords = totalWords + 1; // update count in class-wide variable totalWords
			}
	   }
	   s.close(); // close the file
	   return words;
   }
	     
   public static void saveHistogram ( String words[], int wordCounts[], int totalWords) throws Exception {
		
		File outFile = new File("results.txt");
		FileOutputStream ofs = new FileOutputStream(outFile);
 
		BufferedWriter bow = new BufferedWriter(new OutputStreamWriter(ofs));
		
		for (int i = 0; i < totalWords; ++i) {
			
			bow.write(words[i] + ": ");
			
			for (int j = 0; j < wordCounts[i]; ++j) {
				bow.write("*");
			}
			
			bow.newLine();
	  }
		bow.close();
   }
   public static int wordSearch(String []uniqueWords,String word, int count ){
	int found=-1;
	for (int i=0;i<uniqueWords.length;i++){
		if (word.equals(uniqueWords[i])){
			found=i;
			break;


		}else{
			found=-1;
		}
	}
	return found;
   }

    
   public static void main(String[] args) throws Exception { 

      int count = 0; // count of uniqueWords - NEW
      String[] theWords; // array of strings used to store the words
         
	  theWords = getWords(); // getWords gets words
	                         // returns ref to an
							 // array with the words
	
	  // array to store the unique words - NEW!!!
	  String [] uniqueWords = new String [totalWords];
	  
	  // Note: named wordFreq in earlier examples
	  int [] wordCount = new int[totalWords];  
	 
      for (int i = 0; i < totalWords; i++) {
		  
				String word = theWords[i];
		        // Debug print statements
				// ALWAYS A GOOD THING TO USE WHEN
				// Coding (implementing) /testing your program
				//System.out.println("Count: " + count);
				//System.out.println("word: " + theWords[i]);
				
				if (count == 0) {	
					uniqueWords[count] = word;
					wordCount[count] = 1;
					count++;
				}
				else { // we processed at least one word
					int found = wordSearch(uniqueWords, word, count);
					if (found >= 0)
						wordCount[found] += 1;
					else {
						uniqueWords[count] = word;
						wordCount[count] = 1;
						count++;
					}
				}
		} // end for
    
	  saveHistogram(uniqueWords,wordCount,count);
   }
   
    // In-class exercise, Lecture 13 February 14th
	// Declare and define the linear search method wordSearch below
	// NOTE, this program will not compile until you create the method!!!


   
}