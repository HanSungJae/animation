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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;


    @GetMapping("/loginPage")
    public String loginPage(Model model, @RequestParam(value="message") Optional<String> loginResult){

        model.addAttribute("msg", Optional.ofNullable(loginResult)
                .get().orElseGet(() -> {return "";}));

        if (model.getAttribute("msg").equals("error")){
            model.addAttribute("msg", "ID/PW 확인 해주세요 ");
        }


        model.addAttribute("user", new User());
        return "login";
    }


    @GetMapping("/doLogin")
    public String doLogin(User user, RedirectAttributes re){
        User loginInfo = userService.getUser(user.getUserId(), user.getUserPw());
        if(loginInfo == null){
            re.addAttribute("message","error");
            return "redirect:/loginPage";
        }else{
            re.addAttribute("userId",loginInfo.getUserId());
            return "redirect:/";
        }
    }

    @GetMapping("/registerPage")
    public String registerPage(Model model){
        model.addAttribute("user", new User());
        return "register";
    }

    @PostMapping("/doRegister")
    public String doRegister(User user){
        userService.createUser(user);
        return "redirect:/loginPage";
    }


}
