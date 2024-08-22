package com.example.demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PatientsProgram {

	public static void main (String [] args) {
		
		Patients p1 = new Patients("sri",  25, "corona", 10000);
		Patients p2 =new Patients("mathi",  31, "fever", 20000);
		Patients p3 =new Patients("raj", 32, "corona", 10500);
		Patients p4 =new Patients("gopal", 33, "vomit", 30000);
		Patients p5 =new Patients("srini", 24, "fever", 18000);
		
		List<Patients> patobj = Arrays.asList(p1,p2,p3,p4,p5);
		/* q1 : list of corona patients*/

		List<Patients>	coronapatients= patobj.stream().filter(item->item.getDisease()=="corona").toList();
		System.out.println(coronapatients);
		
		/*patients age > 25*/
		patobj.stream().filter(item-> item.getAge() > 25 ).forEach(System.out::println);
		
		/*average bill of corona*/
		
		Double totalbill = patobj.stream().filter(item->item.getDisease().equals("corona")).collect(Collectors.averagingInt(Patients::getAmount));
		System.out.println(totalbill);
	}
}
