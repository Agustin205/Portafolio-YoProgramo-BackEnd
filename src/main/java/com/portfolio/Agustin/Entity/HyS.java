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
public class HyS {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nombreHyS;
    private String imgHyS;
    private String porcentajeHyS;
    
    //Constructores

    public HyS() {
    }

    public HyS(String nombreHyS, String imgHyS, String porcentajeHyS) {
        this.nombreHyS = nombreHyS;
        this.imgHyS = imgHyS;
        this.porcentajeHyS = porcentajeHyS;
    }

    //Getters y Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombreHyS() {
        return nombreHyS;
    }

    public void setNombreHyS(String nombreHyS) {
        this.nombreHyS = nombreHyS;
    }

    public String getImgHyS() {
        return imgHyS;
    }

    public void setImgHyS(String imgHyS) {
        this.imgHyS = imgHyS;
    }

    public String getPorcentajeHyS() {
        return porcentajeHyS;
    }

    public void setPorcentajeHyS(String porcentajeHyS) {
        this.porcentajeHyS = porcentajeHyS;
    }
    
    
    
}
