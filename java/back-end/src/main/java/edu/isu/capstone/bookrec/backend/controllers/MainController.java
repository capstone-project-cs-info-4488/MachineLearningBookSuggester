package edu.isu.capstone.bookrec.backend.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {
    @RequestMapping("/test")
    public String testController() {
        return "Response was successful";
    }
}
