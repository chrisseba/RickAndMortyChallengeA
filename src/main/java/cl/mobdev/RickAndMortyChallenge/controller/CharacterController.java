package cl.mobdev.RickAndMortyChallenge.controller;

import cl.mobdev.RickAndMortyChallenge.dto.CharacterDTO;
import cl.mobdev.RickAndMortyChallenge.exception.CharacterNotFoundException;
import cl.mobdev.RickAndMortyChallenge.service.CharacterService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import java.util.LinkedHashMap;
import java.util.Map;

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

    @ExceptionHandler(CharacterNotFoundException.class)
    ResponseEntity<Object> characterNotFound(CharacterNotFoundException ex) {

        Map<String, Object> body = new LinkedHashMap<>();
        body.put( "message", ex.getMessage() );

        return new ResponseEntity<>(body,HttpStatus.NOT_FOUND);
    }
}
