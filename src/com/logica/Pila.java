/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.logica;

/**
 *
 * @author Walter
 */
//Hecho por Jean Carlo de Jesus Rado Delgado - 20235056

public class Pila {
    
    Expediente pila[];// Arreglo para almacenar los expedientes en la pila
    int cc = -1;//indica la posición actual en la pila (-1 significa pila vacía)

    // Constructor que inicializa la pila con un tamaño fijo 'n'
    public Pila(int n) {
        pila = new Expediente[n];
    }


    public void push(Expediente e) {// Inserta un expediente en la pila
        cc++;    // Incrementa el contador
        pila[cc] = e;//coloca el expediente en esa posición
    }

    public Expediente pop() {
        Expediente e = pila[cc];// saca el expediente en la posición 'cc'
        cc--;//decrementa el contador
        return e;//Devuelve el expediente
    }
    
    public void invertir() {//nvertir el orden de los elementos dentro de la pila
        for (int i = 0, j = cc; i < j; i++, j--) {
            Expediente temp = pila[i];
            pila[i] = pila[j];
            pila[j] = temp;
        }
    }
    
    // verifica si la pila está vacía  
    public boolean empty() {
        return cc == -1;//  si el contador es -1, indica que no hay elementos
    }
}


