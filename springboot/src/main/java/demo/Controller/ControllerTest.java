package demo.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
public class ControllerTest {

    @GetMapping(path = "/test")
    public String test(@RequestParam(value = "name", defaultValue = "World") String name){
        System.out.println("test");
        return "test content:"+name;
    }
    public static void main(String[] args) {

    }
}