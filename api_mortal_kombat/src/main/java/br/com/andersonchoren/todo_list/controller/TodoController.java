package br.com.andersonchoren.todo_list.controller;

//import java.time.LocalDate;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.andersonchoren.todo_list.model.Todo;
import br.com.andersonchoren.todo_list.service.TodoService;

@RestController
@RequestMapping("/api/todo")
public class TodoController {
    TodoService service = new TodoService();

    @GetMapping
    public List<Todo> findAll() {
        return service.findAll();
    }

    @PostMapping
    public Todo addTodo(@RequestParam String nome_personagens, @RequestParam String genero, @RequestParam String especie, @RequestParam String estilo_de_luta, @RequestParam short idade, @RequestParam String arma) {
        //LocalDate lDate = convertToLocalDate(date);
        return service.addTodo(nome_personagens, genero, especie, estilo_de_luta, idade, arma, false);
    }

    @PutMapping
    public Todo editTodo(@RequestParam String nome_personagens, @RequestParam String genero, @RequestParam String especie, @RequestParam String estilo_de_luta, @RequestParam short idade, @RequestParam String arma) {
        //LocalDate lDate = convertToLocalDate(date);
        //boolean done = isDone.equals("true");
        return service.editTodo(nome_personagens, genero, especie, estilo_de_luta, idade, arma, false);
    }

    @DeleteMapping
    public void removeTodo(@RequestParam String nome_personagens) {
        service.removeTodo(nome_personagens);
    }
    /*
    private LocalDate convertToLocalDate(String date) {
        String[] dateList = date.split("/");
        LocalDate lDate = LocalDate.of(
                Integer.parseInt(
                        dateList[2] // Ano
                ),
                Integer.parseInt(
                        dateList[1] // Mês
                ),
                Integer.parseInt(
                        dateList[0] // Dia
                ));
        return lDate;
    }
    */
}
