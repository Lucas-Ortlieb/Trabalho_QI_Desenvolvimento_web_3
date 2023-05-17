package br.com.andersonchoren.todo_list.model;

//import java.sql.Date;
//import java.time.LocalDate;

public class Todo {
    private String nome_personagens;
    private String genero;
    private String especie;
    private String estilo_de_luta;
    private short idade;
    private String arma;
    //private LocalDate date;
    private boolean isDone;

    public Todo(String nome_personagens, String genero, String especie, String estilo_de_luta, short idade, String arma, boolean isDone) {
        this.nome_personagens = nome_personagens;
        this.genero = genero;
        this.especie = especie;
        this.estilo_de_luta = estilo_de_luta;
        this.idade = idade;
        this.arma = arma;
        //this.date = date;
        this.isDone = isDone;
    }

    public String getNome_personagens() {
        return nome_personagens;
    }

    public void setNome_personagens(String nome_personagens) {
        this.nome_personagens = nome_personagens;
    }
    /*
    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
    */
    public boolean isDone() {
        return isDone;
    }

    public void setDone(boolean isDone) {
        this.isDone = isDone;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public String getEstilo_de_luta() {
        return estilo_de_luta;
    }

    public void setEstilo_de_luta(String estilo_de_luta) {
        this.estilo_de_luta = estilo_de_luta;
    }

    public short getIdade() {
        return idade;
    }

    public void setIdade(short idade) {
        this.idade = idade;
    }

    public String getArma() {
        return arma;
    }

    public void setArma(String arma) {
        this.arma = arma;
    }

}
