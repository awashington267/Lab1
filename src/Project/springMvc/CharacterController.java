package Project.springMvc;

import Project.service.CharacterService;
import Project.service.ClassService;
import hibernate.entity.Characters;
import hibernate.entity.Class;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/character")
public class CharacterController {
    @Autowired
    private CharacterService characterService;

    @Autowired
    private ClassService classService;

    @RequestMapping("/list")
    public String listDonuts(Model theModel) {
        List<Characters> theCharacterList = characterService.getCharacters();
        List<Class> theRoleList = classService.getRole();

        theModel.addAttribute("characters", theCharacterList);
        theModel.addAttribute("roles", theRoleList);

        return "/list-characters";
    }



    @InitBinder
    public void initBinder(WebDataBinder webDataBinder) {
        StringTrimmerEditor ste = new StringTrimmerEditor(true);

        webDataBinder.registerCustomEditor(String.class, ste);
    }
}
