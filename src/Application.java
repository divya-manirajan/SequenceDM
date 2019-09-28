import java.util.Scanner;
import java.io.*;
public class Application{
	public static void main (String [] args) {
		
		Scanner scan = new Scanner(System.in);
		String repeat;
		ArrayStack firstString = new ArrayStack();
		ArrayStack secondString = new ArrayStack();
		
		do {
			firstString.clear();
			secondString.clear();
		System.out.print("Would you like to enter a sequence manually of from a file? (M/F): ");
			String type = scan.next();
		
		if(type.equals("M") || type.equals("m")) {
			
			System.out.print("Enter the first sequence: ");
			String fManual = scan.next();
			System.out.print("Enter the second sequence: ");
			String sManual = scan.next();
			
			String first =fManual.toLowerCase();
			String second = sManual.toLowerCase();
			
			
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
					System.out.println(fManual + " IS A SUBSEQUENCE OF "+sManual);
				}
				else {
					System.out.println(fManual+" IS NOT A SUBSEQUENCE OF "+sManual);
				}
			
		}// end if statement for manual sequence
		else if(type.contentEquals("F") || type.contentEquals("f")) {
			System.out.print("Enter the name of the file to process: ");
			String fileName = scan.next();
			try {
			File file = new File(fileName);
			Scanner fileScan = new Scanner (file);
			
			while(fileScan.hasNextLine()) {
				String line = fileScan.nextLine();
				int index = line.indexOf(',');
				String fScan = line.substring(0, index);
                String sScan = line.substring(index+2);
                String first = fScan.toLowerCase();
                String second = sScan.toLowerCase();
                
                
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
			}
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		System.out.print("Would you like to enter more sequences? (Y/N): ");
		repeat = scan.next();
	}while(repeat.equals("Y")|| repeat.equals("y"));
		System.out.println("<END RUN>");
	}//end main
}//end Application