package test.cicd;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @GetMapping("/test1")
    public String test1(){
        return "TEST1";
    }
    
    @GetMapping("/test2")
    public String test2(){
        return "TEST2";
    }
    
    @GetMapping("/test3")
    public String test3(){
        return "TEST3";
    }

    @GetMapping("/test4")
    public String test4(){
        return "TEST4";
    }
}
