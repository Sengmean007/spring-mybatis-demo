package com.sengmean.demo.controller;

import ch.qos.logback.core.net.SyslogOutputStream;
import com.sengmean.demo.model.Article;
import com.sengmean.demo.pojo.Constant;
import com.sengmean.demo.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Sengmean 01/04/2019
 */
@RestController
@RequestMapping("/article")
public class Articlecontroller {

    private ArticleService articleService;

    @Autowired
    public Articlecontroller(ArticleService articleService ) {
        this.articleService = articleService;
    }

    /**
     * Get all Article
     * @return
     */
   @RequestMapping
    public ResponseEntity getAll(){
        List<Article> articles = articleService.findAllarticle();
        return new ResponseEntity(articles, HttpStatus.OK);
    }

    /**
     * To find article by Id
     * @param id
     * @return
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Article findArticleById(@PathVariable("id") Integer id) {
        if (id != null) {
            articleService.findById(id);
            String message1 = Constant.SUCCESSFUL;
            System.out.println("Article is founded");
        } else {
            String message = Constant.FAIL;
            System.out.println("Article is founded");
        }
        return null;
    }

    /**
     * To deleted article by id
     * @param id
     * @return
     */
    @RequestMapping
    public void deleteArticle(@RequestParam("id") String id) {
        if (id != null){
            articleService.deleteById(id);
            String message = Constant.SUCCESSFUL;
            System.out.println("Deleted " + message);
        } else {
            String message = Constant.FAIL;
            System.out.println("Delete " + message);
        }
    }

    /**
     * To created new article
     * @param article
     * @return
     */
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ResponseEntity<?> createArticle(@RequestBody Article article) {
        articleService.saveArticle(article);
        String message = Constant.SUCCESSFUL;
       return new ResponseEntity<>("Article save "+message, HttpStatus.OK);
    }

    /**
     * To update article by id
     * @param id
     */
    @RequestMapping(value = "/update/{id}", method = RequestMethod.PUT)
    public ResponseEntity<?> updateArticle(int id) {
        articleService.findById(id);
        Article article = new Article();
        if ((article.getId() == 0) || (article.equals("") )){
            article.setName("Hot news");
            article.setAddress("Phnom penh");
            article.setGender("Male");
            article.setPhone("0987676564");
            articleService.saveArticle(article);
            String message = Constant.SUCCESSFUL;
            return new ResponseEntity<>("Save "+ message, HttpStatus.OK);
        } else {
            article.setName("Hot Dara");
            article.setAddress("Phnom penh");
            articleService.update(id);
            String message = Constant.SUCCESSFUL;
            return new ResponseEntity<>("Update"+message, HttpStatus.OK);
        }
    }
}
