package Project.service;

import hibernate.entity.Characters;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface CharacterService {
    List<Characters> getCharacters();

    void saveCharacter(Characters character, MultipartFile file, String applicationPath);

    Characters getCharacter(int theId);

    void deleteCharacter(int theId);

    List<Characters> getCharacterByName(String theSearchTerm);
}
