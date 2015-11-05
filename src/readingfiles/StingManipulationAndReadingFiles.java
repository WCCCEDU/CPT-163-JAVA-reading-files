/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package readingfiles;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author samuraipanzer
 */
public class StingManipulationAndReadingFiles {

  /**
   * @param args the command line arguments
   */
  public static void main(String[] args) throws IOException {
	
	// A normal String
	// Remove the ....(zzzz) parts of the string
	String phrase = "How now brown cow......(zzzzzzz)";
	String[] words = phrase.split(" ");
	
	// Better way
	int towPeriods = phrase.indexOf("..");
	String cleanPhrase = "";
	if(towPeriods > -1){
	  cleanPhrase = phrase.substring(0, towPeriods);
	}
	
	// slower way
	for(String word : words){
	  int twoPeriods = word.indexOf("..");
	  if(twoPeriods > -1){
		word = word.substring(0, twoPeriods);
	  }
	  System.out.println(word);
	}
	
	// Using split inline without storing the tokenized strings in a variable
	for(String word : cleanPhrase.split(" ")){
	  StringBuilder builder = new StringBuilder(word);
	  System.out.println(builder.reverse());
	}
	
	// Base conversion
	System.out.println(Integer.toOctalString(100));
	System.out.println(Integer.toHexString(100));
	
	// how big a number can be
	System.out.println(Integer.MAX_VALUE);
	// Its the biggest signed value
	int bigNumb = -2147483647;
	System.out.println(bigNumb);
	System.out.println(File.separator);
	
	// Read a file with scanner
	Scanner file = null;
	try {
	  file = new Scanner(new File("./file_to_read.txt"));
	} catch (FileNotFoundException ex) {
	  Logger.getLogger(StingManipulationAndReadingFiles.class.getName()).log(Level.SEVERE, null, ex);
	}
	
	while(file.hasNext()){
	  String line = file.nextLine();
	  String[] strNums = line.split(" ");
	  int ans = 0;
	  for(String num : strNums){
		ans += Integer.parseInt(num);
	  }
	  System.out.println("The Answer is = " + ans);
	}
	
	// Without Scanner doing the same readline is a little harder
	File txtFile = new File("./text.txt");
	FileInputStream streamedFile = null;
	try {
	  streamedFile = new FileInputStream(txtFile);
	} catch (FileNotFoundException ex) {
	  Logger.getLogger(StingManipulationAndReadingFiles.class.getName()).log(Level.SEVERE, null, ex);
	}
	
	int content = 0;
	StringBuilder line = new StringBuilder();
	ArrayList<String> lines = new ArrayList();
	while ((content = streamedFile.read()) != -1) {
	  // convert to char and display it
	  char cContent = (char) content;
	  if(cContent == '\n'){
		lines.add(line.toString());
		line = new StringBuilder();
	  }else{
		line.append(cContent);
	  }
	}
	
	for(String aline : lines){
	  System.out.println(aline);
	}
	
  }
  
}
