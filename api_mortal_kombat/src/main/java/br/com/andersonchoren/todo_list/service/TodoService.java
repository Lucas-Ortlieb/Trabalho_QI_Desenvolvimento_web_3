package br.com.andersonchoren.todo_list.service;

//import java.time.LocalDate;
import java.util.List;
import br.com.andersonchoren.todo_list.model.Todo;
import br.com.andersonchoren.todo_list.repository.DB;

public class TodoService {
    public List<Todo> findAll() {
        return DB.findAll();
    }

    public Todo addTodo(String nome_personagens, String genero, String especie, String estilo_de_luta, short idade, String arma, boolean isDone) throws IllegalArgumentException {
        if (nome_personagens.trim().isEmpty()) {
            throw new IllegalArgumentException("A descrição da tarefa não pode ficar vazia!!!");
        }
        //if (date.isBefore(LocalDate.now())) {
            //throw new IllegalArgumentException("A data da tarefa não pode ser inferior a data atual");
        //}
        return DB.addTodo(nome_personagens, genero, especie, estilo_de_luta, idade, arma, false);
    }

    public Todo editTodo(String nome_personagens, String genero, String especie, String estilo_de_luta, short idade, String arma, boolean isDone) throws IllegalArgumentException {
        if (nome_personagens.trim().isEmpty()) {
            throw new IllegalArgumentException("A descrição da tarefa não pode ficar vazia!!!");
        }
        //if (date.isBefore(LocalDate.now())) {
            //throw new IllegalArgumentException("A data da tarefa não pode ser inferior a data atual");
        //}
        return DB.editTodo(nome_personagens, genero, especie, estilo_de_luta, idade, arma, false);
    }
    
    public void removeTodo(String nome_personagens) throws IllegalArgumentException {
        if (nome_personagens.trim().isEmpty()) {
            throw new IllegalArgumentException("A descrição da tarefa não pode ficar vazia!!!");
        }
        DB.removeTodo(nome_personagens);
    }
}
