package com.pluralsight.loops;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

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
        String userSearch = scanner.nextLine();
        List<Person> matchingPersons = new ArrayList<>();
        for (Person american : americans) {
            if (american.getFirstName().toLowerCase().contains(userSearch.toLowerCase()) ||
                    american.getLastName().toLowerCase().contains(userSearch.toLowerCase())) {
                matchingPersons.add(american);
            }
        }
        for (Person matchingPerson : matchingPersons) {
            System.out.println("Matching persons: \nFirst Name: " + matchingPerson.getFirstName() + "\nLast Name: " + matchingPerson.getLastName() + "\n");
        }

        for (Person american : americans) {
            sum += american.getAge();
        }

        double average = sum / americans.size();

        System.out.println("Average age of all people in the original list: " + average);

        Person oldest = americans.get(0);
        Person youngest = americans.get(0);
        double totalAge = 0;

        for (Person american : americans) {
            totalAge += american.getAge();
            if (american.getAge() > oldest.getAge()) {
                oldest = american;
            }

            if (american.getAge() < youngest.getAge()) {
                youngest = american;
            }
        }

        System.out.println("Oldest person in the original list: " + oldest.getFirstName() + " " + oldest.getLastName() + ", age " + oldest.getAge());
        System.out.println("Youngest person in the original list: " +  youngest.getFirstName() + " " + youngest.getLastName() + ", age " + youngest.getAge());

    }

}
