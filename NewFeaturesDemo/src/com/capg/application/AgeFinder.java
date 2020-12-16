 package com.capg.application;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class AgeFinder {

	public static void main(String[] args) {
		List<LocalDate> list=new ArrayList<>();
		System.out.println("Enter the number of dates for which you want to find the age : ");
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		System.out.println("Enter the Dates (yyyy-MM-dd): ");
		for(int i=0;i<n;i++) {
			String s=sc.next();
	    	LocalDate ldt=LocalDate.parse(s, DateTimeFormatter.ofPattern("yyyy-M-dd"));   //Date and Time api
			list.add(i,ldt);
			Period p=Period.between(ldt, LocalDate.now());
	    	System.out.println("age = "+p.getYears());
		}
		Collections.sort(list, (o1,o2)->o1.getYear()>o2.getYear()?1:o1.getYear()<o2.getYear()?-1:0);  //lambda expression
		System.out.println("Date of birth after sorting are : ");
		list.forEach(System.out::println);               //stream api
	}
}