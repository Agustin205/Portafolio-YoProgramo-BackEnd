/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.Agustin.Controller;

import com.portfolio.Agustin.Dto.dtoProyectos;
import com.portfolio.Agustin.Entity.Proyectos;
import com.portfolio.Agustin.Security.Controller.Mensaje;
import com.portfolio.Agustin.Service.SProyectos;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("proy")
@CrossOrigin(origins="https://agustin-7979e.web.app/")
public class CProyectos {
    @Autowired
    SProyectos sProyectos;
    
    @GetMapping("/lista")
    public ResponseEntity<List<Proyectos>> list(){
        List<Proyectos> list = sProyectos.list();
        return new ResponseEntity(list,HttpStatus.OK);
    }
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<Proyectos> getById(@PathVariable("id") int id){
        if(!sProyectos.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        Proyectos proyectos = sProyectos.getOne(id).get();
        return new ResponseEntity(proyectos, HttpStatus.OK);
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoProyectos dtoproy){
    if(StringUtils.isBlank(dtoproy.getNombreP()))
        return new ResponseEntity(new Mensaje("El nombre es obligatorio"),HttpStatus.BAD_REQUEST);
    if(sProyectos.existsByNombreP(dtoproy.getNombreP()))
        return new ResponseEntity(new Mensaje("Esa experiencia existe"),HttpStatus.BAD_REQUEST);
    
    Proyectos proyectos = new Proyectos(dtoproy.getNombreP(),dtoproy.getDescripcionP(),dtoproy.getImgP());
    sProyectos.save(proyectos);
    return new ResponseEntity(new Mensaje("Experiencia agregado"),HttpStatus.OK);
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id,@RequestBody dtoProyectos dtoproy){
        if(!sProyectos.existsById(id))
            return new ResponseEntity(new Mensaje("El id no existe"),HttpStatus.BAD_REQUEST);
        if(sProyectos.existsByNombreP(dtoproy.getNombreP()) && sProyectos.getByNombreP(dtoproy.getNombreP()).get().getId() != id)
            return new ResponseEntity(new Mensaje("Esa experiencia ya existe"),HttpStatus.BAD_REQUEST);
        if(StringUtils.isBlank(dtoproy.getNombreP()))
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"),HttpStatus.BAD_REQUEST);
        Proyectos proyectos = sProyectos.getOne(id).get();
        proyectos.setNombreP(dtoproy.getNombreP());
        proyectos.setDescripcionP(dtoproy.getDescripcionP());
        proyectos.setImgP(dtoproy.getImgP());
        sProyectos.save(proyectos);
        return new ResponseEntity(new Mensaje("Experiencia actualizada"),HttpStatus.OK);
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id){
        if(!sProyectos.existsById(id))
            return new ResponseEntity(new Mensaje("El id no existe"),HttpStatus.BAD_REQUEST);
        sProyectos.delete(id);
        return new ResponseEntity(new Mensaje("Experiencia eleiminada"),HttpStatus.OK);
    }
}
