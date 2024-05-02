package com.eggerriese.weekplan;

import lombok.extern.java.Log;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Log
public class HelloWorldController {

    @GetMapping(path = "/hello")
    public String hello() {
        return "Servus";
    }

}
