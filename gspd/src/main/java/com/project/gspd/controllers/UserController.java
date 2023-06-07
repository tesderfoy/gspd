package com.project.gspd.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class UserController {
    private  final UserController administrationController;
    @GetMapping("/login")
    public String login()    {return "login";}

}
