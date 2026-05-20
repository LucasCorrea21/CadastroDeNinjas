package dev.java10x.CadastroDeNinjas.Missoes;

import dev.java10x.CadastroDeNinjas.Ninjas.Controller.NinjaModel;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "tb_missoes")

public class MissoesModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String dificuldade;
    private NinjaModel ninja;

    private String nomeHokageSolicitante;

    // Uma missão pode ter vários ninjas, uma lista de ninjas
    @OneToMany(mappedBy = "missoes")
    private List<NinjaModel> ninjas;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDificuldade() {
        return dificuldade;
    }

    public void setDificuldade(String dificuldade) {
        this.dificuldade = dificuldade;
    }

    public NinjaModel getNinja() {
        return ninja;
    }

    public void setNinja(NinjaModel ninja) {
        this.ninja = ninja;
    }

    public String getNomeHokageSolicitante() {
        return nomeHokageSolicitante;
    }

    public void setNomeHokageSolicitante(String nomeHokageSolicitante) {
        this.nomeHokageSolicitante = nomeHokageSolicitante;
    }
}




