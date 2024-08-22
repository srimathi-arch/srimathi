package com.example.demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class EightPrograms {

	public static void main(String[] args) {
		/* filter even number from list  
		 * 1,2,3,4,5,6,7,8,9
	    */
	
		List<Integer> intdata = Arrays.asList(1,2,3,4,5,6,7,8,9);
		System.out.println(intdata);
		
		List<Integer>filtered = intdata.stream().filter(item->item%2 == 0).toList();
		System.out.println(filtered);
		
		/*square each element and then sum it 
		 * 1,2,3,4,5*/
		
		List<Integer> number = Arrays.asList(1,2,3,4,5);
		
		int sqsumvalue = number.stream().map(n->n*n).reduce(0,Integer::sum);
		System.out.println(sqsumvalue);
		
		/* simple way is */
		
		List<Integer> number1 = Arrays.asList(1,2,3,4,5);
		int sqsumvalue1 =number1.stream().mapToInt(n->n*n).sum();
		System.out.println(sqsumvalue1);
		
		/* sort the list using java8 
		 * "banana","dragon","apple","cherry","eggplant" */
		
		List<String> words = Arrays.asList("banana","dragon","apple","cherry","eggplant");
		System.out.println( words.stream().sorted().collect(Collectors.toList()) );
		/*or*/
		words.stream().sorted().forEach(System.out::println);
		/*or*/
		words.sort(null); //comparable is used by default
		System.out.println( words);
		/*or*/
		words.sort(Comparator.reverseOrder());
		System.out.println( words);
		
		/*double each element of the list*/
		List<Integer> element = Arrays.asList(1,2,3,4,5,6,7);
		List<Integer> doubledelement = element.stream().map(n->n*2).collect(Collectors.toList());
		System.out.println( doubledelement);
		//max number from this list
		Optional<Integer> maxele = element.stream().max(Integer::compareTo);
		System.out.println( "max element is "+maxele);
		//min number from this list
		Optional<Integer> minele = element.stream().min(Integer::compareTo);
		System.out.println( "min element is "+minele);
		
		/*disticnt numbers from list*/
		List<Integer> numberarray = Arrays.asList(1,1,2,3,2,3,5,7,5,9,9,5);
		List<Integer> distinctnumberarray =numberarray.stream().distinct().collect(Collectors.toList());
		System.out.println( distinctnumberarray);
		
		/*group the strings of eaqual length*/
		List<String> stringarray = Arrays.asList("banana","dragon","apple","cherry","eggplant");
		Map<Integer, List<String>> lengthsort=stringarray.stream().collect(Collectors.groupingBy(String::length));
		System.out.println(lengthsort);
		
		/*remove string which contains an */
		List<String> anarray = Arrays.asList("apple","banana","cherry","date","grape");
		System.out.println(anarray.stream().filter(n->!n.contains("an")).collect(Collectors.toList()));
		
		/*join all elements using comma seperator*/
		String joinedst=anarray.stream().collect(Collectors.joining(","));
		System.out.println(joinedst);
	}
}
