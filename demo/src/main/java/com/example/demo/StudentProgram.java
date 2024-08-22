package com.example.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StudentProgram {
	
	public static void main (String [] args) {
		
		List<Students> studobj = new ArrayList<Students>();
		
		studobj.add(new Students("sri", "F", 30, "CSE", 10000));
		studobj.add(new Students("mathi", "F", 31, "IT", 20000));
		studobj.add(new Students("raj", "M", 32, "Mech", 10500));
		studobj.add(new Students("gopal", "M", 33, "CSE", 30000));
		studobj.add(new Students("srini", "M", 34, "IT", 18000));
		
		/*q1 : print dept name alone */
		List<String> dept=studobj.stream().map(Students::getDep).collect(Collectors.toList());
		System.out.println(dept);
		
		/*q2 : print dept name alone distinct */
		List<String> distdept=studobj.stream().map(Students::getDep).distinct().collect(Collectors.toList());
		System.out.println(distdept);
		
		/* q3 : count dept */
		long countdept = studobj.stream().map(Students::getDep).count();
		System.out.println(countdept);
		
		/*q4 stud in each dept */
		Map<String, List<Students>> grouplist =studobj.stream().collect(Collectors.groupingBy(Students::getDep));
		System.out.println(grouplist);
		
		/*q5 stud in each dept count */
		Map<String, Long> count =studobj.stream().collect(Collectors.groupingBy(Students::getDep,Collectors.counting()));
		System.out.println(count);
		
		/* q6 avg of gender */
	    Map<String, Long>	gendercount = studobj.stream().collect(Collectors.groupingBy(Students::getGender , Collectors.counting()));
	    System.out.println(gendercount);
	    long totalstudents =gendercount.values().stream().mapToLong(Long::longValue).sum();
	    
	    double avgmale = (double)gendercount.getOrDefault("M",0L) / totalstudents *100;
	    System.out.println("Male avg :"+avgmale);
	    
	    /* q7 avg fees of male */
	    Map<String, Double> avgfees=studobj.stream().collect(Collectors.groupingBy(Students::getGender , Collectors.averagingDouble(Students::getFees)));
	    System.out.println("avg fees :"+avgfees);
	}

}
