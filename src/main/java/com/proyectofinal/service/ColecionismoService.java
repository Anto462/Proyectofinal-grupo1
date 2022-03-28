/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.proyectofinal.service;

import com.proyectofinal.domain.Colecionismo;
import java.util.List;


public interface ColecionismoService {
    public List<Colecionismo> getColecionismos();
    
    public void save(Colecionismo colecionismo);
    
    public void delete(Colecionismo colecionismo);
    
    public Colecionismo getColecionismo(Colecionismo colecionismo);
}
