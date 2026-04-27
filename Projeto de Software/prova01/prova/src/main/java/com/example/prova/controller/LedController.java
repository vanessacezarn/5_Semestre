package com.example.prova.controller;

import org.springframework.ui.Model;
import com.example.prova.conecction.ConexaoPorta;
import com.example.prova.model.Led;
import com.example.prova.service.LedService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import java.time.LocalDateTime;
import java.util.List;

@Controller
@RequestMapping("/led")
public class LedController {
    private final LedService ledService;
    private final ConexaoPorta conexaoPorta;

    public LedController(LedService ledService, ConexaoPorta conexaoPorta) {
        this.ledService = ledService;
        this.conexaoPorta = conexaoPorta;
    }

    @GetMapping("/ligar")
    public String ligar(@ModelAttribute Led led) {
        conexaoPorta.enviaDados('1');

        led.setEstado("LIGADO");
        led.setDataHora(LocalDateTime.now());
        ledService.salvar(led);
        return "ligar";
    }
    @GetMapping("/desligar")
    public String desligar(@ModelAttribute Led led) {
        conexaoPorta.enviaDados('2');
        led.setEstado("DESLIGADO");
        led.setDataHora(LocalDateTime.now());
        ledService.salvar(led);
        return "desligar";
    }

    @GetMapping("/historico")
    public String historico(Model model) {
        List<Led> leds = ledService.listarHistorico();
        model.addAttribute("leds",leds);

        return "historico";
    }

}
