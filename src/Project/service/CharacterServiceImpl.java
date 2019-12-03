package Project.service;

import Project.DAO.CharactersDAO;
import hibernate.entity.Characters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class CharacterServiceImpl implements CharacterService {
    @Autowired
    private ImageFileService imageFileService;

    @Autowired
    private CharactersDAO characterDAO;


    @Override
    @Transactional
    public List<Characters> getCharacters() {
        return characterDAO.getCharacters();
    }

    @Override
    @Transactional
    public void saveCharacter(Characters character, MultipartFile file, String applicationPath) {
        String filename = imageFileService.saveFile(
                file,
                applicationPath,
                character.getPicture());

        if (filename != null) {
            character.setPicture(filename);
        }

        characterDAO.saveCharacter(character);
    }

    @Override
    @Transactional
    public Characters getCharacter(int theId) {
        return characterDAO.getCharacters(theId);
    }

    @Override
    @Transactional
    public void deleteCharacter(int theId) {
        characterDAO.deleteCharacter(theId);
    }

    @Override
    @Transactional
    public List<Characters> getCharacterByName(String theSearchTerm) {
        return characterDAO.getCharacterByName(theSearchTerm);
    }
}
