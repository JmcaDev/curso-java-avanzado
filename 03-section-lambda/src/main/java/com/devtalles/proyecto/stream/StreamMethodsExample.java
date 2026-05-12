package com.devtalles.proyecto.stream;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class StreamMethodsExample {
    public static void main(String[] args) {
        List<String> names = List.of("Ana","Jose", "Miguel", "Castillo", "Ana", "Fernando");
        List<String> longNames = names.stream()
                .filter(name -> name.length() > 3) // Filtra nombres de mas de 3 letras
                .toList();

        System.out.println(longNames);

        List<Integer> lengthNames = names.stream()
                .map(name -> name.length())//Convierte cada nombre a su longitus
                .toList();

        System.out.println(lengthNames);

        List<List<Integer>> list = List.of(List.of(1, 2, 3), List.of(4, 5, 6), List.of(7, 8, 9));
        List<Integer> flatList = list.stream()
                .flatMap(l -> l.stream())
                .collect(Collectors.toList());

        System.out.println(list);
        System.out.println(flatList);

        List<Integer> numbers = List.of(3,1,3,5,2);
        List<Integer> uniqueOrdered = numbers.stream()
                .distinct()
                .sorted()
                .toList();

        System.out.println(numbers);
        System.out.println(uniqueOrdered);

        Set<String> setNames = names.stream()
                .filter(name -> name.length() > 2)
                .collect(Collectors.toSet());
        System.out.println(setNames);

        long count = names.stream()
                .filter(name -> name.contains("a"))
                .count();
        System.out.println(count);

        int sum = numbers.stream()
                .reduce(0, (result, number) -> result + number);
        System.out.println(sum);

        names.stream()
                .map(String::toUpperCase)
                .forEach(System.out::println);
    }

}
