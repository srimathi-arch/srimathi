package com.example.demo;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.ArrayList;
import java.util.Arrays;

public class Interview {

	public static void main(String[] args) {
		
		int[] input = {0,1,4,0,2,0};
	
		movedataright(input);
	}

	private static void movedataright(int[] input) {
		
		int intoutputindex = 0;
		int length = input.length-1;
	    int [] output = new int[input.length];
		
		for(int i =0 ; i<input.length ; i++) {
			if(input[i] != 0) {
				output[intoutputindex]=input[i];
				intoutputindex++;
			}else {
				output[length]=input[i];
				length--;
			}
		}
		System.out.println(output);
	}
}
