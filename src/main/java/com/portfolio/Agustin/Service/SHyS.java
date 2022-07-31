/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.Agustin.Service;

import com.portfolio.Agustin.Entity.HyS;
import com.portfolio.Agustin.Repository.RHyS;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class SHyS {
    @Autowired
    RHyS rHyS;
    
    public List<HyS> list(){
        return rHyS.findAll();
    }
    
    public Optional<HyS> getOne(int id){
        return rHyS.findById(id);
    }
    
    public Optional<HyS> getByNombreHyS(String nombreHyS){
        return rHyS.findByNombreHyS(nombreHyS);
    }
    
    public void save(HyS hys){
        rHyS.save(hys);
    }
    
    public void delete(int id){
        rHyS.deleteById(id);
    }
    
    public boolean existsById(int id){
        return rHyS.existsById(id);
    }
    
    public boolean existsByNombreHyS(String nombreHyS){
        return rHyS.existsByNombreHyS(nombreHyS);
    }
}
