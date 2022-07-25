package com.example.demo.controller;

import com.example.demo.service.ArticleService;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class MainController {

    private final ArticleService articleService;
    @GetMapping("/")
    public String getMain(Model model){
        model.addAttribute("info", articleService.getArticles());
        model.addAttribute("ani", articleService.getAnimation());
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
