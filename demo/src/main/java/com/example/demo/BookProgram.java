package com.example.demo;

import java.awt.print.Book;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class BookProgram {

	
	public static void main(String[] args) {
		
//		private String Bookname;
//		private Integer price;
//		private Integer edition;
		
		List<Books> bookobj = new ArrayList<Books>();
		
		bookobj.add(new Books("ABC",200,1));
		bookobj.add(new Books("DEF",300,2));
		bookobj.add(new Books("GHI",400,3));
		
		System.out.println(bookobj);
		
		List<Books> filter=bookobj.stream().filter(n-> n.getBookname().equals("ujik")).collect(Collectors.toList());
		System.out.println(filter);
		
		if(filter.isEmpty()) {
			System.out.println("NoSuchBookFound");
		}else {
			System.out.println("BookFound : " +filter.get(0));
		}
	}
}
