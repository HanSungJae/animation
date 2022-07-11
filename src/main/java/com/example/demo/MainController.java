package com.example.demo;

import lombok.NoArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@NoArgsConstructor
public class MainController {

    @GetMapping("/hello")
    public String getMain(Model model){
        //model.addAttribute("info", )
        return "index";
    }

    @GetMapping("/mywork")
    public String mywork(){
        return "mywork";
    }

    @GetMapping("/mylikes")
    public String mylikes(){
        return "mylikes";
    }
    
    @GetMapping("/login")
    public String login(){
        return "login";
    }
    @GetMapping("/mypage")
    public String mypage(){
        return "mypage";
    }

    @GetMapping("/best")
    public String best(){
        return "best";
    }

    @GetMapping("/animation")
    public String animation(){
        return "animation";
    }

    @GetMapping("/emoji")
    public String emoji(){
        return "emoji";
    }


}
