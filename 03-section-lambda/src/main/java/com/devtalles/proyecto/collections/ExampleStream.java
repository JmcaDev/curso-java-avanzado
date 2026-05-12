package com.devtalles.proyecto.collections;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ExampleStream {
    public static void main(String[] args) {
        List<String> fruits = Arrays.asList("Apple", "Banana", "Orange", "Strawberry", "Pear", "Kiwi", "Mango");

        List<String> filterFruits = fruits.stream()
                .filter((fruit) -> fruit.length() > 5)
                .toList();

        System.out.println(fruits);
        System.out.println(filterFruits);

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5,6,7,8,9);

        //Stream<Integer> integerStream = numbers.stream().map(n -> n * n);
        //List<Integer> numbersSquare = integerStream.toList();
        //System.out.println(numbers);
        //System.out.println(numbersSquare);

        List<Integer> integerSquare = numbers.stream().map(n-> n*n).toList();
        System.out.println(numbers);
        System.out.println(integerSquare);
    }
}
