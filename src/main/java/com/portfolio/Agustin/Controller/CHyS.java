/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.Agustin.Controller;

import com.portfolio.Agustin.Dto.dtoHyS;
import com.portfolio.Agustin.Entity.HyS;
import com.portfolio.Agustin.Security.Controller.Mensaje;
import com.portfolio.Agustin.Service.SHyS;
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
@RequestMapping("HyS")
@CrossOrigin(origins="https://agustin-7979e.web.app/")
public class CHyS {
    @Autowired
    SHyS sHyS;
    
    @GetMapping("/lista")
    public ResponseEntity<List<HyS>> list(){
        List<HyS> list = sHyS.list();
        return new ResponseEntity(list,HttpStatus.OK);
    }
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<HyS> getById(@PathVariable("id") int id){
        if(!sHyS.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        HyS hys = sHyS.getOne(id).get();
        return new ResponseEntity(hys, HttpStatus.OK);
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoHyS dtohys){
    if(StringUtils.isBlank(dtohys.getNombreHyS()))
        return new ResponseEntity(new Mensaje("El nombre es obligatorio"),HttpStatus.BAD_REQUEST);
    if(sHyS.existsByNombreHyS(dtohys.getNombreHyS()))
        return new ResponseEntity(new Mensaje("Esa experiencia existe"),HttpStatus.BAD_REQUEST);
    
    HyS hys = new HyS(dtohys.getNombreHyS(),dtohys.getImgHyS(),dtohys.getPorcentajeHyS());
    sHyS.save(hys);
    return new ResponseEntity(new Mensaje("Experiencia agregado"),HttpStatus.OK);
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id,@RequestBody dtoHyS dtohys){
        if(!sHyS.existsById(id))
            return new ResponseEntity(new Mensaje("El id no existe"),HttpStatus.BAD_REQUEST);
        if(sHyS.existsByNombreHyS(dtohys.getNombreHyS()) && sHyS.getByNombreHyS(dtohys.getNombreHyS()).get().getId() != id)
            return new ResponseEntity(new Mensaje("Esa experiencia ya existe"),HttpStatus.BAD_REQUEST);
        if(StringUtils.isBlank(dtohys.getNombreHyS()))
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"),HttpStatus.BAD_REQUEST);
        HyS hys = sHyS.getOne(id).get();
        hys.setNombreHyS(dtohys.getNombreHyS());
        hys.setImgHyS(dtohys.getImgHyS());
        hys.setPorcentajeHyS(dtohys.getPorcentajeHyS());
        sHyS.save(hys);
        return new ResponseEntity(new Mensaje("Experiencia actualizada"),HttpStatus.OK);
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id){
        if(!sHyS.existsById(id))
            return new ResponseEntity(new Mensaje("El id no existe"),HttpStatus.BAD_REQUEST);
        sHyS.delete(id);
        return new ResponseEntity(new Mensaje("Experiencia eleiminada"),HttpStatus.OK);
    }
}
