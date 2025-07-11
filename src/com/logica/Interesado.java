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


public class Interesado {
    // Atributos
    String Nombres;
    int DNI;
    int Telefono;
    String email;
    boolean Ulima;

    // NUEVO: Etapa actual del trámite
    String etapaActual; // Puede ser: "Mesa de Partes", "Oficina Administrativa", "Decanato", "Junta Universitaria", "Terminado"

    // Constructores
    public Interesado(String Nombres, int DNI, int Telefono, String email, boolean Ulima) {
        this.Nombres = Nombres;
        this.DNI = DNI;
        this.Telefono = Telefono;
        this.email = email;
        this.Ulima = Ulima;
        this.etapaActual = "Mesa de Partes"; // empieza siempre en Mesa de Partes
    }

    public Interesado() {
        this.etapaActual = "Mesa de Partes"; // por defecto también
    }

    // Getters y setters
    public String getNombres() {
        return Nombres;
    }

    public void setNombres(String Nombres) {
        this.Nombres = Nombres;
    }

    public int getDNI() {
        return DNI;
    }

    public void setDNI(int DNI) {
        this.DNI = DNI;
    }

    public int getTelefono() {
        return Telefono;
    }

    public void setTelefono(int Telefono) {
        this.Telefono = Telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

   

    public boolean isUlima() {
        return Ulima;
    }

    public void setUlima(boolean Ulima) {
        this.Ulima = Ulima;
    }

    // NUEVOS MÉTODOS PARA EL FLUJO

    public String getEtapaActual() {
        return etapaActual;
    }

    public void setEtapaActual(String etapaActual) {
        this.etapaActual = etapaActual;
    }

    public void avanzarEtapa() {
        //Evalua la etapa en la que esta el tramite
        switch (etapaActual) {
            case "Mesa de Partes":
                //Si esta en mesa de parte avanza a oficina administrativa
                etapaActual = "Oficina Administrativa";
                break;
            case "Oficina Administrativa":
                //Si esta en oficina administrativa avanza a decanato
                etapaActual = "Decanato";
                break;
            case "Decanato":
                //Si esta en decanato avanza a junta universitaria
                etapaActual = "Junta Universitaria";
                break;
                //Y por ultimo si esta en junta universitaria avanza a terminado
            case "Junta Universitaria":
                etapaActual = "Terminado";
                break;
        }
    }

    public boolean estaTerminado() {
        return etapaActual.equals("Terminado");
    }
    
}
