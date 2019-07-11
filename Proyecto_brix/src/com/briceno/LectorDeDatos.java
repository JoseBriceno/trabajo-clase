package com.briceno;

import java.util.InputMismatchException;
import java.util.Scanner;

public class LectorDeDatos {
    public static int solicitarEntero (String mensaje) {
        Scanner lector = new Scanner(System.in);
        System.out.println(mensaje);
        try {
            int numero = lector.nextInt();
            return numero;
        } catch (InputMismatchException e) {
            System.out.println("El dato ingresado no es valido");
            solicitarEntero(mensaje);
            return solicitarEntero(mensaje);
        }
    }
    public static double solicitarDouble (String mensaje) {
        Scanner lector = new Scanner(System.in);
        System.out.println(mensaje);
        try {
            double numero = lector.nextDouble();
            return numero;
        } catch (InputMismatchException e) {
            System.out.println("El dato ingresado no es valido");
            solicitarDouble(mensaje);
            return solicitarDouble(mensaje);
        }
    }
}
