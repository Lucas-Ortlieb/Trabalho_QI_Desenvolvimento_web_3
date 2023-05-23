package br.com.apimortalkombat.api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.apimortalkombat.api.model.Arenas;
import br.com.apimortalkombat.api.model.Validation;
import br.com.apimortalkombat.api.repository.ArenasRepository;

@Service
public class ArenasService {
    @Autowired
    private ArenasRepository repository;

    public List<Arenas> findAll(){
        return repository.findAll();
    }

    public Arenas save(Arenas arenas) throws IllegalArgumentException {
        if (!Validation.nameValidate(arenas.getNome_arena())) {
            throw new IllegalArgumentException("O nome do usuário deve conter de 3 à 30 caracteres");
        }
        return repository.save(arenas);
    }

    public Optional<Arenas> findOne(Short id) {
        return repository.findById(id);
    }

    public void delete(Short id) {
        repository.deleteById(id);
    }
}