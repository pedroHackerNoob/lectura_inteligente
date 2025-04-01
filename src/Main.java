import Model.Libro;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static ArrayList<Libro> libros = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);
    private static String estadoTemp, titulo, autor;
    private static int codigo;

    static void menu(){
        System.out.println("\n");
        System.out.println(
                "[1]Registrar Libro\n" +
                        "[2]Prestar Libro\n" +
                        "[3]Devolver Libro\n" +
                        "[4]Consultar Libros\n");
        int selection = sc.nextInt();
        switch (selection) {
            case 1:
//                registra los libros
                registrar();
                break;
            case 2:
//                Prestar libro
                prestar();
                break;
            case 3:
//                devuelve libro
                devolver();
                break;
            default:
//                Consultar libros
                mostrar();
                break;
        }
    }
    static void registrar(){
        estadoTemp = "Disponible";

        System.out.println("Introduzca el libro");
        titulo = sc.next();
        System.out.println("Introduzca el autor");
        autor = sc.next();
        System.out.println("Introduzca el codigo");
        int editorial = sc.nextInt();

        libros.add(new Libro(titulo,autor,estadoTemp,editorial));
        mostrar();
        menu();
    }
    static void prestar(){
        estadoTemp = "Prestado";

        System.out.println("Introduzca el libro");
        titulo = sc.next();
        System.out.println("Introduzca el autor");
        autor = sc.next();
        System.out.println("Introduzca el codigo");
        int editorial = sc.nextInt();

        libros.add(new Libro(titulo,autor,estadoTemp,editorial));
        mostrar();
        menu();
    }
    static void devolver(){
        estadoTemp = "Disponible";
        System.out.println("Introduzca el libro");
        titulo = sc.next();
        System.out.println("Introduzca el autor");
        autor = sc.next();
        System.out.println("Introduzca el codigo");
        int editorial = sc.nextInt();

        libros.add(new Libro(titulo,autor,estadoTemp,editorial));
        libros.forEach(System.out::println);
        mostrar();
        menu();
    }
    static void mostrar(){
        estadoTemp = "Disponible";
        libros.add(new Libro("carpincho","GAYel",estadoTemp,102));
        libros.add(new Libro("circus","sebASS",estadoTemp,103));
        estadoTemp = "Prestado";
        libros.add(new Libro("Crack","Osito",estadoTemp,104));
        libros.add(new Libro("Meta","Telleachea",estadoTemp,105));
        libros.forEach(System.out::println);
        menu();
    }
    public static void main(String[] args) {
        menu();

    }
}