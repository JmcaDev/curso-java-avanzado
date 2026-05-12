package com.devtalles.proyecto.function;

import java.util.function.BiFunction;
import java.util.function.Function;

public class FunctionExample {
    public static void main (String[] args){
        //String :: length = lambda de string.length()
        Function<String, Integer> stringLength = String::length; //Recibe y devuelve un valor
        int length = stringLength.apply("Programación");
        System.out.println("La longitud es: " + length);

        //Recibe dos valores
        BiFunction<Integer, Integer, String> sumToString = (a,b) -> "Resultado: " + (a+b);
        String result = sumToString.apply(1,2);
        System.out.println(result);
    }
}
