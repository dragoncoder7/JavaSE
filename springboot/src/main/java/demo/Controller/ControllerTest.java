package demo.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class ControllerTest {

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String test(){
        System.out.println("test");
        return "test";
    }
    public static void main(String[] args) {

    }
}
