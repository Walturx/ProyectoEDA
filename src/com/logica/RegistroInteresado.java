/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.logica;


/**
 *
 * @author Walter
 */
//Hecho por Walter Sebastian Melendez Julca
public class RegistroInteresado {
    //atributo que representa la mesa de partes donde se registraran los expedientes
    private Mesa_Partes mesa;
    
    //constructor que recibe la instancia de la mesa de partes para ser asignada por el atributo
    public RegistroInteresado(Mesa_Partes mesa) {
        this.mesa = mesa;
    }
    
    //Metodo para registrar un nuevo interesado junto con su expediente
    public void registrar(int dni, String nombres, int telefono, String email, String asunto, String documento, String tipoPersona, String prioridad) {
        
        //Verifica si la persona es de la Universidad de Lima
        boolean esUlima = tipoPersona.equals("Ulima");
        //Verifica si el expediente tiene prioridad alta
        boolean esAlta = prioridad.equals("Alta");
        //Crea un objeto ineresado con los datos recibidos
        Interesado interesado = new Interesado(nombres, dni, telefono, email, esUlima);
        //Crea un nuevo expediente asociado al interesado
        Expediente expediente = new Expediente(esAlta, asunto, interesado, documento);

        // Enviar a Mesa de Partes
        mesa.añadir_mesa(expediente);
    }
    
    


    //metodo getter y setter de la mesa de partes
    public Mesa_Partes getMesa() {
    return this.mesa;
}
    
    
}
