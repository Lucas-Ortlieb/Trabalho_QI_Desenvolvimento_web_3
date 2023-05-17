package br.com.andersonchoren.todo_list.repository;

//import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import br.com.andersonchoren.todo_list.model.Todo;

public class DB {
    private static List<Todo> toDos = new ArrayList<>();

    public static List<Todo> findAll() {
        return toDos;
    }

    public static Todo addTodo(String nome_personagens, String genero, String especie, String estilo_de_luta, short idade, String arma, boolean isDone) {
        Todo todo = new Todo(nome_personagens, genero, especie, estilo_de_luta, idade, arma, false);
        toDos.add(todo); // Persistir na base de dados
        return todo;
    }

    public static Todo editTodo(String nome_personagens, String genero, String especie, String estilo_de_luta, short idade, String arma, boolean isDone) {
        Todo todo = new Todo(nome_personagens, genero, especie, estilo_de_luta, idade, arma, false);
        for (int i = 0; i < toDos.size(); i++) {
            var element = toDos.get(i); // Pegar um elemento
            if (element.getNome_personagens() == todo.getNome_personagens()) {
                toDos.set(i, todo);
            }
        }
        return todo;
    }

    public static void removeTodo(String nome_personagens) {
        for (int i = 0; i < toDos.size(); i++) {
            var element = toDos.get(i); // Pegar o elemento
            if (element.getNome_personagens() == nome_personagens) {
                toDos.remove(i);
            }
        }
    }
}
