/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.logica;

/**
 *
 * @author Walter
 */

//Hecho por Andrés Alejandro Bejar Yabar - 20230352

public class Nodo {
    Expediente data;
    Nodo sig;
    Nodo prev;

    //Constructor
    public Nodo(Expediente data) {
        this.data = data;
    }
    
    //Getters y setters
    public Expediente getData() {
        return data;
    }

    public void setData(Expediente data) {
        this.data = data;
    }

    public Nodo getSig() {
        return sig;
    }

    public void setSig(Nodo sig) {
        this.sig = sig;
    }

    public Nodo getPrev() {
        return prev;
    }

    public void setPrev(Nodo prev) {
        this.prev = prev;
    }
    
}
