package br.com.apimortalkombat.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.apimortalkombat.api.model.Personagens;
import br.com.apimortalkombat.api.service.PersonagensService;

@RestController
@RequestMapping("/api/personagens")
public class PersonagensController {
    @Autowired
    private PersonagensService service;

    @GetMapping
    public List<Personagens> findAll() {
        return service.findAll();
    }

    @PostMapping
    public Personagens save(Personagens personagens) {
        return service.save(personagens);
    }

}
