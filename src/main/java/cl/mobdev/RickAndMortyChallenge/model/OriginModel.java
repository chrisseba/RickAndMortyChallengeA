package cl.mobdev.RickAndMortyChallenge.model;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class OriginModel {
    private String name;
    private String url;
    private String dimension;
    private List<String> residents = new ArrayList<>();
}
