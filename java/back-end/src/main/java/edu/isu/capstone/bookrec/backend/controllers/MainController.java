package edu.isu.capstone.bookrec.backend.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {
    @RequestMapping("/test")
    @ResponseBody
    public String testController() {
        return "Response was successful. You are authenticated!";
    }

    @RequestMapping({"", "/", "/index"})
    @ResponseBody
    public String home() {
        return "This is the home page!";
    }
}
