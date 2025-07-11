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

public class Expediente {
    int IUD;
    LocalDateTime Hora_inicio;
    LocalDateTime Hora_final;
    boolean Prioritario;
    String Asunto;
    Interesado Interesado;
    String Documento;
    static int cont =1;
    
    //Constructor

    public Expediente(boolean Prioridad, String Asunto, Interesado Interesado, String Documento) {
        this.Prioritario = Prioridad;
        this.Asunto = Asunto;
        this.Interesado = Interesado;
        this.Documento = Documento;
        this.Hora_inicio = LocalDateTime.now();
        this.IUD = 1000 + cont;
        cont++;
    }

    //Getters y setters
    public int getIUD() {
        return IUD;
    }

    public void setIUD(int IUD) {
        this.IUD = IUD;
    }

    public LocalDateTime getHora_inicio() {
        return Hora_inicio;
    }

    public LocalDateTime getHora_final() {
        return Hora_final;
    }

    public void setHora_final(LocalDateTime Hora_final) {
        this.Hora_final = Hora_final;
    }

    public boolean isPrioritario() {
        return Prioritario;
    }

    public void setPrioritario(boolean Prioridad) {
        this.Prioritario = Prioridad;
    }

    public String getAsunto() {
        return Asunto;
    }

    public void setAsunto(String Asunto) {
        this.Asunto = Asunto;
    }

    public Interesado getInteresado() {
        return Interesado;
    }

    public void setInteresado(Interesado Interesado) {
        this.Interesado = Interesado;
    }

    public String getDocumento() {
        return Documento;
    }

    public void setDocumento(String Documento) {
        this.Documento = Documento;
    }
}
