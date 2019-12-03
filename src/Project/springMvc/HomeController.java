package Project.springMvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
    /*
In this class, create a @RequestMapping for the application root ("/")
The method should map to the index.jsp page you made earlier
Test that your new home page loads when Tomcat is started*/
    @RequestMapping("/")
    public String showHomePage(){
        // /WEB-INF/view/main-menu.jsp - is what people will see
        return "index";
    }

}
