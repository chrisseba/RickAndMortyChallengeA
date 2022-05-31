package cl.mobdev.RickAndMortyChallenge.dto;

import cl.mobdev.RickAndMortyChallenge.model.OriginModel;
import lombok.Data;

@Data
public class CharacterDTO {
    private Integer id;
    private String name;
    private String status;
    private String species;
    private String type;
    private Integer episodeCount;
    private OriginDTO origin;
}
