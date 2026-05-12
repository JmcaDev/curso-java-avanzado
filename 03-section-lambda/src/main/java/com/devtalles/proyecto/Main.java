package com.devtalles.proyecto;

public class Main {
    static void main(String[] args) {

        //Funcion anonima
        Operation operation = new Operation() {
            @Override
            public int operate(int a, int b) {
                return a + b;
            }
        };
        System.out.println(operation.operate(10, 20));

        //Funcion lambda
        Operation multiply = (a, b) -> a * b;
        System.out.println(multiply.operate(10, 20));

        Operation subtraction = (a, b) -> a - b;
        System.out.println(subtraction.operate(10, 20));

    }
}

@FunctionalInterface
interface Operation {
    int operate(int a, int b);

    default String show(){
        return "Soy una operación";
    }

    default String show2(){
        return "Soy una operación";
    }

    //Expresion lambda
    static Operation subtraction(){
        return (a, b) -> a - b;
    }
}
