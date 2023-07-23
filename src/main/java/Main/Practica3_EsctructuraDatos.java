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
                               --------  Menú Principal   -------
                               .1.  Agregar un nuevo contacto: 
                               .2.  Buscar contacto por su nombre: 
                               .3.  Eliminar contacto: 
                               .4.  Agregar un correo:
                               .5.  Agregar una red social:
                               .6.  Imprimir el arbol de contactos:
                               .7.  Obtener el número de contactos:
                               .8.  Obtener el número de contactos por niveles:
                               .9.  Imprimir arbol de contactos en recorrido PreOrden:
                               .10. Imprimir arbol en de contactos recorrido InOrden:
                               .11. Imprimir arbol de contactos en recorrido PostOrden:
                               .12. Imprimir arbol de contactos en recorrido por niveles:
                               .13. Salir
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
                        System.out.println("¿Desea crear un nuevo contacto con ese nombre? (Sí/No)");
                        String respuesta = teclado.next();
                        if (respuesta.equalsIgnoreCase("Sí") || respuesta.equalsIgnoreCase("Si")) {
                            System.out.print("Ingrese el número de teléfono para el nuevo contacto: ");
                            String nuevoTelefono = teclado.next();
                            Contacto contactoNuevo = new Contacto(nomBuscar, nuevoTelefono);

                            arbol.insertar(contactoNuevo);
                        }
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
                    System.out.println("Ha seleccionado la opcion 4: Agregar un correo al contacto ");
                    System.out.print("Ingrese el nombre del contacto al cual se le va a agregar el correo: ");
                    String nombreCorreo = teclado.next();
                    System.out.print("Ingrese el correo a agregar: ");
                    String correo = teclado.next();
                    Contacto contactoCorreo = arbol.buscarContacto(nombreCorreo);
                    if (contactoCorreo != null) {
                        contactoCorreo.agregarCorreo(correo);
                    } else {
                        System.out.println("Contacto no encontrado.");
                    }
                    break;
                case 5:
                    System.out.println("Ha seleccionado la opcion 5: Agregar una red social al contacto ");
                    System.out.print("Ingrese el nombre del contacto: ");
                    String nombreRedSocial = teclado.nextLine();
                    System.out.print("Ingrese el nombre de la red social: ");
                    String redSocial = teclado.nextLine();
                    System.out.print("Ingrese la URL de la red social: ");
                    String url = teclado.nextLine();
                    Contacto contactoRedSocial = arbol.buscarContacto(nombreRedSocial);
                    if (contactoRedSocial != null) {
                        contactoRedSocial.agregarRedSocial(redSocial, url);
                    } else {
                        System.out.println("Contacto no encontrado.");
                    }
                    break;
                case 6:
                    System.out.println("Este es el arbol con los contactos ingresados:");
                    arbol.printTreeNode(arbol.getRaiz(), " ", true);
                    System.out.println("-------------------------------------------------");
                case 7:
                    System.out.println("Ha seleccionado la opcion 7: Obtener el número de contactos que se han ingresado ");
                    System.out.println("-------------------------------------------------");

                    System.out.println("El número de contactos totales es: " + arbol.obtenerNumeroContactos());

                    break;
                case 8:
                    System.out.println("Ha seleccionado la opcion 8: Obtener el número de contactos por niveles ");
                    System.out.println("-------------------------------------------------");

                    System.out.println("El número de niveles del arbol es : " + arbol.obtenerNumeroNiveles());

                    break;
                case 9:
                    System.out.println("Ha seleccionado la opcion 4: Imprimir el arbol en recorrido PreOrden ");
                    System.out.println("-------------------------------------------------");

                    arbol.preOrderRecursivo(arbol.getRaiz());
                    break;
                case 10:
                    System.out.println("Ha seleccionado la opcion 5: Imprimir el arbol en recorrido InOrden ");
                    System.out.println("-------------------------------------------------");

                    arbol.inOrderRecursivo(arbol.getRaiz());
                    break;
                case 11:
                    System.out.println("Ha seleccionado la opcion 6: Imprimir el arbol en recorrido PostOrden ");
                    System.out.println("-------------------------------------------------");

                    arbol.postOrderRecursivo(arbol.getRaiz());
                    break;
                case 12:
                    System.out.println("Ha seleccionado la opcion 7: Imprimir el arbol en recorrido por Niveles ");
                    System.out.println("-------------------------------------------------");

                    arbol.imprimirPorNiveles();
                    break;
                case 13:
                    System.out.println("Gracias por preferirnos, que tengas un buen dia:)");

            }
        } while (opcion != 13);
    }
}
