package com.pluralsight.streams;

import com.pluralsight.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Program {

    public static void main(String[] args) {
        List<Person> americans = new ArrayList<>();
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);
        int sum = 0;
        americans.add(new Person("Riley", "Pearce", random.nextInt(46)));
        americans.add(new Person("Jamari", "Ferris", random.nextInt(46)));
        americans.add(new Person("Blanca", "Payne", random.nextInt(46)));
        americans.add(new Person("Edna", "Curry", random.nextInt(46)));
        americans.add(new Person("Harlow", "Lowery", random.nextInt(46)));
        americans.add(new Person("Gemma", "Delgado", random.nextInt(46)));
        americans.add(new Person("David", "Emery", random.nextInt(46)));
        americans.add(new Person("Lainey", "Herbert", random.nextInt(46)));
        americans.add(new Person("Alayah", "House", random.nextInt(46)));
        americans.add(new Person("Anahi", "Waller", random.nextInt(46)));

        System.out.println("Please search via first or last name: ");
        String userSearch = scanner.nextLine().toLowerCase();

        List<Person> matchingPersons = americans.stream()
                .filter(person -> person.getFirstName().toLowerCase().contains(userSearch) || person.getLastName().toLowerCase().contains(userSearch))
                .collect(Collectors.toList());

        System.out.println("Matching persons: ");
        matchingPersons.forEach(person -> System.out.println(person.getFirstName() + " " + person.getLastName()));


        sum = americans.stream().map(Person::getAge).reduce(0, Integer::sum);

        double average = (double) sum / americans.size();

        System.out.println("Average age of all people in the original list: " + average);

        int oldest = americans.stream().map(Person::getAge).reduce(0, Integer::max);

        int youngest = americans.stream().map(Person::getAge).reduce(Integer.MAX_VALUE, Integer::min);

        System.out.println("Oldest age in the original list: " + oldest);
        System.out.println("Youngest age in the original list: " +  youngest);

    }

}
