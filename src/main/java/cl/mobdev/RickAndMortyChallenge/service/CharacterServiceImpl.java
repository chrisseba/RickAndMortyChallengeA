package cl.mobdev.RickAndMortyChallenge.service;

import cl.mobdev.RickAndMortyChallenge.dto.CharacterDTO;
import cl.mobdev.RickAndMortyChallenge.exception.CharacterNotFoundException;
import cl.mobdev.RickAndMortyChallenge.model.CharacterModel;
import cl.mobdev.RickAndMortyChallenge.model.OriginModel;
import cl.mobdev.RickAndMortyChallenge.utils.Utils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;


@Service
public class CharacterServiceImpl implements CharacterService{

    @Value("${rickAndMortyApi.url}")
    private String API_URL;
    private WebClient client;

    @Bean(initMethod="init")
    private void webClientInitializer(){
        this.client = WebClient.create(API_URL);
    }

    @Override
    public Mono<CharacterDTO> getCharacterById(Integer id){
        return client.get()
                    .uri("/character/" + id)
                    .retrieve()
                    .bodyToMono(CharacterModel.class)
                    .flatMap(charModelValue -> {
                        if(charModelValue == null){
                            return Mono.empty();
                        }
                        return this.injectOriginToCharacter(Utils.characterModelToCharacterDTO(charModelValue));
                    }).onErrorMap(error -> new CharacterNotFoundException(id));
    }

    private Mono<CharacterDTO> injectOriginToCharacter(CharacterDTO characterDTO){
        String originURL = characterDTO.getOrigin().getUrl();

        if(originURL == null || originURL == ""){
            return Mono.just(characterDTO);
        }

        String originURI = originURL.substring(API_URL.length());
        return client.get()
                .uri(originURI)
                .retrieve()
                .bodyToMono(OriginModel.class)
                .flatMap(origin -> {
                    if(origin != null){
                        characterDTO.setOrigin(Utils.originModelToOriginDTO(origin));
                    }
                    return Mono.just(characterDTO);
                });
    }
}
