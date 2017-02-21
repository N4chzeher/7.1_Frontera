import com.sun.org.apache.xerces.internal.dom.DeferredNotationImpl;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

/**
 * Created by NACHZEHER on 17/02/2017.
 */
public class Main {

    public static void main(String[] args) {


        List<Persona> listaPersonas = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);

        String menu=("CONTROL DE FRONTERA:\n1.- Paso de frontera" +
                "\n2.- Mostrar todas las personas\n" +
                "3.- Busqueda por nombre\n" +
                "4.- Busqueda por DNI\n" +
                "5.- Salir");

        System.out.println(menu);

        int option;


        do {
            option = scanner.nextInt();


            switch(option) {

                case 1:
                    scanner.nextLine();
                    System.out.println("***Agregar persona*** \nNombre: ");
                    String nom = scanner.nextLine();

                    String dni;
                    while ( true){

                        System.out.println("DNI: ");
                        dni = scanner.nextLine();
                        boolean resultado = Persona.checkDni(dni);

                        if (resultado){

                            break;
                        }else {

                            System.out.println("DNI invalido");
                        }

                    }



                    listaPersonas.add(new Persona(nom, dni));

                    System.out.println(menu);

                    break;
                case 2:
                    System.out.println(listaPersonas.toString());



                    break;
                case 3:
                    scanner.nextLine();

                    System.out.println("Nombre para buscar");
                    String busqnom = scanner.nextLine();
                    for(Persona nombre : listaPersonas ){

                        if (nombre.getNombre().equals(busqnom)){

                            System.out.println(nombre);
                        }

                }
                    break;

                case 4:
                    scanner.nextLine();

                    System.out.println("DNI para buscar");
                    String busqdni = scanner.nextLine();
                    for(Persona personaActual : listaPersonas ){

                        if (personaActual.getDNI().equals(busqdni)){

                            System.out.println(personaActual);
                        }

                    }

                    break;




                default:

                    System.out.println("****Opcion incorrecta! ****\nIngrese una opcion");


                    option=scanner.nextInt();


            }
        }while (option!=5);




    }
}
