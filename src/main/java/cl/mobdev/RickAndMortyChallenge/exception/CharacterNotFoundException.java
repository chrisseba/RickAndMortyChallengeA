package cl.mobdev.RickAndMortyChallenge.exception;

public class CharacterNotFoundException extends RuntimeException{
    public CharacterNotFoundException(Integer id) {
        super("Character: " + id +" is not found.");
    }
}
