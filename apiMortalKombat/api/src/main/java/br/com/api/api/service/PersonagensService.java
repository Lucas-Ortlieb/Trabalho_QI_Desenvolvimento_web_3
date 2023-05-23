package br.com.api.api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.api.api.model.Personagens;
import br.com.api.api.model.Validation;
import br.com.api.api.repository.PersonagensRepository;

@Service
public class PersonagensService {
    @Autowired
    private PersonagensRepository repository;

    public List<Personagens> findAll() {
        return repository.findAll();
    }

    public Personagens save(Personagens personagens) throws IllegalArgumentException {
        if (!Validation.nameValidate(personagens.getNome_personagens())) {
            throw new IllegalArgumentException("O nome do usuário deve conter de 3 à 30 caracteres");
        }
        return repository.save(personagens);
    }

    public Optional<Personagens> findOne(Short id) {
        return repository.findById(id);
    }

    public void delete(Short id) {
        repository.deleteById(id);
    }

}
