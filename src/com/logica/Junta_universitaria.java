/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.logica;

import java.time.LocalDateTime;

/**
 *
 * @author Walter
 */
//Hecho por Andrés Alejandro Bejar Yabar - 20230352

public class Junta_universitaria {
    Nodo Cabeza;
    Nodo Cola;
    int cuenta;
    boolean vacia;

    //Constructor
    public Junta_universitaria() {
        Cabeza=null;
        Cola=null;
        vacia=true;
        cuenta=0; //Cuenta de elementos en cola
    }
    
    //Metodo añadir
    public void añadir_junta(Nodo n){
        if(n==null){
            System.out.println("Expediente no ingresado");
        }
        else{
        if(n.data.Prioritario==true){ //Caso alta prioridad
            if(Cabeza==null){ //Caso lista vacia
            Cabeza=Cola=n;
            }
            else{
                Cabeza.sig = n; //Enlace previo con la cabeza
                n.prev = Cabeza; //Enlace posterior con cabeza
                Cabeza = n; //Empilamos el nodo por arriba
            }
            cuenta++;
            vacia=false;
        }
        else{ //Caso baja prioridad
            if(Cola==null){
            Cabeza=Cola=n; //Caso lista vacia
            }
            else{
                n.sig=Cola; //Enlace con la cola de la lista
                Cola.prev=n; //Enlace con el nodo a añadir
                Cola=n; //Encolamos el nodo por debajo
            }
            cuenta++;
            vacia=false;
        }
        }
    }
    
    //Metodo completar
    public Expediente completar(){
       if (vacia == true) {
            System.out.println("No hay expedientes en esta dependencia.");
            return null;
        }
        else{
        Nodo temp = Cabeza; //Asignamos el expediente a temp
        if(cuenta == 1){ //Caso unico elemento en cola
            Cabeza = Cola = null;
            temp.data.Hora_final = LocalDateTime.now();
            cuenta --;
            vacia=true;
            return temp.data;
        }
        else{
        Cabeza=Cabeza.prev; //Modificamos la cabeza de la cola
        Cabeza.sig=null; //Rompemos enlace con el nodo a mover
        temp.prev=null; //Rompemos enlace con la cabeza de la lista
        cuenta--;
        if (cuenta==0) {
            vacia=true;
        }
        temp.data.Hora_final = LocalDateTime.now();
        return temp.data; //Retornamos el expediente temp para llevarlo al arbol
        }
        }
    }

    public void imprimir_junta(){
        Nodo temp = Cola;
        while(temp!=null){
            System.out.print("Nombre: " + temp.data.Interesado.Nombres + " <--> ");
            temp=temp.sig;
        }
        System.out.println(" null");
    }

public String[] listarNombres() {
    // crea un arreglo para almacenar la lista de nombres
    String[] nombres = new String[cuenta];
    
    //Se crea una variable temporal para recorrer desde el final (Cabeza)
    Nodo temp = Cabeza;
    
    //Se inicializa un valor i = 0 para poder llenar el arreglo
    int i = 0;
    
    //recorre la estructura desde la cabeza hacia atrás y almacena la lista de nombres
    while (temp != null) {
        nombres[i] = temp.data.Interesado.Nombres;
        temp = temp.prev;
        i++;
    }
    
    //Retorna el arreglo con todos los nombres
    return nombres;
}

    
}
