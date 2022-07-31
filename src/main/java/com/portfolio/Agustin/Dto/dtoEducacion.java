/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.Agustin.Dto;

import javax.validation.constraints.NotBlank;


public class dtoEducacion {
    @NotBlank
    private String nombreEd;
    @NotBlank
    private String descripcionEd;
    
    //Constructor

    public dtoEducacion() {
    }

    public dtoEducacion(String nombreEd, String descripcionEd) {
        this.nombreEd = nombreEd;
        this.descripcionEd = descripcionEd;
    }
    
    //Getters y Setters

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
