package com.example.demo.controller;

import ch.qos.logback.core.net.SyslogOutputStream;
import com.example.demo.dto.Article;
import com.example.demo.dto.User;
import com.example.demo.service.ArticleService;
import com.example.demo.service.UserService;
import lombok.RequiredArgsConstructor;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;


    @GetMapping("/loginPage")
    public String loginPage(Model model){
        model.addAttribute("user", new User());
        return "login";
    }


    @GetMapping("/doLogin")
    public String doLogin(User user){
        User loginInfo = userService.getUser(user.getUserId(), user.getUserPw());
        if(loginInfo.getUserId() == null){

            System.out.println(loginInfo.getUserId());
            return "redirect:/loginPage";
        }else{
            return "redirect:/";
        }
    }

    @GetMapping("/registerPage")
    public String registerPage(Model model){
        model.addAttribute(new User());
        return "register";
    }

    @PostMapping("/doRegister")
    public String doRegister(User user){
        userService.createUser(user);
        return "redirect:/loginPage";
    }


}
