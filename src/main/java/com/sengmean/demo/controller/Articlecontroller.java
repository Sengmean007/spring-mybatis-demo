package com.sengmean.demo.controller;

import com.sengmean.demo.model.Article;
import com.sengmean.demo.pojo.Constant;
import com.sengmean.demo.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Sengmean 01/04/2019
 */
@RestController
@RequestMapping("/rest/article")
public class Articlecontroller {

    private ArticleService articleService;

    @Autowired
    public Articlecontroller(ArticleService articleService ) {
        this.articleService = articleService;
    }

    /**
     * To get all articles
     * @param model
     * @return
     */
   @RequestMapping(value = "/allArticle", method = RequestMethod.GET)
    public List<Article> articlePage(ModelMap model) {
        List<Article> articles = articleService.findAllarticle();
        model.addAttribute("article", articles);
        return articles;
    }

    /**
     * To find all Articles
     * @param map
     * @return
     */
    @RequestMapping(value = "/Articles", method = RequestMethod.GET)
    public List<Article> homePage(ModelMap map) {
      List<Article> articles = articleService.findAll();
       map.addAttribute("articles",articles);
      return articles;
    }

    /**
     * To find article by Id
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
     * To deleted article by id
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
     * To created new article
     * @param article
     * @return
     */
    @RequestMapping(value = "/Article/add", method = RequestMethod.POST)
    public List<Article> createArticle(@RequestBody Article article, Model model) {

        if (article.equals("")) { // check if article equals null
            List<Article> articles = new ArrayList<>();
            article.setName(article.getName());
            article.setGender(article.getGender());
            article.setAddress(article.getAddress());
            article.setPhone(article.getPhone());
            articles.add(article);

            model.addAttribute("articles", articles);
            String message = Constant.SUCCESSFUL;
            return articleService.saveArticle((Article) articles);
        } else {
            String message = Constant.FAIL;
        }
        return null;
    }

    /**
     * To update article by id
     * @param id
     */
    @RequestMapping(value = "/Article/update/{id}", method = RequestMethod.PUT)
    public void updateArticle(Integer id) {

        Article article = new Article();
        if (article.getId() == 0) {
            article.setName("");
            article.setAddress("");
            article.setGender("");
            article.setPhone("");
            articleService.update(id);
            String message = Constant.SUCCESSFUL;
        } else {
            String message = Constant.FAIL;
        }
    }
}
