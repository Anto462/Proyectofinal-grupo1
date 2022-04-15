package com.proyectofinal.controller;

import com.proyectofinal.domain.Colecionismo;
import com.proyectofinal.service.ColecionismoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@Slf4j
public class ColecionismoController {
    @Autowired
    private ColecionismoService colecionismoService;
    
    @GetMapping("/colecionismo/principal")
    public String inicio(Model model){       
        var colecionismos = colecionismoService.getColecionismos();
        model.addAttribute("colecionismos",colecionismos);
        return "/colecionismo/principal";
    }
     @GetMapping("/colecionismo/nuevo")
    public String nuevoColecionismo(Colecionismo colecionismo){       
        return "/colecionismo/modificar";
    }
    
     @PostMapping("/colecionismo/guardar")
    public String guardarColecionismo(Colecionismo colecionismo){
        colecionismoService.save(colecionismo);
        return "redirect:/colecionismo/principal";
    }
    
     @GetMapping("/colecionismo/modificar/{idColecionismo}")
    public String modificarColecionismo(Colecionismo colecionismo, Model model){
        colecionismo = colecionismoService.getColecionismo(colecionismo);
        model.addAttribute("colecionismo",colecionismo);
        return "/colecionismo/modificar";
    }
    
     @GetMapping("/colecionismo/eliminar/{idColecionismo}")
    public String eliminarColecionismo(Colecionismo colecionismo){
        colecionismoService.delete(colecionismo);
        return "redirect:/colecionismo/principal";
    }
    
}
