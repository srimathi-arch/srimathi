package com.example.demo;

public class PrintWithoutLoop {

	//print number from 1 to 100 without using loop.
	
	
	public static void main (String args []) {
		
		String str = 1+2+3+"ONE"+1+2+3+"TWO";
		System.out.println(str);
		printnumber(1);
	}

	private static void printnumber(int i) {
		
		if(i<=100) {
			System.out.println(i);
			printnumber(i+1);
		}
		
	}
}
