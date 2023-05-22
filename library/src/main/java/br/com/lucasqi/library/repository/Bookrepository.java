package br.com.lucasqi.library.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.lucasqi.library.model.Book;

@Repository
public interface Bookrepository extends JpaRepository<Book,Long> {
    
}
