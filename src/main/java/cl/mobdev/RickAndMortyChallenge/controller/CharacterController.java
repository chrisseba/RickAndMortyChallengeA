package cl.mobdev.RickAndMortyChallenge.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/character")
public class CharacterController {

    @GetMapping()
    private Mono<String> getCharacter() {
        return Mono.just("Hola Mundo");
    }
}
