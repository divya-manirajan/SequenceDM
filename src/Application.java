import java.util.Scanner;
import java.io.*;
/**
 * This class determines if one String is a subsequence of a second String
 * 
 * @author Divya Manirajan
 * @version x.x
 * Sequence Project
 * Fall/2019
 */
public class Application{
	public static void main (String [] args) {
		
		Scanner scan = new Scanner(System.in);//creates a scanner called scan
		String repeat;//creates the string variable to determine if application continues
		ArrayStack firstString = new ArrayStack();//creates an array stack to hold the first string
		ArrayStack secondString = new ArrayStack();//creates an array stack to hold the second string
		
		do {
			firstString.clear();//
			secondString.clear();
		System.out.print("Would you like to enter a sequence manually of from a file? (M/F): ");
			String type = scan.next();//holds the type of sequence (manual or file)
		
		if(type.equals("M") || type.equals("m")) {
			
			System.out.print("Enter the first sequence: ");
			String fManual = scan.next(); //holds the first string of the manual sequence
			System.out.print("Enter the second sequence: ");
			String sManual = scan.next();//holds the second string of the manual sequence
			
			String first =fManual.toLowerCase();//converts the first string to all lower case
			String second = sManual.toLowerCase();//converts the second string to all lower case
			
			
			for(int i = 0; i<first.length(); i++) {
				firstString.push(first.charAt(i));
			}//pushed all chars of first into a stack (backwards)
			for(int j = 0; j<second.length(); j++) {
				secondString.push(second.charAt(j));
			}//pushed all chars of second into a stack (backwards)
			
			while(!firstString.isEmpty() && !secondString.isEmpty()) {
				if(firstString.peek() == secondString.peek()){
					firstString.pop();
					secondString.pop();
				}//if chars at end of string match then both are discarded
				else {
					secondString.pop();
				}//if they don't match then only second string char is discarded until there is a match
			}//pattern continues until one or both of the stacks are empty
				
				if(firstString.isEmpty()) {
					System.out.println(fManual + " IS A SUBSEQUENCE OF "+sManual);
				}// if first stack is empty than it must be a subsequence
				else {
					System.out.println(fManual+" IS NOT A SUBSEQUENCE OF "+sManual);
				}//if first stack still has chars then it can't be a subsequence
			
		}// end if statement for manual sequence
		else if(type.contentEquals("F") || type.contentEquals("f")) {
			System.out.print("Enter the name of the file to process: ");
			String fileName = scan.next();//variable to hold file name (sequences.txt)
			try {
			File file = new File(fileName);//creates a new file object with the file name entered
			Scanner fileScan = new Scanner (file); //creates a scanner to scan the file
			
			while(fileScan.hasNextLine()) {
				String line = fileScan.nextLine();//line holds the entire line in the file
				int index = line.indexOf(',');//index finds the index of the comma
				String fScan = line.substring(0, index);//holds the first sequence (beginning to comma)
                String sScan = line.substring(index+2);//holds the second sequence (beginning of second to end)
                String first = fScan.toLowerCase();//converts first string to all lower case
                String second = sScan.toLowerCase();//converts second string to all lower case
                
                //same as for manual sequences
                for(int i = 0; i<first.length(); i++) {
    				firstString.push(first.charAt(i));
    			}//pushed all chars of first into a stack
    			for(int j = 0; j<second.length(); j++) {
    				secondString.push(second.charAt(j));
    			}//pushed all chars of second into a stack
    			
    			while(!firstString.isEmpty() && !secondString.isEmpty()) {
    				if(firstString.peek() == secondString.peek()){
    					firstString.pop();
    					secondString.pop();
    				}
    				else {
    					secondString.pop();
    				}
    			}//end while
    				
    				if(firstString.isEmpty()) {
    					System.out.println(fScan + " IS A SUBSEQUENCE OF "+sScan);
    				}
    				else {
    					System.out.println(fScan+" IS NOT A SUBSEQUENCE OF "+sScan);
    				}
                
                firstString.clear();
                secondString.clear();
			}//end while
			}catch(Exception e) {
				e.printStackTrace();
			}//end try-catch for file sequence
		}//end if statement for file sequence
		
		System.out.print("Would you like to enter more sequences? (Y/N): ");
		repeat = scan.next();//holds value for if application should repeat
	}while(repeat.equals("Y")|| repeat.equals("y")); //application will repeat if Y or y is entered
		System.out.println("<END RUN>");//if any other value than Y or y is entered application will stop
	}//end main
}//end Application