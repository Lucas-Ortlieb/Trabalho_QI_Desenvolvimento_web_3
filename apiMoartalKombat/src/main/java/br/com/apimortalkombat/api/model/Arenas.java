package br.com.apimortalkombat.api.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "arenas")
public class Arenas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Short id;
    @Column(nullable = false, length = 30)
    private String nome_arena;
    @Column(nullable = false, length = 30)
    private String localizacao;
    @Column(nullable = false, length = 30)
    private String aparencia;
    @Column(nullable = false, length = 30)
    private String aparicoes;

    @ManyToMany(mappedBy = "personagens")
    private List<Personagens> personagens;

    public Short getId() {
        return id;
    }
    public void setId(Short id) {
        this.id = id;
    }
    public String getNome_arena() {
        return nome_arena;
    }
    public void setNome_arena(String nome_arena) {
        this.nome_arena = nome_arena;
    }
    public String getLocalizacao() {
        return localizacao;
    }
    public void setLocalizacao(String localizacao) {
        this.localizacao = localizacao;
    }
    public String getAparencia() {
        return aparencia;
    }
    public void setAparencia(String aparencia) {
        this.aparencia = aparencia;
    }
    public String getAparicoes() {
        return aparicoes;
    }
    public void setAparicoes(String aparicoes) {
        this.aparicoes = aparicoes;
    }
    public List<Personagens> getPersonagens() {
        return personagens;
    }
    public void setPersonagens(List<Personagens> personagens) {
        this.personagens = personagens;
    }
}
