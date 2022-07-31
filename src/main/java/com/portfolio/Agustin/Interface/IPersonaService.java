package com.portfolio.Agustin.Interface;

import com.portfolio.Agustin.Entity.Persona;
import java.util.List;


public interface IPersonaService {
    //Traer Persona
    public List<Persona> getPersona();
    
    //Guardar un objeto del tipo Persona
    public void savePersona(Persona persona);
    
    //Eliminar un objeto pero lo buscamos por id
    public void deletePersona(Long id);
    
    //Buscar una Persona por id
    public Persona findPersona(Long id);
}
