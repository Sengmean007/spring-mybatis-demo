package com.sengmean.demo.controller;

import com.sengmean.demo.model.Article;
import com.sengmean.demo.pojo.Constant;
import com.sengmean.demo.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Sengmean 01/04/2019
 */
@RestController
//@RequestMapping("/rest/article")
public class Articlecontroller {

    @Autowired
    private ArticleService articleService;

    @Autowired
    public Articlecontroller(ArticleService articleService ) {
        this.articleService = articleService;
    }

   @RequestMapping(value = "/allArticle", method = RequestMethod.GET)
    public List<Article> articlePage(ModelMap model) {
        List<Article> articles = articleService.findAllarticle();
        model.addAttribute("article", articles);
        return articles;
    }


    @RequestMapping(value = "/Articles", method = RequestMethod.GET)
    public List<Article> homePage(ModelMap map) {
      List<Article> articles = articleService.findAll();
       map.addAttribute("articles",articles);
      return articles;
    }

 /*   @GetMapping("/all")
    public @ResponseBody List<Article> findAllArticle() {
        return articleService.findAll();
    }*/

    /**
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/Articles/{id}", method = RequestMethod.GET)
    public Article findArticleById(@PathVariable("id") Integer id) {
        if (id != null) {
            final String message1 = Constant.SUCCESSFUL;
            return articleService.findById(id);
        } else {
            final String message = Constant.FAIL;
            return null;
        }
    }

    /**
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/Articles/remove/{id}", method = RequestMethod.GET)
    public boolean deleteArticle(@PathVariable("id") Integer id) {
        if (id != null){
            return articleService.deleteById(id);
        } else {
            return false;
        }
    }

    /**
     *
     * @param article
     * @return
     */
    @PostMapping("/Article")
    public List<Article> createArticle(@RequestBody Article article) {
       // Article saveArt = articleService.saveArticle(article);
        return null;
    }
}
