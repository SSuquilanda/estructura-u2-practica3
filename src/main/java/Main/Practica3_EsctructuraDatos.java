/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package Main;

import controlador.ArbolContactos;
import modelo.Contacto;

/**
 *
 * @author samanthasuquilandaquilli
 */
public class Practica3_EsctructuraDatos {

    public static void main(String[] args) {
        ArbolContactos arbol = new ArbolContactos();
        
        Contacto c1 = new Contacto("Juan", "1234");
        Contacto c2 = new Contacto("Maria", "1234");
        Contacto c3 = new Contacto("Pedro", "1234");
        Contacto c4 = new Contacto("Pablo", "1234");

        arbol.insertar(c1);
        arbol.insertar(c2);
        arbol.insertar(c3);
        arbol.insertar(c4);
        arbol.insertar(new Contacto("Julina", "12345"));
        arbol.insertar(new Contacto("Jhon", "12345"));

    }
}
