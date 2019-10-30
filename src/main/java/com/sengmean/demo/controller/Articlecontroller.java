package com.sengmean.demo.controller;

import com.sengmean.demo.model.Article;
import com.sengmean.demo.pojo.Constant;
import com.sengmean.demo.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Sengmean 01/04/2019
 */
@RestController
@RequestMapping("/api/article")
public class Articlecontroller {

    private ArticleService articleService;
    private Article article;

    @Autowired
    public Articlecontroller(ArticleService articleService ) {
        this.articleService = articleService;
    }

    /**
     * Get all Article
     * @return
     */
   @RequestMapping("/list")
    public ResponseEntity<?> getAll(){
        List<Article> articles = articleService.findAll();
        return new ResponseEntity<>(articles, HttpStatus.OK);
    }

    /**
     * To find article by Id
     * @param id
     * @return
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Article> findArticleById(@PathVariable("id") Integer id) {
        Article article = articleService.findById(id);
        if (id != null) {
            String mess = Constant.SUCCESSFUL;
            System.out.println("Article is founded");
            return new ResponseEntity<>(article, HttpStatus.OK);
        } else {
            String message = Constant.FAIL;
            System.out.println("Not founded Article");
            return new ResponseEntity<>(article, HttpStatus.BAD_REQUEST);
        }
    }

    /**
     * To deleted article by id
     * @param id
     * @return
     */
    @RequestMapping("/{id}")
    public void deleteArticle(@RequestParam("id") Integer id) {
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
//    @PostMapping(value = "/add")
    @RequestMapping(value = "/add", method = RequestMethod.PUT)
    public ResponseEntity<Article> createArticle(Article article) {

        article.setName(article.getName());
        article.setGender(article.getGender());
        article.setAddress(article.getAddress());
        article.setPhone(article.getPhone());
        articleService.saveArticle(article);
        String message = Constant.SUCCESSFUL;
       return new ResponseEntity<Article>(article, HttpStatus.OK);
    }

    /**
     * To update article by id
     * @param id
     */
    @RequestMapping(value = "/update/{id}", method = RequestMethod.PUT)
    public ResponseEntity<?> updateArticle(Integer id) {
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
