package br.com.api.api.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "personagens")
public class Personagens {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Short id;
    @Column(nullable = false, length = 30, unique = true)
    private String nome_personagens;
    @Column(nullable = false, length = 15)
    private String genero;
    @Column(nullable = false, length = 20)
    private String especie;
    @Column(nullable = false, length = 20)
    private String estilo_de_luta;
    @Column(nullable = false, length = 3)
    private Short idade;
    @Column(nullable = false, length = 30)
    private String arma;

    @ManyToMany (cascade = CascadeType.PERSIST)
    @JoinTable(
        name = "personagens_arenas",
        joinColumns = @JoinColumn(name = "personagens_id"),
        inverseJoinColumns = @JoinColumn(name = "arenas_id")
    )
    private List<Arenas> arenas;
    

    public Short getId() {
        return id;
    }
    public void setId(Short id) {
        this.id = id;
    }
    public String getNome_personagens() {
        return nome_personagens;
    }
    public void setNome_personagens(String nome_personagens) {
        this.nome_personagens = nome_personagens;
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
    public Short getIdade() {
        return idade;
    }
    public void setIdade(Short idade) {
        this.idade = idade;
    }
    public String getArma() {
        return arma;
    }
    public void setArma(String arma) {
        this.arma = arma;
    }
    
    public List<Arenas> getArenas() {
        return arenas;
    }
    public void setArenas(List<Arenas> arenas) {
        this.arenas = arenas;
    }
    
}