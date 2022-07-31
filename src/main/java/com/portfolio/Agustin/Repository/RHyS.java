/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.portfolio.Agustin.Repository;

import com.portfolio.Agustin.Entity.HyS;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RHyS extends JpaRepository<HyS, Integer>{
    public Optional<HyS> findByNombreHyS(String nombreHyS);
    public boolean existsByNombreHyS(String nombreHyS);
}
