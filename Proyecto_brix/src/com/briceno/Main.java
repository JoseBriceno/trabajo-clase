package com.briceno;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) {

        ArrayList<Cuenta> cuentas = new ArrayList();
        Scanner lector = new Scanner(System.in);
        System.out.println("********************");
        System.out.println("\tBienvenido");
        System.out.println("********************");
        while (true) {
            System.out.println("1. Crear Cuenta");
            System.out.println("2. Depositar");
            System.out.println("3. Retirar");
            System.out.println("4. Mostrar informacion de una cuenta");
            System.out.println("5. Mostrar Cuentas");
            System.out.println("6. Salir");
            int opcion = lector.nextInt();

            switch (opcion) {
                case 1:
                    int i = 0;
                    while (i == 0) {


                        System.out.println("**Creando una cuenta**");
                        Random rand = new Random();
                        int numeroCuenta = rand.nextInt(1000);
                        System.out.println("--Su numero de cuenta sera-- : " + numeroCuenta);
                        System.out.println("<--Especifique que tipo de cuenta desea crear-->");
                        System.out.println("\t 1. Cuenta de Ahorro");
                        System.out.println("\t 2. Cuenta a Largo Plazo");
                        int tipocuenta = lector.nextInt();
                        double saldo = LectorDeDatos.solicitarDouble("Ingrese el saldo inicial");
                        if (tipocuenta == 1) {

                            cuentaAhorro nuevaCuenta = new cuentaAhorro();
                            nuevaCuenta.ncuenta = numeroCuenta;
                            nuevaCuenta.saldo = saldo;
                            cuentas.add(nuevaCuenta);
                            System.out.println("**La cuenta ha sido creada**");
                        } else if (tipocuenta == 2) {
                            cuentaLargoplazo nuevaCuenta = new cuentaLargoplazo();
                            nuevaCuenta.ncuenta = numeroCuenta;
                            nuevaCuenta.saldo = saldo;
                            cuentas.add(nuevaCuenta);
                            System.out.println("**La cuenta ha sido creada**");
                        } else {
                            System.out.println("--Tipo de cuenta no existe--");
                        }
                        System.out.println("Desea crear otra cuenta : Si(0)---No(-1)");
                        i = lector.nextInt();

                    }
                    break;

                case 2:
                    int s = 0;
                    while (s == 0) {
                        System.out.println("**************");
                        System.out.println("Ingrese su numero de Cuenta :");
                        int indicecuenta = lector.nextInt();


                        if (cuentas.isEmpty()) {

                            System.out.println("<--El numero de cuenta que ingreso no existe-->");
                        }


                        for (Cuenta c : cuentas) {
                            if (indicecuenta == c.ncuenta) {
                                System.out.println("Ingrese el monto a depositar :");
                                double montoDeposito = lector.nextDouble();

                                System.out.println("\t Su saldo anterior es :" + c.saldo);

                                if (!c.depositar(montoDeposito)) {
                                    System.out.println("--El monto que ingreso sobrepasa los limites de ingreso--");

                                } else {
                                    System.out.println("\t Saldo monto :" + montoDeposito);
                                    System.out.println("\t Saldo actual :" + c.saldo);
                                    System.out.println("\n ---El deposito fue exitoso--- ");

                                }
                            } else {
                                System.out.println("----El numero de cuenta que ingreso no existe----");

                            }

                        }
                        System.out.println("Desea realizar otro deposito : Si(0)--No(-1)");
                        s = lector.nextInt();
                    }

                    break;

                case 3:
                    int h = 0;
                    while (h == 0) {

                        System.out.println("**************");
                        System.out.println("Ingrese su numero de Cuenta :");
                        int indcuenta = lector.nextInt();


                        if (cuentas.isEmpty()) {

                            System.out.println("El numero de cuenta que ingreso no existe");
                        }


                        for (Cuenta g : cuentas) {
                            if (indcuenta == g.ncuenta) {
                                System.out.println("Ingrese el monto que desea retirar :");
                                double montoRetiro = lector.nextDouble();

                                System.out.println("\t Su saldo anterior es :" + g.saldo);
                                if (!g.retirar(montoRetiro)) {
                                    System.out.println("**No tiene suficientes fondos para realizar esta accion**");

                                } else {

                                    System.out.println("\t Su retiro fue de :" + montoRetiro);
                                    System.out.println("\t Saldo actual :" + g.saldo);
                                    System.out.println("\n ---El retiro fue exitoso--- ");

                                }
                            } else {
                                System.out.println("----El numero de cuenta que ingreso no existe----");

                            }
                        }
                        System.out.println("Desea Realizar otro Retiro : Si(0)--No(-1)");
                        h= lector.nextInt();
                    }

                    break;

                case 4:
                    //Mostrando informacion de cuenta

                    int d = 0;
                    while (d == 0) {
                        System.out.println("**************");
                        System.out.println("Ingrese su numero de Cuenta :");
                        int icuenta = lector.nextInt();

                        for (Cuenta t : cuentas) {
                            String tipo = "";

                            if (icuenta == t.ncuenta) {

                                if (t instanceof cuentaAhorro)
                                    tipo = "Cuentas de Ahorro";

                                else if (t instanceof cuentaLargoplazo)
                                    tipo = "Cuenta a Largo Plazo";
                                System.out.println("<--Mostrando Datos de Cuenta-->");
                                System.out.println("\t Numero de Cuenta :" + t.ncuenta);
                                System.out.println("\t Tipo de cuenta :" + tipo);
                                System.out.println("\t Su Saldo Actual es de :" + t.saldo);
                            } else {
                                System.out.println("El numero de cuenta que ingreso no existe");
                            }

                        }
                        System.out.println("Desea Ingresar a otra Cuenta : Si(0)-- No(-1)");
                        d = lector.nextInt();

                    }
                    break;
                case 5:
                    //numero de cuenta-tipo de cuenta

                    int w = 0;
                    while (w == 0) {


                        if (cuentas.isEmpty()) {
                            System.out.println("--No hay cuenta--");
                        } else {
                            System.out.println("**--Mostrando Cuentas--**");
                        }

                        for (Cuenta C : cuentas) {
                            String tipo = "";
                            if (C instanceof cuentaAhorro)
                                tipo = "Cuentas de Ahorro";

                            else if (C instanceof cuentaLargoplazo)
                                tipo = "Cuenta a Largo Plazo";
                            System.out.println("\t Numero de Cuenta :" + C.ncuenta + "-" + tipo);


                        }
                        System.out.println("------:Salir al Menu (-1)");
                        w=lector.nextInt();
                    }
                    break;
                case 6:
                    System.out.println("Adios");
                    break;
                default:
                    System.out.println("Opcion no valida");
            }
            if (opcion == 6) {
                break;
            }
        }
    }
    public static int solicitarEntero (String mensaje) {
        Scanner lector = new Scanner(System.in);
        System.out.println(mensaje);
        try {
            int numero = lector.nextInt();
            return numero;
        } catch (InputMismatchException e) {
            System.out.println("El dato ingresado no es valido");
            solicitarEntero(mensaje);
            return LectorDeDatos.solicitarEntero(mensaje);
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
            return LectorDeDatos.solicitarDouble(mensaje);
        }
    }

}


