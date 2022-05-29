package cl.mobdev.RickAndMortyChallenge.controller;

import cl.mobdev.RickAndMortyChallenge.dto.CharacterDTO;
import cl.mobdev.RickAndMortyChallenge.service.CharacterService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
@RestController
@RequestMapping("/character")
public class CharacterController {

    private final CharacterService characterService;

    @GetMapping()
    private Mono<CharacterDTO> getCharacter() {
        return characterService.getCharacterById();   }
}
