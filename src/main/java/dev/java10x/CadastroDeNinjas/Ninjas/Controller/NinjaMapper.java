package dev.java10x.CadastroDeNinjas.Ninjas.Controller;

import org.springframework.stereotype.Component;

@Component
public class NinjaMapper {
    public NinjaModel map(NinjaDTO ninjaDTO) {
        NinjaModel ninjaModel = new NinjaModel();
        ninjaModel.setId(ninjaDTO.getId());
        ninjaModel.setNome(ninjaDTO.getNome());
        ninjaModel.setRank(ninjaDTO.getRank());
        ninjaModel.setIdade(ninjaDTO.getIdade());
        ninjaModel.setEmail(ninjaDTO.getEmail());
        ninjaModel.setImgurl(ninjaDTO.getImgurl());
        ninjaModel.setMissoes(ninjaDTO.getMissoes());
        return ninjaModel;
    }

    public NinjaDTO map(NinjaModel ninjaModel) {
        NinjaDTO ninjaDTO = new NinjaDTO();
        ninjaDTO.setId(ninjaModel.getId());
        ninjaDTO.setNome(ninjaModel.getNome());
        ninjaDTO.setRank(ninjaModel.getRank());
        ninjaDTO.setIdade(ninjaModel.getIdade());
        ninjaDTO.setEmail(ninjaModel.getEmail());
        ninjaDTO.setImgurl(ninjaModel.getImgurl());
        ninjaDTO.setMissoes(ninjaModel.getMissoes());
        return ninjaDTO;
    }
}
