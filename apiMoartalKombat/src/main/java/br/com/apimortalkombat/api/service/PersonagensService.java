package br.com.apimortalkombat.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.apimortalkombat.api.model.Personagens;
import br.com.apimortalkombat.api.repository.PersonagensRepository;

@Service
public class PersonagensService {
    @Autowired
    private PersonagensRepository repository;

    public List<Personagens> findAll() {
        return repository.findAll();
    }

    public Personagens save(Personagens personagens) {
        return repository.save(personagens);
    }

}
