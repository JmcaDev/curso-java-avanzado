package com.devtalles.proyecto.ternarios;

public class Main {
    public static void main(String[] args) {
        int age = 17;
        String message;

        //Tradicional
//        if(age >= 18){
//            message = "Mayor de edad";
//        }else{
//            message = "Menor de edad";
//        }
//
//        System.out.println(message);

        //Ternario
        message = age >= 18 ? "Mayor de edad" : "Menor de edad";

        System.out.println(message);

        int score = 75;
        String level;

//        if(score >= 90){
//            level = "Excelente";
//        }else if(score >= 70){
//            level = "Bueno";
//        }else{
//            level = "Regular";
//        }

        level = score >= 90 ? "Excelente" : score>=70 ? "Bueno" : "Regular";
        System.out.println(level);

        int accessLevel = 2;
        String accessMessage = "Acceso denegado.";

//        if(accessLevel >= 1){
//            if(accessLevel >= 3){
//                accessMessage = "Acceso Total.";
//            }else{
//                accessMessage = "Acceso parcial.";
//            }
//        }
        accessMessage = accessLevel >= 1 ? (accessLevel >= 3 ? "Acceso Total" : "Acceso Parcial.") : "Acceso denegado.";
        System.out.println(accessMessage);
    }
}
