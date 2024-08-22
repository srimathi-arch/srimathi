package com.example.demo;

import java.awt.print.Book;
import java.util.List;
import java.util.Map;

import org.apache.catalina.mapper.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping(value="/book",method = RequestMethod.POST)
public class BookController {

	@Autowired
	BookService bookservice;
	
	@PostMapping
	public List<Books> getbook (@RequestBody Map<String , Object> mapObject){
		
		final ObjectMapper mapper = new ObjectMapper();

		Books bookobj = mapper.convertValue(mapObject.get("Books"),Books.class);
		System.out.println(bookobj);	
		return bookservice.getbook(bookobj);
	}



}
