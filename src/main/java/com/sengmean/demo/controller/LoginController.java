package com.sengmean.demo.controller;

import java.util.Map;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController("/Login")
public class LoginController {

	@RequestMapping(value="/login", method=RequestMethod.POST)
    public String userLoginPage() {
        return "redirect:/login";
    }
}
