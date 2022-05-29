package cl.mobdev.RickAndMortyChallenge.service;

import cl.mobdev.RickAndMortyChallenge.dto.CharacterDTO;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class CharacterServiceImpl implements CharacterService{

    public Mono<CharacterDTO> getCharacterById(){
        CharacterDTO character = new CharacterDTO();

        character.setId(1);
        character.setName("1er mono");

        return Mono.just(character);
    }
}
