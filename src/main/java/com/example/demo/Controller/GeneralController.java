package com.example.demo.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="general")
public class GeneralController {

    @GetMapping(value = "test")
//    @PreAuthorize("hasRole('USER')")
    public String test(){
        return "${spring.profiles.active}";
    }
    @GetMapping("/admin")
//    @PreAuthorize("hasRole('ADMIN')")
    public String adminOnly() {
        return "You are an admin!";
    }
}


