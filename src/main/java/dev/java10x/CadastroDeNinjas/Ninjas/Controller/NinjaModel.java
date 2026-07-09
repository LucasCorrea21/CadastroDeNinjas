package dev.java10x.CadastroDeNinjas.Ninjas.Controller;

import dev.java10x.CadastroDeNinjas.Missoes.MissoesModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

//Entity transforma uma classe em uma entidade no Banco de Dados
// JPA = Java persistence API
@Entity
@Table(name = "tb_cadastro")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = "missoes")

public class NinjaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "id")
    private Long id;

    @Column(name = "nome")
    private String nome;

    @Column(unique = true)
    private String email;

    @Column (name = "imgurl")
    private String imgurl;

    @Column (name = "rank")
    private String rank;

    @Column (name = "idade")
    private int idade;

    // @ManyToOne Um ninja tem uma única missão (Muitos ninjas para uma missão)
    @ManyToOne
    @JoinColumn(name = "missoes_id") //Foreign Key (Chave Estrangeira)
    private MissoesModel missoes;
}