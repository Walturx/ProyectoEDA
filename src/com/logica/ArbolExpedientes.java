/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.logica;

/**
 *
 * @author Walter
 */
import java.time.LocalDateTime;

/**
 *
 * @author PC
 */


//Hecho por Jean Carlo de Jesus Rado Delgado - 20235056
public class ArbolExpedientes {
    ObjArbol raiz; // Nodo raíz del árbol

    public ArbolExpedientes(ObjArbol raiz) {//constructor
        this.raiz = raiz;
    }

    // Método para insertar un expediente en el árbol
    public void insertarExpediente(Expediente e) {
        ObjArbol obj = new ObjArbol(e); // Crea un nodo con el expediente
        raiz = agregarRecursivo(raiz, obj); // Inserta recursivamente en el árbol binario ordenado por DNI
    }

    // Método recursivo para insertar ordenadamente por DNI
    private ObjArbol agregarRecursivo(ObjArbol raiz, ObjArbol obj) {
        if (raiz == null) return obj; // Si llegamos a una hoja vacía, insertamos aquí

        // Si el DNI del expediente nuevo es menor al actual, va a la izquierda
        if (obj.exp.Interesado.DNI < raiz.exp.Interesado.DNI) {
            raiz.izq = agregarRecursivo(raiz.izq, obj);
        } else {
            // Si es mayor , va a la derecha
            raiz.der = agregarRecursivo(raiz.der, obj);
        }
        return raiz; // Retorna el nodo actual con las posibles ramas actualizadas
    }

  
    // Actualiza la hora final de un expediente según su IUD
    public void actualizarHoraFinal(int iud, LocalDateTime horaFin) {
        actualizarHoraRec(raiz, iud, horaFin); // Llama recursivamente
    }

    // Método recursivo para encontrar el IUD y actualizar su hora final
    private void actualizarHoraRec(ObjArbol nodo, int iud, LocalDateTime horaFin) {
        if (nodo != null) {
            actualizarHoraRec(nodo.izq, iud, horaFin); // Visita izquierda

            // Si el IUD coincide, se actualiza la hora final
            if (nodo.exp.IUD == iud) {
                nodo.exp.Hora_final = horaFin;
                System.out.println("Actualizada hora final del expediente " + iud);
            }

            actualizarHoraRec(nodo.der, iud, horaFin); // Visita derecha
        }
    }   

    // Busca un expediente por el DNI del interesado
    public Expediente buscarPorDNI(int dni) {
        Expediente resultado = buscarPorDNIRec(raiz, dni); // Busca recursivamente
        mostrarDatos(resultado); // Si se encuentra, muestra sus datos
        return resultado;
    }

    // Búsqueda recursiva en el árbol por DNI
 
    
    private Expediente buscarPorDNIRec(ObjArbol nodo, int dni) {
    if (nodo == null) return null; // Caso base: nodo nulo, expediente no encontrado

    int dniActual = nodo.exp.Interesado.DNI; // DNI actual del nodo

    if (dni == dniActual) {
        return nodo.exp; // Caso encontrado: retorna el expediente actual
    } else if (dni < dniActual) {
        // Si el DNI buscado es menor, busca en el subárbol izquierdo
        return buscarPorDNIRec(nodo.izq, dni);
    } else {
        // Si el DNI buscado es mayor, busca en el subárbol derecho
        return buscarPorDNIRec(nodo.der, dni);
    }
    
  }

    // Muestra todos los datos del expediente pasado como parámetro
  public String mostrarDatos(Expediente e) {
    if (e == null) {
        return "Error. No se encontró ningún expediente.";
    }

    String ulima = e.Interesado.Ulima ? "Sí" : "No";
    String prioridad = e.Prioritario ? "Alta" : "Baja";

    String mensaje = "DATOS DEL EXPEDIENTE ENCONTRADO:\n"
            + "-----------------------------------------------\n"
            + "ID Expediente: " + e.IUD + "\n"
            + "Nombre: " + e.Interesado.Nombres + "\n"
            + "DNI: " + e.Interesado.DNI + "\n"
            + "Teléfono: " + e.Interesado.Telefono + "\n"
            + "Email: " + e.Interesado.email + "\n"
            + "¿Pertenece a Ulima?: " + ulima + "\n"
            + "Prioridad: " + prioridad + "\n"
            + "Asunto: " + e.Asunto + "\n"
            + "Documento: " + e.Documento + "\n"
            + "Hora de Inicio: " + e.Hora_inicio + "\n"
            + "Hora de Finalización: " + e.Hora_final;

    return mensaje;
}
  
public Pila obtenerPorPrioridadEnPila(boolean prioridadBuscada) {//devuelve una pila con los expedientes que coinciden con la prioridad buscada
      Pila pila = new Pila(99999); // Tamaño máximo estimado
      llenarPilaPorPrioridad(raiz, prioridadBuscada, pila);// Se llena la pila con los expedientes que cumplen la condición de prioridad
      return pila;// Retorna la pila con los expedientes filtrados
    }

    private void llenarPilaPorPrioridad(ObjArbol nodo, boolean prioridadBuscada, Pila pila) {//Método recursivo que recorre el árbol
        if (nodo == null) return;// // Caso base: si el nodo es nulo, termina la recursión

        llenarPilaPorPrioridad(nodo.izq, prioridadBuscada, pila);

        if (nodo.exp.Prioritario == prioridadBuscada) {// Si el expediente del nodo cumple con la prioridad buscada, se añade a la pila
            pila.push(nodo.exp);
        }

        llenarPilaPorPrioridad(nodo.der, prioridadBuscada, pila);
    }
}

