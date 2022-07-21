package com.example.demo.controller;

import com.example.demo.dto.Article;
import com.example.demo.service.ArticleService;
import lombok.RequiredArgsConstructor;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class MainController {

    private final ArticleService articleService;
    @GetMapping("/index")
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
    public String best(Model model){
        List<Article> top6 = articleService.getTop6Articles();
        JSONParser parser = new JSONParser();

        for(int i=0; i<top6.size(); i++){
            String files =  top6.get(i).getFiles();
            JSONArray parsedJsonArray = null;
            try {
                parsedJsonArray = (JSONArray) parser.parse(files);
                for (Object o: parsedJsonArray){
                    JSONObject jo = (JSONObject) o;
                    String sub_url = (String) jo.get("file_url");
                }
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }


        }
        List<Article> top3 = new ArrayList<>();
        top3.add(top6.get(0));
        top3.add(top6.get(1));
        top3.add(top6.get(2));

        List<Article> last3 = new ArrayList<>();
        last3.add(top6.get(3));
        last3.add(top6.get(4));
        last3.add(top6.get(5));


        model.addAttribute("top3",top3);
        model.addAttribute("last3",last3);

        return "best";
    }

    @GetMapping("/animation")
    public String animation(Model model){
        List<Article> AniArticles = articleService.getAnimation();
        model.addAttribute("aniArticle", AniArticles);
        return "animation";
    }

    @GetMapping("/emoji")
    public String emoji(){
        return "emoji";
    }

    @GetMapping("/article")
    public String article(@RequestParam(value="articleId") int articleId, Model model){
        Article info = articleService.getArticle(articleId);

        ArrayList<String> resultImages = new ArrayList<>();
        String images = info.getFiles();
        JSONParser parser = new JSONParser();

        JSONArray parsedJsonArray = null;
        try {
            parsedJsonArray = (JSONArray) parser.parse(images);
            for (Object o: parsedJsonArray){
                JSONObject jo = (JSONObject) o;
                String sub_url = (String) jo.get("file_url");
                resultImages.add(sub_url);
            }
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

        model.addAttribute("articleImages",resultImages);
        model.addAttribute("articleInfo", info);
        return "detail";
    }


}
