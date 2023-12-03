package com.javatechie.entity;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class JavaEightOne {

	public static void main(String[] args) {
		List<Integer> intList = List.of(12, 12, 44, 23, 98, 112, 53, 77, 21, 12, 44, 65, 42);
		List<String> stList = List.of("Ubuntu", "Debian", "Kali Linux", "Kde Plasma", "Kubuntu", "Fedora");
		List<Integer> eventList = new ArrayList<>();
		System.out.println("###printing even numbers");
		intList.stream().filter(i -> i % 2 == 0).forEach(System.out::println);

		System.out.println("###filter starts with 2");
		intList.stream().map(i -> String.valueOf(i)).filter(j -> j.startsWith("2")).forEach(System.out::println);
		Set<Integer> intSet = new HashSet<>();
		System.out.println("###fiter dupicate number");
		intList.stream().filter(i -> !(intSet.add(i))).forEach(System.out::println);
		System.out.println("###counting number of integer ");
		System.out.println(intList.stream().count());

		System.out.println("###finding maxium value ");
		System.out.println(intSet.stream().sorted(Comparator.reverseOrder()).findFirst());
		System.out.println("###Strings whose length is greater than 6 in List");
		System.out.println(stList.stream().filter(i -> i.length() > 6).count());

		System.out.println("###printing average of numbers");
		System.out.println(intList.stream().reduce(0, (i, j) -> i + j) / (intList.size()));

		System.out.println("###sum of even of numbers");
		System.out.println(intList.stream().filter(i -> i % 2 == 0).reduce(0, (i, j) -> i + j));

		System.out.println("###sorting String");
		stList.stream().sorted(Comparator.reverseOrder()).forEach(System.out::println);

	}

}
