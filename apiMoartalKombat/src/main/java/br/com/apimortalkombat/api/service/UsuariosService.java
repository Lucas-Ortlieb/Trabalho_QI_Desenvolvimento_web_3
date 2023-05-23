package br.com.apimortalkombat.api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.apimortalkombat.api.model.Usuarios;
import br.com.apimortalkombat.api.model.Validation;
import br.com.apimortalkombat.api.repository.UsuariosRepository;

@Service
public class UsuariosService {
    @Autowired
    private UsuariosRepository repository;

    public List<Usuarios> findAll() {
        return repository.findAll();
    }

    public Usuarios save(Usuarios usuarios) throws IllegalArgumentException {
        if (!Validation.nameValidate(usuarios.getNome_usuario())) {
            throw new IllegalArgumentException("O nome do usuário deve conter de 3 à 30 caracteres");
        }
        return repository.save(usuarios);
    }

    public Optional<Usuarios> findOne(Integer id) {
        return repository.findById(id);
    }

    public void delete(Integer id) {
        repository.deleteById(id);
    }

}
