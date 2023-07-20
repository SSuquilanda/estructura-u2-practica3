/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package Main;

import controlador.ArbolContactos;
import java.util.Scanner;
import modelo.Contacto;

/**
 *
 * @author samanthasuquilandaquilli
 */
public class Practica3_EsctructuraDatos {

    public static void main(String[] args) {
        ArbolContactos arbol = new ArbolContactos();
        Scanner teclado = new Scanner(System.in);
        int opcion = 0;

        do {
            System.out.println("""
                               Bienvenido al sistema de Gestion de Contactos 
                               .1. Agregar un nuevo contacto: 
                               .2. Buscar contacto por su nombre: 
                               .3. Eliminar contacto: 
                               .4. Imprimir arbol de contactos en recorrido PreOrden:
                               .5. Imprimir arbol en de contactos recorrido InOrden:
                               .6. Imprimir arbol de contactos en recorrido PostOrden:
                               .7. Imprimir arbol de contactos en recorrido por niveles:
                               .8. Salir
                                    """);

            opcion = teclado.nextInt();

            switch (opcion) {

                case 1:
                    System.out.println("Ha seleccionado la opcion 1: Agregar un Nuevo Contacto ");
                    System.out.println("Cuantos contactos desea agregar:");
                    int numeroDeContactos = teclado.nextInt();
                    for (int i = 0; i < numeroDeContactos; i++) {
                        System.out.println("Ingrese el nombre del contacto: ");
                        String nombre = teclado.next();
                        System.out.println("Ingrese el numero de telefono: ");
                        String numero = teclado.next();
                        Contacto contacto = new Contacto(nombre, numero);

                        arbol.insertar(contacto);
                    }
                    System.out.println(" Arbol binario de contactos creado exitosamente");
                    arbol.printTreeNode(arbol.getRaiz(), " ", true);
                    break;
                case 2:
                    System.out.println("Ha seleccionado la opcion 2: Buscar contacto por su nombre ");
                    System.out.println("Ingrese el nombre del contacto a buscar: ");
                    String nomBuscar = teclado.next();
                    Contacto contactoEncontrado = arbol.buscarContacto(nomBuscar);
                    if (contactoEncontrado != null) {
                        System.out.println("-------------------------------------------------");
                        System.out.println("Contacto encontrado:");
                        System.out.println("Nombre: " + contactoEncontrado.getNombre());
                        System.out.println("Teléfono: " + contactoEncontrado.getNumero());
                        System.out.println("-------------------------------------------------");

                    } else {
                        System.out.println("El contacto con nombre '" + nomBuscar + "' no se encontró.");
                    }

                    break;
                case 3:
                    System.out.println("Ha seleccionado la opcion 3: Eliminar contacto ");
                    System.out.println("Ingrese el nombre del contacto a eliminar: ");
                    String nombreC = teclado.next();
                    arbol.eliminarContacto(nombreC);
                    System.out.println("-------------------------------------------------");
                    System.out.println("Nuevo arbol eliminando el contacto con nombre " + nombreC);
                    arbol.printTreeNode(arbol.getRaiz(), " ", true);
                    break;
                case 4:
                    System.out.println("Ha seleccionado la opcion 4: Imprimir el arbol en recorrido PreOrden ");
                    arbol.preOrderRecursivo(arbol.getRaiz());
                    break;
                case 5:
                    System.out.println("Ha seleccionado la opcion 5: Imprimir el arbol en recorrido InOrden ");
                    arbol.inOrderRecursivo(arbol.getRaiz());
                    break;
               case 6:
                    System.out.println("Ha seleccionado la opcion 6: Imprimir el arbol en recorrido PostOrden ");
                    arbol.postOrderRecursivo(arbol.getRaiz());
                    break;
               case 7 :
                    System.out.println("Ha seleccionado la opcion 7: Imprimir el arbol en recorrido por Niveles ");
                    arbol.imprimirPorNiveles();
                    break;
               case 8 :
                   System.out.println("Gracias por preferirnos, que tengas un buen dia:)");
            
            }  
        }while(opcion !=8);
    }
}
