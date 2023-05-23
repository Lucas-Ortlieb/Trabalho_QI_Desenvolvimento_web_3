package br.com.apimortalkombat.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.apimortalkombat.api.model.Usuarios;
import br.com.apimortalkombat.api.service.UsuariosService;

@RestController
@RequestMapping("/api/usuarios")
public class UsuariosController {
    @Autowired
    private UsuariosService service;

    @GetMapping
    public List<Usuarios> findAll() {
        return service.findAll();
    }

    @PostMapping
    public ResponseEntity<Object> save(@RequestBody Usuarios usuarios) {
        try {
            return new ResponseEntity<>(service.save(usuarios), HttpStatus.CREATED);
        } catch (IllegalArgumentException iae) {
            return new ResponseEntity<>(iae.getMessage(), HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            return new ResponseEntity<>("Houve um erro inesperado em nosso sistema, tente novamente mais tarde!!!",
                    HttpStatus.INTERNAL_SERVER_ERROR);
            // Gerar um log contendo o e.getMessage()
        }
    }

    @PutMapping
    public ResponseEntity<Object> edit(@RequestBody Usuarios usuarios) {
        try {
            var result = service.findOne(usuarios.getId());
            if (result.isPresent()) {
                return new ResponseEntity<>(service.save(usuarios), HttpStatus.CREATED);
            }
            return new ResponseEntity<>("O usuário informado não existe!!!", HttpStatus.NOT_FOUND);
        } catch (IllegalArgumentException iae) {
            return new ResponseEntity<>(iae.getMessage(), HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            return new ResponseEntity<>("Houve um erro inesperado em nosso sistema, tente novamente mais tarde!!!",
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable("id") Integer id) {
        try {
            service.delete(id);
            var result = service.findOne(id);
            if (result.isEmpty()) {
                return new ResponseEntity<>("Usuário removido com sucesso!!!", HttpStatus.OK);
            }
            return new ResponseEntity<>("Não foi possível remover o usuário informado!!!", HttpStatus.GONE);
        } catch (Exception e) {
            return new ResponseEntity<>("Houve um erro inesperado em nosso sistema, tente novamente mais tarde!!!",
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
