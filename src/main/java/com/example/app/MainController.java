package com.example.app;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {
    @GetMapping("/hello")
    String index(){
        return Message.getMessage();
        //return "Hello there!";
    }//This is a start to testing
}
