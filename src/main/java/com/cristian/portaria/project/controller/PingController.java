package com.cristian.portaria.project.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/ping")
public class PingController {


    @RequestMapping(method = RequestMethod.GET, value = "p1")
    public String ping() {
        return "ping";
    }

}
