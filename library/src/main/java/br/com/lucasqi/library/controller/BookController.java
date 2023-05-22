package br.com.lucasqi.library.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.lucasqi.library.model.Book;
import br.com.lucasqi.library.service.BookService;

@RestController
@RequestMapping("/api/book")
public class BookController {
    @Autowired
    private BookService service;
    
    @GetMapping
    public List<Book> findAll(){
        return service.findAll();
    }

    @PostMapping
    public ResponseEntity<Object> save(@RequestBody Book book){
        try{
            return new ResponseEntity<>(service.save(book), HttpStatus.CREATED);
        }catch(IllegalArgumentException iae){
            return new ResponseEntity<>(iae.getMessage(), HttpStatus.BAD_REQUEST);
        }catch(Exception e){
            return new ResponseEntity<>("Houve um erro inesperado, tente novamente mais tarde", HttpStatus.INTERNAL_SERVER_ERROR);

            //Gero um log contendo o e.getMessage()
        }
    }

    @PutMapping
    public ResponseEntity<Object> edit(@RequestBody Book book){
        try{
            var result = service.findOne(book.getIsbn());
            if(result.isPresent()){
            return new ResponseEntity<Object> (service.save(book), HttpStatus.CREATED);
            }
            return new ResponseEntity<>("O livro informado não existe", HttpStatus.NOT_FOUND);
        }catch(IllegalArgumentException iae){
            return new ResponseEntity<>(iae.getMessage(), HttpStatus.BAD_REQUEST);
        }catch(Exception e){
            return new ResponseEntity<>("Houve um erro inesperado, tente novamente mais tarde", HttpStatus.INTERNAL_SERVER_ERROR);

        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable ("id") Long isbn){
        try{
            service.delete(isbn);
            var book = service.findOne(isbn);
            if(book.isEmpty()){
                return new ResponseEntity<>("Livro removido com sucesso", HttpStatus.OK);
            }
            return new ResponseEntity<>("Não foi possível remover o livro informado", HttpStatus.GONE);
        }catch(Exception e){
            return new ResponseEntity<>("Houve um erro inesperado, tente novamente mais tarde", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
