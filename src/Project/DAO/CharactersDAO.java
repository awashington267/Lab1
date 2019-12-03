package Project.DAO;

import hibernate.entity.Characters;

import java.util.List;

public interface CharactersDAO {

    List<Characters> getCharacters();

    void saveCharacter(Characters character);

    Characters getCharacters(int theId);

    void deleteCharacter(int theId);

    List<Characters> getCharacterByName(String theSearchTerm);
}
