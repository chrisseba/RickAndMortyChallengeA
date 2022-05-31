package cl.mobdev.RickAndMortyChallenge.utils;

import cl.mobdev.RickAndMortyChallenge.dto.CharacterDTO;
import cl.mobdev.RickAndMortyChallenge.dto.OriginDTO;
import cl.mobdev.RickAndMortyChallenge.model.CharacterModel;

import cl.mobdev.RickAndMortyChallenge.model.OriginModel;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

public class UtilsTest {

    @Test
    public void test_characterModelToCharacterDTO(){

        CharacterModel charModel = new CharacterModel();
        CharacterDTO charDTO = new CharacterDTO();
        List<String> episodeList = new ArrayList<>();

        episodeList.add("ep1");
        episodeList.add("ep2");

        charModel.setName("NalcaMan");
        charModel.setId(1);
        charModel.setSpecies("Chilote");
        charModel.setType("Mitologico");
        charModel.setEpisode(episodeList);
        charModel.setStatus("powered");

        charDTO.setName("NalcaMan");
        charDTO.setId(1);
        charDTO.setSpecies("Chilote");
        charDTO.setType("Mitologico");
        charDTO.setEpisodeCount(2);
        charDTO.setStatus("powered");

        CharacterDTO result = Utils.characterModelToCharacterDTO(charModel);

        assertEquals( charDTO.getId(), result.getId() );
        assertEquals( charDTO.getName(), result.getName() );
        assertEquals( charDTO.getId(), result.getId() );
        assertEquals( charDTO.getSpecies(), result.getSpecies() );
        assertEquals( charDTO.getEpisodeCount(), result.getEpisodeCount() );
        assertEquals( charDTO.getStatus(), result.getStatus() );
    }

    @Test
    public void test_originModelToOriginDTO(){
        OriginModel originModel = new OriginModel();
        OriginDTO originDTO = new OriginDTO();

        originModel.setName("Venus");
        originModel.setDimension("4ta");
        originModel.setUrl("www.venus.net");

        originDTO.setName("Venus");
        originDTO.setDimension("4ta");
        originDTO.setUrl("www.venus.net");

        OriginDTO result = Utils.originModelToOriginDTO(originModel);

        assertEquals( originDTO.getName(), result.getName() );
        assertEquals( originDTO.getDimension(), result.getDimension() );
        assertEquals( originDTO.getUrl(), result.getUrl() );
    }

}
