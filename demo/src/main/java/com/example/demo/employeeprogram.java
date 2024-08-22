package com.example.demo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.OptionalDouble;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.LongStream;
import java.util.stream.Stream;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class employeeprogram {

	public static void main(String[] args) {
	SpringApplication.run(employeeprogram.class, args);
	 
//	private String name;
//	private Integer age;
//	private String department;
//	private String gender;
	
	  List<employee> emp = new ArrayList<>();
	  emp.add(new employee("sri44",25,"cse","f",10000));
	  emp.add(new employee("sri144",19,"it","f",12000));
	  emp.add(new employee("sri2444",22,"mech","m",13000));
	  emp.add(new employee("sr",30,"mech","m",14000));
	  emp.add(new employee("s",23,"cse","f",15000));

	  System.out.println(emp);
	  
	  List<employee> filtered = new ArrayList<>();
	  //filter only one dept
	  filtered=emp.stream()
			  .filter(index->(index.getDepartment().equalsIgnoreCase("cse")))
			  .collect(Collectors.toList());
	  System.out.println(filtered);
	  
	  //get only distinct dept - root 1
	  List<String> dept = emp.stream().map(employee::getDepartment).distinct().collect(Collectors.toList());
	  System.out.println(dept);  
	  
	  //get only distinct dept - root 2
	  emp.stream().map(employee::getDepartment).distinct().forEach(System.out::println);
	  
	  //get count of all employees
	  long count = emp.stream().map(employee::getName).count();
	  
	//get count of all employees in each dept
	  long csedept = emp.stream().filter(index->index.getDepartment().equals("cse")).count();
	  System.out.println(csedept);
	  long itdept = emp.stream().filter(index->index.getDepartment().equals("it")).count();
	  System.out.println(itdept);
	  long mechdept = emp.stream().filter(index->index.getDepartment().equals("mech")).count();
	  System.out.println(mechdept);

	  
	  //list of emp in each dept 
	  Map<String, List<employee>> deptwise = emp.stream().collect(Collectors.groupingBy(employee::getDepartment));
	  System.out.println(deptwise);
	  
	  //count of each employee in each dept
	  Map<String, Long> count1 = emp.stream().collect(Collectors.groupingBy(employee::getDepartment,Collectors.counting()));
	  System.out.println(count1);
	  
	  //avg age of male and female employee
	  Map<String, Double> avgage = emp.stream().collect(Collectors.groupingBy(employee::getGender , Collectors.averagingInt(employee::getAge)));
	  System.out.println(avgage);
	  
	  //avg no of male and female
	  Map<String, Long> countvalue = emp.stream().collect(Collectors.groupingBy(employee::getGender,Collectors.counting()));
	  LongStream getstreamlongvalues=countvalue.values().stream().mapToLong(Long::longValue);
	  OptionalDouble avg = getstreamlongvalues.average();
	  System.out.println(avg);
	  //convert stram to array
	  long[] valuesArray = countvalue.values().stream().mapToLong(Long::longValue).toArray();
	  System.out.println(valuesArray);
	 
	  //get name of emp in each dept -- 1 root
	  emp.stream().map(employee::getName).forEach(System.out::println);
	  
	  //get name of emp in each dept -- 2 root
	  Stream<String> name = emp.stream().map(employee::getName);
	  List<String> namelist = name.collect(Collectors.toList());
	  System.out.println(namelist);
	  
	  											/*collect function methods*/
	  
	  //count number of emp in that table ---- count()function
	  System.out.println("counting() function example : "+emp.stream().collect(Collectors.counting()));
	  //summing function example
	  System.out.println("summingint() function example : "+emp.stream().collect(Collectors.summingInt(employee::getAge)));
	  //sverageint function example
	  System.out.println("avarageint() function example : "+emp.stream().collect(Collectors.averagingInt(employee::getAge)));
	  //summarizing int function example
	  IntSummaryStatistics stats = emp.stream().collect(Collectors.summarizingInt(employee::getAge));
	  System.out.println("summarizingint() function example : "+stats);
	  
	  //collectors.tolist()function example
	  System.out.println("collectors.tolist() function example : "+emp.stream().collect(Collectors.toList()));
	  //set function example to remove duplicate
	  System.out.println("collectors.toset() function example to remove duplicate : "+emp.stream().collect(Collectors.toSet()));

	  //tomap() function example
	  System.out.println("collectors.tomap() function example : "+emp.stream().map(employee::getName).distinct().collect(Collectors.toMap(String::length, Function.identity())));
	  //reducing function example
	  System.out.println("collectors.reducing function example : "+emp.stream().map(employee::getName).collect(Collectors.reducing((s1,s2)->s1+s2)));
	  //reducing example with some operation
	  System.out.println("collectors.reducing with add operation example : "+emp.stream().collect(Collectors.reducing(0,employee::getAge,Integer::sum)));
	
	  //grouping example
	  Map<String, List<employee>> deptwise1 = emp.stream().collect(Collectors.groupingBy(employee::getDepartment));
	  System.out.println("grouping example : "+deptwise1);
	//grouping example
	  Map<String, Set<employee>> deptwise2 = emp.stream().collect(Collectors.groupingBy(employee::getDepartment,Collectors.toSet()));
	  System.out.println("grouping example : "+deptwise2);
	//partitioning example
	  System.out.println("partitioning example : "+emp.stream().map(employee::getAge).collect(Collectors.partitioningBy(s1->s1>50)));
	  //partiotining handling duplicate elimination
	  System.out.println("partitioning without duplicate : "+emp.stream().map(employee::getAge).collect(Collectors.partitioningBy(s1->s1>50,Collectors.toSet())));
	  
	  //joining operATION
	  System.out.println("joining operation : "+emp.stream().map(employee::getDepartment).distinct().collect(Collectors.joining()));
	  //joining with delimiter
	  System.out.println("joining operation with delimiter : "+emp.stream().map(employee::getDepartment).distinct().collect(Collectors.joining(",")));
	  //joining with prefix and suffix
	  System.out.println("joining operation with delimiter with prefix and suffix : "+emp.stream().map(employee::getDepartment).collect(Collectors.joining(",", "[", "]")));
	  
	  //unmodifiedlist
	  System.out.println("collectingandthen changing to unmodified list : "
			  +emp.stream().collect(Collectors.collectingAndThen(Collectors.toList(),Collections::unmodifiableList)));
	  
	  //collectors.mapping()
	  System.out.println("collectors.mapping : "+emp.stream().collect(Collectors.mapping(employee::getAge, Collectors.toList())));
	
	
	
	/*progarm-2 get emp of age > 25 and increase salary by 10%*/ 
	
	  List<employee> incrementedsalary = emp.stream().map(item->{
		  
		  if(item.getAge()>25) {
			  double sal=item.getSalary()*1.1;
			  item.setSalary((int)sal);
 		  }
		  return item;
	  }).collect(Collectors.toList());
	  
	  System.out.println("Incremented salary" +incrementedsalary);
	}
}
