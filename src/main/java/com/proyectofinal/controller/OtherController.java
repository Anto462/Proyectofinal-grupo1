
package com.proyectofinal.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Slf4j
public class OtherController {
    
        @GetMapping("/other/mapa")
    public String metod1(){       
        return "/other/mapa";
    }
    
    @GetMapping("/other/login")
    public String metod2(){       
        return "/other/login";
    }
}
