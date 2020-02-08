package com.techelevator;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FindAndReplace {

	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		
		System.out.println("Enter file name: ");
		File file = new File(in.nextLine());
		System.out.println("Enter the word you want to change: ");
		String word = in.nextLine();
		System.out.println("Enter the new word: ");
		String newWord = in.nextLine();
		
		List<String> lines = new ArrayList<String>();
		
		try(Scanner readFile = new Scanner(file)){
			
			while (readFile.hasNextLine()) {
				
				lines.add(readFile.nextLine().replace(word, newWord));
				
			}
			
		} catch(FileNotFoundException e) {
			System.out.println("No file found in the path: " + file.getAbsolutePath());
		}
		
		System.out.println("Enter the new file: ");
		File newFile = new File(in.nextLine());
		
		try(PrintWriter printWriter = new PrintWriter(newFile);
				BufferedWriter buffered = new BufferedWriter(printWriter)){
			
			for ( String line : lines) {
				buffered.write ( line + System.getProperty("line.separator"));
			}
			
		} catch(IOException e) {
			System.out.println("IOException: " + e.getMessage());
		}
		
		System.out.println("File " + newFile + " written successfully!!!");
		
		

	}

}
