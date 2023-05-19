package br.com.apimortalkombat.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.apimortalkombat.api.model.Usuarios;
import br.com.apimortalkombat.api.repository.UsuariosRepository;

@Service
public class UsuariosService {
    @Autowired
    private UsuariosRepository repository;

    public List<Usuarios> findAll() {
        return repository.findAll();
    }

    public Usuarios save(Usuarios usuarios) {
        return repository.save(usuarios);
    }

}
