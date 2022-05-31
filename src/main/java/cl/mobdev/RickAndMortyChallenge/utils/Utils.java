package cl.mobdev.RickAndMortyChallenge.utils;

import cl.mobdev.RickAndMortyChallenge.dto.CharacterDTO;
import cl.mobdev.RickAndMortyChallenge.dto.OriginDTO;
import cl.mobdev.RickAndMortyChallenge.model.CharacterModel;
import cl.mobdev.RickAndMortyChallenge.model.OriginModel;

public class Utils {

    public static CharacterDTO characterModelToCharacterDTO(CharacterModel charModel) {
        CharacterDTO charDto = new CharacterDTO();
        OriginDTO originDTO = new OriginDTO();

        if(charModel.getOrigin() != null){
            originDTO.setName(charModel.getOrigin().getName());
            originDTO.setUrl(charModel.getOrigin().getUrl());
        }
        else{
            originDTO.setName(null);
            originDTO.setUrl(null);
        }

        charDto.setId(charModel.getId());
        charDto.setName(charModel.getName());
        charDto.setSpecies(charModel.getSpecies());

        if(charModel.getEpisode() != null){
            charDto.setEpisodeCount(charModel.getEpisode().size());
        }else{
            charDto.setEpisodeCount(0);
        }

        charDto.setStatus(charModel.getStatus());
        charDto.setType(charModel.getType());
        charDto.setOrigin(originDTO);

        return charDto;
    }

    public static OriginDTO originModelToOriginDTO(OriginModel originModel) {
        OriginDTO originDTO = new OriginDTO();

        originDTO.setName(originModel.getName());
        originDTO.setUrl(originModel.getUrl());
        originDTO.setDimension(originModel.getDimension());
        originDTO.setResidents(originModel.getResidents());

        return originDTO;
    }

}
