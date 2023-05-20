package br.com.apimortalkombat.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.apimortalkombat.api.model.Personagens;

@Repository
public interface PersonagensRepository extends JpaRepository<Personagens, Short> {
    
}
