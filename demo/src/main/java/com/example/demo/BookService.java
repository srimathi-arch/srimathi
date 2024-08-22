package com.example.demo;

import java.awt.print.Book;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

@Service
public class BookService {

	public List<Books> getbook(Books bookobj) {
		System.out.println(bookobj);
		
        List<Books> bookobj1 = new ArrayList<Books>();
		
		bookobj1.add(new Books("ABC",200,1));
		bookobj1.add(new Books("DEF",300,2));
		bookobj1.add(new Books("GHI",400,3));
		
		System.out.println(bookobj);
		
		List<Books> filter=bookobj1.stream().filter(n-> n.getBookname().equals("ujik")).collect(Collectors.toList());
		System.out.println(filter);
		
		if(filter.isEmpty()) {
			System.out.println("NoSuchBookFound");
		}else {
			System.out.println("BookFound : " +filter.get(0));
		}
		
		return null;
	}

	

	
}
