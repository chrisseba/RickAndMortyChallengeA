package cl.mobdev.RickAndMortyChallenge.service;

import cl.mobdev.RickAndMortyChallenge.dto.CharacterDTO;

import reactor.core.publisher.Mono;

public interface CharacterService {

    Mono<CharacterDTO> getCharacterById(Integer id);
}