package cl.mobdev.RickAndMortyChallenge.controller;

import cl.mobdev.RickAndMortyChallenge.dto.CharacterDTO;
import cl.mobdev.RickAndMortyChallenge.service.CharacterService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/character")
public class CharacterController {

    private final CharacterService characterService;

    public CharacterController(CharacterService characterService){
        this.characterService = characterService;
    }

    @GetMapping("/{characterId}")
    private Mono<CharacterDTO> getCharacter(@PathVariable Integer characterId) {
        return characterService.getCharacterById(characterId);   }
}
