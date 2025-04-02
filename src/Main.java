import Model.Libro;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static private final ArrayList<Libro> libros = new ArrayList<>();
    static private final Scanner sc = new Scanner(System.in);

    private static String estadoTemp;
    private static String titulo;
    private static int encontrado;
    static int id= 0;
    static void librodefec(){
//        libros.add(new Libro("carpincho","GAYel","Disponible",102));
        libros.add(new Libro("circus","sebASS","Disponible",103));
//        libros.add(new Libro("crack","Osito","Prestado",104));
        libros.add(new Libro("meta","Telleachea","Prestado",105));
    }

    static void menu(){
        int selection = 4;
        System.out.println("\n");
        System.out.println(
                """
                        [1]Registrar Libro
                        [2]Prestar Libro
                        [3]Devolver Libro
                        [4]Consultar Libros
                        """);
        try {
            selection = sc.nextInt();
        }
        catch(Exception e) {
            System.out.println("Opcion Invalida");
            sc.next();
        }
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
            case 4:
//                Consultar libros
                mostrar();
                break;
        }
    }
    static void tituloLibro(){

    }
    static void registrar(){
        estadoTemp = "Disponible";

        System.out.println("Introduzca el libro");
        titulo = sc.next();
        System.out.println("Introduzca el autor");
        String autor = sc.next();
        System.out.println("Introduzca el codigo");
        int codigo = sc.nextInt();

        libros.add(new Libro(titulo, autor,estadoTemp, codigo));
        mostrar();
//        menu();
    }

    //    prestar e libro
    static void prestar(){

    }

    //    devolver el libro
    static void devolver(){
        estadoTemp = "Disponible";
        System.out.println("###############################");
        System.out.println("Devoluciones\nIntroduzca el titulo del libro");
        try {
            titulo = "cisco";
        } catch (Exception e) {
            System.out.println("Titulo invalido");
            sc.nextLine();
        }
        libros.add(new Libro(titulo,"Default","null",-1));
        buscar();
        libros.remove(id);
        if (encontrado ==0){
            System.out.println("el libro no esta registrado");
        } else if (encontrado == 1) {
            System.out.println("Libro ya esta disponible");
        }else if (encontrado == 2) {
            System.out.println("ya ha sido devuelto");
        }
        mostrar();
    }
    static void buscar(){
        for(Libro libros1 : libros){
            if (libros1.getEstado().equals("null")){
                System.out.println("libro de catalogo no encontrado");
                encontrado = 0;
                System.out.println(id);
                break;
            }
            if(libros1.getTitulo().equals(titulo)){
                System.out.println("libro de catalogo encontrado");
//                disponibilidad del libro
                if(libros1.getEstado().equals("Disponible")) {
                    encontrado =1;
                    break;
                } else if (libros1.getEstado().equals("Prestado")) {
                    encontrado =2;
                    break;
                }
            }
            ++id;
        }
        mostrar();
    }
//    mostrar
    static void mostrar(){
//        libros.forEach(System.out::println);
        System.out.println("###################################");
        for (Libro libro : libros) {
            System.out.println(libro);
        }
//        menu();
    }

    public static void main(String[] args) {

        librodefec();
        mostrar();
        devolver();
    }
}