/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

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
    
    
    public void insertar (Contacto nuevoContacto){
        if(raiz == null){
            raiz = new Nodo (nuevoContacto);
        }else{
            insertarRecursivo(raiz, nuevoContacto);
        }
        
    }
    private  void insertarRecursivo(Nodo nodo, Contacto nuevoContacto){
        if(nuevoContacto.getNombre().compareTo(nodo.getContacto().getNombre()) < 0 ){
            if(nodo.getLeft()==null){
                nodo.setLeft(new Nodo(nuevoContacto));
            }else{
                insertarRecursivo(nodo.getLeft(),nuevoContacto);
            }
        }else if (nuevoContacto.getNombre().compareTo(nodo.getContacto().getNombre()) > 0 ){
           if(nodo.getRight()==null){
               nodo.setRight(new Nodo(nuevoContacto));
           }else{
               insertarRecursivo(nodo.getRight(),nuevoContacto);
           }
        }else{
            //Si el nombre del contacto nuevo es igual a uno ya existente
            
        }
    }
    
    public boolean estaEquilibrado(){
        return verificarBalance(raiz);
    }
    private boolean verificarBalance (Nodo nodo){
        if(nodo == null){
            return true; //Si es arbol vacio considero equilibrado
        }
        int alturaIzquierda = obtenerAltura(nodo.getLeft());
        int alturaDerecha = obtenerAltura(nodo.getRight());
        int diferencia = Math.abs(alturaIzquierda - alturaDerecha);
                
        //verificamos la diferencia de las alturas
         if(diferencia > 1) {
             return false;
         }
         return verificarBalance(nodo.getLeft()) && verificarBalance(nodo.getRight());
    }
     
    private int obtenerAltura(Nodo nodo) {
        if(nodo == null){
            return 0;
        }
        int alturaIzquierda = obtenerAltura(nodo.getLeft());
        int alturaDerecha = obtenerAltura(nodo.getRight());
        
        return Math.max(alturaIzquierda, alturaDerecha)+1;
        }
    }
    
    
    

