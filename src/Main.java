import Model.Libro;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static private final ArrayList<Libro> libros = new ArrayList<>();
    static private final Scanner sc = new Scanner(System.in);

    private static String estadoTemp;
    private static String titulo, autor;
    private static int encontrado,codigo,id= 0, rm,edit;
//    libros guardados por default
    static void librodefec(){
        libros.add(new Libro("carpincho","GAYel","Disponible",102));
        libros.add(new Libro("circus","sebASS","Disponible",103));
        libros.add(new Libro("crack","Osito","Prestado",104));
        libros.add(new Libro("meta","Telleachea","Prestado",105));
    }
//    menu de software
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
//    ingresar titulo del libro
    static void tituloLibro() {
//        System.out.println("Introduzca el titulo del libro");
        try {
//            titulo = sc.next();
            titulo = "circus";
        } catch (Exception e) {
            System.out.println("Titulo invalido");
            sc.nextLine();
        }
        libros.add(new Libro(titulo,"null","null",000));
    }
//    registrar libro
    static void registrar(){
        estadoTemp = "Registrado";

        try {
            System.out.println("Introduzca el autor");
            autor = sc.next();
            System.out.println("Introduzca el codigo");
            codigo = sc.nextInt();

        } catch (Exception e) {
            System.out.println("Titulo invalido");
            sc.nextLine();
        }
        if(encontrado==3){
            libros.add(new Libro(titulo, autor,"Disponible", codigo));
        } else if (encontrado==1 || encontrado==2) {
            System.out.println("el libro ya ha sido registrado anteriormente");

        }
        mostrar();
    }
//    prestar libro
    static void prestar(){
        estadoTemp = "Prestado";
        System.out.println("\n\tPrestaciones\n");
        tituloLibro();
        buscarEstado();
        borrarLibroTemp();
        //        indica que la operacion ya fue hecha
        if (encontrado == 1) {
            System.out.println("El libro ha sido prestado");
            libros.get(edit).setEstado(estadoTemp);
        }
//      indica que la operacion se ha completado
        else if (encontrado == 2) {
            System.out.println("El libro ya ha sido prestado");
        }else {
            System.out.println("el libro no esta registrado");
        }
        mostrar();
    }
//    devolver libro
    static void devolver(){
        System.out.println("\n\tDevoluciones\n");
        tituloLibro();
        buscarEstado();
        borrarLibroTemp();
        //        indica que la operacion ya fue hecha
        if (encontrado == 1) {
            System.out.println("El libro ya ha sido devuelto");
        }
//      indica que la operacion se ha completado
        else if (encontrado == 2) {
            estadoTemp = "Disponible";
            System.out.println("El libro ha sido devuelto");
            libros.get(edit).setEstado(estadoTemp);

        }else {
            System.out.println("el libro no esta registrado");
        }
        mostrar();
    }
//    buscar el estado del libro
    static void buscarEstado(){

        for(Libro libros1 : libros){
//            se busca el titulo
            if(
                    libros1.getTitulo().equals(titulo) && libros1.getEstado().equals("Disponible")
                    ||
                    libros1.getTitulo().equals(titulo) && libros1.getEstado().equals("Prestado")
            )

            {

                System.out.println("Encontrado:\n");
                System.out.println("------------------------------------------------------------");
                System.out.println(libros1);
                System.out.println("------------------------------------------------------------");
                System.out.println("======================");
                System.out.println("Estado del libro:");
//                se asigna el id de donde esta el titulo
                edit = id;
                switch (libros1.getEstado()){
//                se cambia la disponibilidad del libro
                    case "Disponible" -> {
                        encontrado = 1;
                        System.out.println("\tDisponible");
                        System.out.println("=====================");
                    }
//                se cambia la disponibilidad del libro
                    case "Prestado" -> {
                        encontrado = 2;
                        System.out.println("\tPrestado");
                        System.out.println("=====================");
                    }
//                    se registra el libro
                    case "Registrado" -> encontrado = 3;
                }

            } else if (libros1.getTitulo().equals(titulo) && libros1.getEstado().equals("null")) {
//                System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
//                System.out.println("El titulo: " + titulo + "\ntemporal ha sido removido: Estado: " + libros1.getEstado());
//                System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
                rm = id;
                break;
            }

//            se va ajustando la id
            ++id;
        }
    }
//    mostrar
    static void mostrar(){
        System.out.println("\n\tLibros disponibles");
        for (Libro libro : libros) {
            System.out.println("------------------------------------------------------------");
            System.out.println(libro);
        }
        System.out.println("------------------------------------------------------------");
    }
    static void borrarLibroTemp(){
        if (rm >= 0){
            libros.remove(libros.get(rm));
        }
    }
    public static void main(String[] args) {

        librodefec();
        mostrar();
        devolver();
    }
}