package com.example.demo;

import java.util.Arrays;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class stringprogram {


	public static void main(String[] args) {
		SpringApplication.run(stringprogram.class, args);
		
		System.out.println("00000000");
		int count = 0;
		String sentence = "India Is My Country";
		String word = "India";
		String w1 = sentence.substring(1);
		System.out.println(w1);
		String w2 = sentence.substring(2);
		System.out.println(w2);
		String w3 = sentence.substring(3);
		System.out.println(w3);
		String w4 = sentence.substring(4);
		System.out.println(w4);
		
		//get india alone from this entire string
		String w5 = sentence.substring(0,word.length());
		System.out.println(w5);
				
		//get words from the entire string
		String [] splittedword = sentence.split(" ");
		for(String single : splittedword) {
			System.out.println(single); // print each word seperately
			
			if(single == word) {
				for(int i =0;i<single.length();i++) {
					if(single.charAt(i)=='a') {
						count++;
					}
				}
			}
			System.out.println(count);
		}
		//print the string array itself 
		System.out.println(Arrays.toString(splittedword));
	}
}
