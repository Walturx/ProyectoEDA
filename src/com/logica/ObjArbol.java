/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.logica;

/**
 *
 * @author Walter
 */

//Hecho por Jean Carlo de Jesús Rado Delgado-20235056
public class ObjArbol {
    Expediente exp;
    ObjArbol izq;
    ObjArbol der;

    public ObjArbol(Expediente exp){
        this.exp = exp;
        this.izq = null;
        this.der = null;
    }
}

