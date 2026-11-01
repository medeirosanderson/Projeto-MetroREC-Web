package com.anderson.metrorecife.controller;

import com.anderson.metrorecife.model.Rota;
import com.anderson.metrorecife.service.RotaService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rotas")
public class RotaController {

    private final RotaService rotaService;

    public RotaController(RotaService rotaService) {
        this.rotaService = rotaService;
    }

    @GetMapping()
    public Rota calcularRota(@RequestParam Integer origem, @RequestParam Integer destino){
        return rotaService.calcularRota(origem, destino);
    }

    @GetMapping("/distancia")
    public double calcularDistancia(@RequestParam Integer origem, @RequestParam Integer destino) {
        return rotaService.calcularDistancia(origem, destino);
    }

    @GetMapping("/tempo")
        public double calcularTempo(@RequestParam Integer origemId, @RequestParam Integer destinoId){
            return rotaService.calcularTempo(origemId, destinoId);
    }


}