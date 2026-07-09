package dev.java10x.CadastroDeNinjas.Ninjas.Controller;

import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ninjas") // prefixo base


public class NinjaController {
    private final NinjaService ninjaService;

    public NinjaController(NinjaService ninjaService) {
        this.ninjaService = ninjaService;
    }

    @GetMapping("/boasvindas")
    public String boasvindas(){
        return "Está é a minha primeira mensagem nessa rota";
    }

    // Adicionar Ninja
    @PostMapping("/criar")
    public ResponseEntity<String> criarNinja(@RequestBody NinjaDTO ninja){
        NinjaDTO novoNinja = ninjaService.criarNinja(ninja);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Ninja criado com sucesso: " + novoNinja.getNome() + "ID: " + novoNinja.getId());
    }

    // Mostrar todos os ninjas (READ)
    @GetMapping("/listar")
    public ResponseEntity<List<NinjaDTO>> listarNinjas(){
        List<NinjaDTO> ninjas = ninjaService.listarNinjas();
        return ResponseEntity.ok(ninjas);
    }
    // Mostrar ninjas por id (READ)
    @GetMapping("/listar/{id}")
    public ResponseEntity<?> listarNinjasPorID(@PathVariable Long id)
    {
        NinjaDTO ninjasPorID = ninjaService.listarNinjasPorID(id);
        if(ninjaService.listarNinjasPorID(id)!=null)
        {
            //return ResponseEntity.ok("Ninja listado com sucesso: " + ninjasPorID.getNome() + "ID: " + ninjasPorID.getId() + "Idade: " +  ninjasPorID.getIdade());
            return ResponseEntity.ok(ninjasPorID);
        }

        else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
            .body("Ninja com o ID: " + id + " não existe em nossos registros");
    }
    }

    // Alterar dados dos Ninjas
    @PutMapping("/alterar/{id}")
    public ResponseEntity<?> alterarNinjaPorID(@PathVariable Long id, @RequestBody NinjaDTO ninjaAtualizado){

        NinjaDTO ninja = ninjaService.atualizarNinja(id, ninjaAtualizado);
        if(ninja != null){
            return  ResponseEntity.ok(ninja);
        }
        else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Ninja com este o id " + id + " não foi encotrado");
        }
    }

    // Deletar Ninjas
    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<String> deletarNinjaPorID(@PathVariable Long id){
       if (ninjaService.listarNinjasPorID(id)!=null){
           ninjaService.deletarNinjaPorId(id);
           return ResponseEntity.ok("Ninja com id" + id + " deletado com sucesso");
       }
       else {
           return ResponseEntity.status(HttpStatus.NOT_FOUND)
           .body("Ninja com o ID " + id + " não foi encontrado");
       }
    }
}