/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.Agustin.Dto;

import javax.validation.constraints.NotBlank;

public class dtoHyS {
  @NotBlank
    private String nombreHyS;
    @NotBlank
    private String imgHyS;  
    @NotBlank
    private String porcentajeHyS;
    
    //Constructores

    public dtoHyS() {
    }

    public dtoHyS(String nombreHyS, String imgHyS, String porcentajeHyS) {
        this.nombreHyS = nombreHyS;
        this.imgHyS = imgHyS;
        this.porcentajeHyS = porcentajeHyS;
    }

    //Getters y Setters

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
