package dev.java10x.CadastroDeNinjas.Ninjas.Controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class NinjaController {
    @GetMapping("/boasvindas")
    public String boasvindas(){
        return "Está é a minha primeira mensagem nessa rota";
    }

    // Adicionar Ninja
    @PostMapping("/criar")
    public String criarNinja(){
        return "Crier Ninja";
    }

    // Mostrar todos os ninjas (READ)
    @GetMapping("/todos")
        public String mostrarTodosOsNinjas(){
        return "Mostrar Ninja";
    }

    // Mostrar ninjas por id (READ)

    @GetMapping("/todosID")
    public String mostrarTodosOsNinjasPorID(){
        return "Mostrar Ninjas Por ID";
    }

    // Alterar dados dos Ninjas
    @PutMapping("/alterarID")
    public String alterarNinjaPorID(){
        return "Altera Ninja Ninjas Por ID";
    }

    // Deletar Ninja
    @DeleteMapping("/deletarNinja")
    public String deletarNinjaPorID(){
        return "Deleta Ninja Ninjas Por ID";
    }

}