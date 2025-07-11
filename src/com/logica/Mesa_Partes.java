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

public class Mesa_Partes {

    public Oficinas_administrativas oficina;
    public Decanato decanato;
    public Junta_universitaria junta;

    Nodo Cabeza;
    Nodo Cola;
    int cuenta;
    boolean vacia;

    // Constructor
    public Mesa_Partes() {
        vacia = true;
        cuenta = 0;

        oficina = new Oficinas_administrativas();
        decanato = new Decanato();
        junta = new Junta_universitaria();
    }

    // Método para añadir expediente a la cola
    public void añadir_mesa(Expediente n) {
        if (n == null) {
            System.out.println("Expediente no ingresado");
            return;
        }

        Nodo temp = new Nodo(n);

        if (temp.data.Prioritario == true) { // Alta prioridad
            if (Cabeza == null) {
                Cabeza = Cola = temp;
            } else {
                Cabeza.sig = temp;
                temp.prev = Cabeza;
                Cabeza = temp;
            }
        } else { // Baja prioridad
            if (Cola == null) {
                Cabeza = Cola = temp;
            } else {
                temp.sig = Cola;
                Cola.prev = temp;
                Cola = temp;
            }
        }

        cuenta++;
        vacia = false;
    }

    // Método para mover expediente al siguiente paso
    public Nodo mover_mesa() {
        if (vacia == true) {
            System.out.println("No hay expedientes en esta dependencia");
            return null;
        }

        Nodo temp = Cabeza;

        if (cuenta == 1) {
            Cabeza = Cola = null;
        } else {
            Cabeza = Cabeza.prev;
            Cabeza.sig = null;
            temp.prev = null;
        }

        cuenta--;

        if (cuenta == 0) {
            vacia = true;
        }

        return temp;
    }

    // Imprimir la cola actual
    public void imprimir_mesa() {
        Nodo temp = Cola;
        while (temp != null) {
            System.out.print("Nombre: " + temp.data.Interesado.Nombres + " <--> ");
            temp = temp.sig;
        }
        System.out.println("null");
    }

    // Método para retornar arreglo con nombres de interesados
    
public String[] listarNombres() {
    String[] resultado = new String[cuenta];
    int i = 0;

    // Recorremos desde la Cabeza (el que saldrá primero) hasta la Cola
    Nodo temp = Cabeza;
    while (temp != null) {
        resultado[i++] = temp.data.Interesado.Nombres;
        temp = temp.prev;
    }

    return resultado;
}




}
