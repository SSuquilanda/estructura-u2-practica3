/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import modelo.Contacto;
import modelo.Nodo;

/**
 *
 * @author samanthasuquilandaquilli
 */
public class ArbolContactos {

    private Nodo raiz;

    public ArbolContactos(Nodo raiz) {
        this.raiz = null;
    }

    public ArbolContactos() {
    }

    public void insertar(Contacto nuevoContacto) {
        if (raiz == null) {
            raiz = new Nodo(nuevoContacto);
        } else {
            insertarRecursivo(raiz, nuevoContacto);
        }

    }

    private void insertarRecursivo(Nodo nodo, Contacto nuevoContacto) {
        if (nuevoContacto.getNombre().compareTo(nodo.getContacto().getNombre()) < 0) {
            if (nodo.getLeft() == null) {
                nodo.setLeft(new Nodo(nuevoContacto));
            } else {
                insertarRecursivo(nodo.getLeft(), nuevoContacto);
            }
        } else if (nuevoContacto.getNombre().compareTo(nodo.getContacto().getNombre()) > 0) {
            if (nodo.getRight() == null) {
                nodo.setRight(new Nodo(nuevoContacto));
            } else {
                insertarRecursivo(nodo.getRight(), nuevoContacto);
            }
        } else {
            //Si el nombre del contacto nuevo es igual a uno ya existente

        }
    }

    public boolean estaEquilibrado() {
        return verificarBalance(raiz);
    }

    private boolean verificarBalance(Nodo nodo) {
        if (nodo == null) {
            return true; //Si es arbol vacio considero equilibrado
        }
        int alturaIzquierda = obtenerAltura(nodo.getLeft());
        int alturaDerecha = obtenerAltura(nodo.getRight());
        int diferencia = Math.abs(alturaIzquierda - alturaDerecha);

        //verificamos la diferencia de las alturas
        if (diferencia > 1) {
            return false;
        }
        return verificarBalance(nodo.getLeft()) && verificarBalance(nodo.getRight());
    }

    private int obtenerAltura(Nodo nodo) {
        if (nodo == null) {
            return 0;
        }
        int alturaIzquierda = obtenerAltura(nodo.getLeft());
        int alturaDerecha = obtenerAltura(nodo.getRight());

        return Math.max(alturaIzquierda, alturaDerecha) + 1;
    }

    public void eliminarContacto(String nombre) {
        raiz = eliminarContactoRecursivo(raiz, nombre);

    }

    public Nodo eliminarContactoRecursivo(Nodo nodo, String nombre) {
        if (nodo == null) {
            return nodo;
        }
        //Buscamos el nodo a eliminar
        if (nombre.compareTo(nodo.getContacto().getNombre()) < 0) {
            //Si el nombre es menor, es decir si nombre del contacto esta en el subarbol izquierdo
            nodo.setLeft(eliminarContactoRecursivo(nodo.getLeft(), nombre));
        } else if (nombre.compareTo(nodo.getContacto().getNombre()) > 0) {
            //Si el nombre es mayor, es decir si nombre del contacto esta en el subarbol derecho
            nodo.setRight(eliminarContactoRecursivo(nodo.getRight(), nombre));
        } else {
            //SI el nombre coincide, el nodo es el que deberias eliminar

            //Caso1: que el nodo no tenga
            if (nodo.getLeft() == null && nodo.getRight() == null) {

            }
            //Caso 2: que el nodo a eliminar tenga un solo hijo
            if (nodo.getLeft() == null) {
                return nodo.getRight();
            } else if (nodo.getRight() == null) {
                return nodo.getLeft();
            }
            //Caso 3: nodo con 2 hijos
            Nodo sucesor = encontrarMinimo(nodo.getRight());
            //Actualizamos el objeto contacto obtenido en [Encontrar minimo]
            nodo.setContacto(sucesor.getContacto());
            nodo.setRight(eliminarContactoRecursivo(nodo.getRight(), sucesor.getContacto().getNombre()));

        }
        return nodo;
    }

    private Nodo encontrarMinimo(Nodo nodo) {
        while (nodo.getLeft() != null) {
            nodo = nodo.getLeft();
        }
        return nodo;
    }
    public Contacto buscarContacto(String nombre) {
    Nodo nodoEncontrado = buscarContactoRecursivo(raiz, nombre);
    if (nodoEncontrado != null) {
        return nodoEncontrado.getContacto();
    }
    return null; // Si el contacto no se encuentra, devolvemos null
}

public Nodo buscarContactoRecursivo(Nodo nodo, String nombre) {
    if (nodo == null) {
        return null;
    }
    // Buscamos el nodo con el nombre indicado
    int comparacion = nombre.compareTo(nodo.getContacto().getNombre());
    if (comparacion < 0) {
        // Si el nombre es menor, está en el subárbol izquierdo
        return buscarContactoRecursivo(nodo.getLeft(), nombre);
    } else if (comparacion > 0) {
        // Si el nombre es mayor, está en el subárbol derecho
        return buscarContactoRecursivo(nodo.getRight(), nombre);
    } else {
        // Si el nombre coincide, hemos encontrado el contacto
        return nodo;
    }
}

    public void printTreeNode(Nodo raiz, String prefix, boolean isLeft) {
        if (raiz != null) {
            System.out.println(prefix + (isLeft ? "|--" : "|--") + raiz.getContacto());
            printTreeNode(raiz.getLeft(), prefix + (isLeft ? "| " : "  "), true);
            printTreeNode(raiz.getRight(), prefix + (isLeft ? "| " : "  "), false);

        }
    }
    
    //Imprimir el arbol en PostOrden
    public void postOrderRecursivo(Nodo nodo) {
        if (nodo != null) {

            inOrderRecursivo(nodo.getLeft());
            inOrderRecursivo(nodo.getRight());
            System.out.println(nodo.getContacto() + " - ");

        }

    }
    //Imprimir el arbol en PreOrden
    public void preOrderRecursivo(Nodo nodo) {
        if (nodo != null) {
            System.out.println(nodo.getContacto() + " - ");
            inOrderRecursivo(nodo.getLeft());
            inOrderRecursivo(nodo.getRight());
        }

    }
    //Imprimir el arbol en InOrder
    public void inOrderRecursivo(Nodo nodo) {
        if (nodo != null) {
            inOrderRecursivo(nodo.getLeft());
            System.out.println(nodo.getContacto() + " - ");
            inOrderRecursivo(nodo.getRight());
        }

    }
    //Imprimir Arbol por niveles
    public void imprimirPorNiveles() {
        if (raiz == null) {
            return;
        }
        Queue<Nodo> queue = new LinkedList<>();
        queue.add(raiz);
        while (!queue.isEmpty()) {
            Nodo nodoActual = queue.poll();
            System.out.println(nodoActual.getContacto());
            if (nodoActual.getLeft() != null) {
                queue.add(nodoActual.getLeft());
            }
            if (nodoActual.getRight() != null) {
                queue.add(nodoActual.getRight());
            }
        }
    }
    public int obtenerNumeroContactos() {
        return obtenerNumeroContactosRecursivo(raiz);
    }

    private int obtenerNumeroContactosRecursivo(Nodo nodoActual) {
        if (nodoActual == null) {
            return 0;
        }
        return 1 + obtenerNumeroContactosRecursivo(nodoActual.getLeft()) + obtenerNumeroContactosRecursivo(nodoActual.getRight());
    }

    public int obtenerNumeroNiveles() {
        return obtenerNumeroNivelesRecursivo(raiz);
    }

    private int obtenerNumeroNivelesRecursivo(Nodo nodoActual) {
        if (nodoActual == null) {
            return 0;
        }
        return 1 + Math.max(obtenerNumeroNivelesRecursivo(nodoActual.getLeft()), obtenerNumeroNivelesRecursivo(nodoActual.getRight()));
    }


    public Nodo getRaiz() {
        return raiz;
    }

    public void setRaiz(Nodo raiz) {
        this.raiz = raiz;
    }

}
