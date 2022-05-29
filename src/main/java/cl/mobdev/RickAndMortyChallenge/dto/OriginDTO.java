package cl.mobdev.RickAndMortyChallenge.dto;

import lombok.Data;

import java.util.List;

@Data
public class OriginDTO {
    private String name;
    private String url;
    private String dimension;
    private List<String> residents;
}
