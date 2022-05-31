package cl.mobdev.RickAndMortyChallenge.model;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class CharacterModel {

    private Integer id;
    private String name;
    private String status;
    private String species;
    private String type;
    private List<String> episode = new ArrayList<>();
    private OriginModel origin;
}
