package br.com.api.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.api.api.model.Arenas;

@Repository
public interface ArenasRepository extends JpaRepository<Arenas, Short> {
    
}
