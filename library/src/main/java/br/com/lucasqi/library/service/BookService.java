package br.com.lucasqi.library.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.lucasqi.library.model.Book;
import br.com.lucasqi.library.model.Validation;
import br.com.lucasqi.library.repository.Bookrepository;

@Service
public class BookService {
    @Autowired
    private Bookrepository repository;

    public List<Book> findAll(){
        return repository.findAll();
    }

    public Book save(Book book) throws IllegalArgumentException {
        if(!Validation.titleValidate(book.getTitle())){
            throw new IllegalArgumentException("O título do livro deve conter de 3 a 100 caracteres");
        }
        if(!Validation.nameValidate(book.getAuthor())){
            throw new IllegalArgumentException("O nome do autor deve conter de 3 a 50 caracteres");
        }
        if(!Validation.nameValidate(book.getPublisher())){
            throw new IllegalArgumentException("O da editora deve conter de 3 a 50 caracteres");
        }
        return repository.save(book);
    }

    public Optional<Book> findOne(Long isbn){
        return repository.findById(isbn);
    }

    public void delete(Long isbn){
        repository.deleteById(isbn);
    } 

}
