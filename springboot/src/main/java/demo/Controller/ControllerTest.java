package demo.Controller;

import demo.Https.HTTP;
import org.springframework.web.bind.annotation.*;

@RestController
public class ControllerTest {

    @GetMapping(path = "/test1")
    public String test(){
        HTTP http = new HTTP();
//        for (int i = 0; i < 100; i++) {
//            http.Get("","https://api.lbbb.cc/api/zuanyulu");
//        }
        String res = http.Get("","https://api.lbbb.cc/api/zuanyulu");
        System.out.println(res);
        return "test";
    }
    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            System.out.println(new HTTP().Get("","https://api.lbbb.cc/api/zuanyulu"));
        }
    }
}
