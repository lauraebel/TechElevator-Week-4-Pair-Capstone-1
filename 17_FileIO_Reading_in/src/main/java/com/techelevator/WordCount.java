package com.techelevator;

import java.util.List;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class WordCount {

	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		
		System.out.println("What file would you like to search? ");
		
		File file = new File(in.nextLine());
		
		List<String> lines = new ArrayList<String>();
		
		int wordCount = 0;
		int sentenceCount = 0;
		
		try (Scanner fileScanner = new Scanner(file)){
			while (fileScanner.hasNextLine()) {
				String line = fileScanner.nextLine();
				String[] words = line.split("\\s+");
				String[] sentences = line.split("\\.|\\!|\\?");
				wordCount += words.length;
				sentenceCount += sentences.length - 1;
				
			} 
			System.out.printf("Word Count: %d %nSentence Count:%d", wordCount, sentenceCount);
			
			} catch (FileNotFoundException e) {
				System.out.println("File not found: " + file.getAbsolutePath());
			} catch (Exception e) {
				System.out.println("Unknown error has occurred: " + e.getMessage());
			}
		
		}
	

	}


