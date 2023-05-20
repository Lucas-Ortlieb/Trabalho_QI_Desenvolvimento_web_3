package br.com.apimortalkombat.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.apimortalkombat.api.model.Arenas;
import br.com.apimortalkombat.api.repository.ArenasRepository;

@Service
public class ArenasService {
    @Autowired
    private ArenasRepository repository;

    public List<Arenas> findAll(){
        return repository.findAll();
    }

    public Arenas save(Arenas arenas){
        return repository.save(arenas);
    }
}