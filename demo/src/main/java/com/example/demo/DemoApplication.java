package com.example.demo;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
		String str="cloudtech";
		removechars(str);	
		count(str);
		int[] a1 = {3,2,3};
		int[] a2 = {3,4,5};
		
		Boolean value = comparetwoarray(a1 ,a2);
		if(!value) {
			System.out.println("array is not same");
		}else {
			System.out.println("array is same");
		}
		
		int [] a3 = {1,2,5,4,7,8,11,20};
		
		printevenandodd(a3);
		
		int [] a4 = {1,3,5,7,2,4,6,8,10};
		findprimenumber(a4);
	}
	
	private static void findprimenumber(int[] a4) {
	
		List<Integer> primenumlist = new ArrayList<>();
		  for(int i : a4) {
			int datapos = i;
			
			try {
				if(findprime(datapos)) {
					primenumlist.add(datapos);
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		System.out.println("prime number array: " +primenumlist);
		
		String finalprimestring = primenumlist.stream()
								  .map(String::valueOf)
								  .collect(Collectors.joining());
		System.out.println("prime number array: " +finalprimestring);
	}
	
	private static boolean findprime(int num) {
		
		for(int j=2 ; j<num ; j++) {
			if(num%j == 0) {
				return false;
			}
		}
		return true;
	}
	private static void printevenandodd(int[] a3) {
		List<Integer> evenarray = new ArrayList<>();
		List<Integer> oddarray = new ArrayList<>();
		List<Integer> finalarray = new ArrayList<>();
		
		for(int i =0 ; i<a3.length;i++) {
			if(a3[i]%2 == 0) {
				evenarray.add(a3[i]);
			}else {
				oddarray.add(a3[i]);
			}
		}
		
		finalarray.addAll(evenarray);
		finalarray.addAll(oddarray);
		System.out.println(finalarray); // output in array
		
		//output in string means 
		
		String finaldata = finalarray.stream()
				           .map(String::valueOf)
				           .collect(Collectors.joining());
		
		System.out.println(finaldata); // output in array
			
	}
		
	private static Boolean comparetwoarray(int[] a1, int[] a2) {
		 
		int count =0;
		for(int i = 0;i<a1.length;i++) {
			int a1data = a1[i];
			    if(a1data != a2[i]) {
				   System.out.println("array is not same");
				   return false;
				}
			
		}
		return true;
		
		
	}

	public static void removechars(String str) {
		String newstr="";
	
		//using inbuild method
		System.out.println(str.replace("c",""));  //here i need to remove all c from that array.
		//without using inbuit method
		for (int i=0;i<str.length();i++) {
			if(str.charAt(i)!='c') {
				char post = str.charAt(i);
				newstr = newstr+post;
			}
	}
		
		System.out.println("string without c :" +newstr);

	}
	public static void count(String str) {
		int count =0;
		for(int i = 0;i<str.length();i++) {
			if(str.charAt(i)=='c') {
				count++;
			}
		}
		
		System.out.println("count of c :" +count); // here i am count no of occurance of c
		
	}

	public static void comparetwoarray() {
		
	}
}
