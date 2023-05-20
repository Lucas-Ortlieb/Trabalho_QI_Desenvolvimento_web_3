package br.com.apimortalkombat.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.apimortalkombat.api.model.Usuarios;

@Repository
public interface UsuariosRepository extends JpaRepository<Usuarios, Integer> {
    
}
