package br.com.apimortalkombat.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.apimortalkombat.api.model.Usuarios;
import br.com.apimortalkombat.api.service.UsuariosService;

@RestController
@RequestMapping("/api/usuarios")
public class UsuariosController {
    @Autowired
    private UsuariosService service;

    @GetMapping
    public List<Usuarios> findAll() {
        return service.findAll();
    }

    @PostMapping
    public Usuarios save(Usuarios usuarios) {
        return service.save(usuarios);
    }

}
