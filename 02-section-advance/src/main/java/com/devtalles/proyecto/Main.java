package com.devtalles.proyecto;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Box<String> stringBox = new Box<>("Jose");

        System.out.println(stringBox.getValue());

        Box<Integer> integerBox = new Box<>(10);
        System.out.println(integerBox.getValue());

        System.out.println("\nDesde Utility");
        Utility.printItem(integerBox);
        Utility.printItem(stringBox, 2);

        MathUtils.sum(2,2);
        MathUtils.sum(2, 4);

        List<String> names = new ArrayList<>();
        names.add("Jose");
        names.add("Julie");
        names.add("Gabriel");

        List<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);

        printList(numbers);
        printList(names);

        sumNumbers(numbers);
        addNumbers(numbers);
        /*
        ArrayList<String> list = new ArrayList<>();

        list.add("Jose");
        list.add("Nico");

        for(String name : list){
            System.out.println(name.toUpperCase());
        }*/
    }

    public static void printList(List<?> list){
        for (Object o : list){
            System.out.println(o);
        }
    }

    public static void sumNumbers(List<? extends Number> numbers){
        double sum = 0;
        for (Number number : numbers){
            sum += number.doubleValue();
        }
        System.out.println("Sum: " + sum);
    }

    public static void addNumbers(List<? super Integer> numbers){
        numbers.add(4);
        numbers.add(5);
        numbers.add(6);

        Object num = numbers.get(0);
        System.out.println(num);
    }
}
