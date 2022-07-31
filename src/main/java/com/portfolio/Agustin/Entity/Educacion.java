/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.Agustin.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Educacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nombreEd;
    private String descripcionEd;

    //Constructores
    public Educacion() {
    }

    public Educacion(String nombreEd, String descripcionEd) {
        this.nombreEd = nombreEd;
        this.descripcionEd = descripcionEd;
    }

    //Getters y Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombreEd() {
        return nombreEd;
    }

    public void setNombreEd(String nombreEd) {
        this.nombreEd = nombreEd;
    }

    public String getDescripcionEd() {
        return descripcionEd;
    }

    public void setDescripcionEd(String descripcionEd) {
        this.descripcionEd = descripcionEd;
    }

}
