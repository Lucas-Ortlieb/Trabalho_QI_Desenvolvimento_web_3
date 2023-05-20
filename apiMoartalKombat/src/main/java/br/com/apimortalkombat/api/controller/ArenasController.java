package br.com.apimortalkombat.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.apimortalkombat.api.model.Arenas;
import br.com.apimortalkombat.api.service.ArenasService;

@RestController
@RequestMapping("/api/usuarios")
public class ArenasController {
    @Autowired
    private ArenasService service;

    @GetMapping
    public List<Arenas> findAll() {
        return service.findAll();
    }

    @PostMapping
    public Arenas save(Arenas arenas) {
        return service.save(arenas);
    }

}
