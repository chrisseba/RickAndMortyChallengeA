package cl.mobdev.RickAndMortyChallenge.dto;

import lombok.Data;

@Data
public class CharacterDTO {
    private Integer id;
    private String name;
    private String status;
    private String specie;
    private String type;
    private Integer episode_count;

}
