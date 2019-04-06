
package com.sengmean.demo.repository;

import com.sengmean.demo.model.Article;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;


/**
 * Sengmean on 01/04/2019
 */
@Repository
public class ArticleRepositoryImp implements ArticleRepository {

    private List<Article> articles;
    private Article article;

    public ArticleRepositoryImp() {
    }

    public ArticleRepositoryImp(List<Article> articles) {
        this.articles = articles;
        }


    @Override
    public List<Article> findAll() {
        return articles;
    }

    @Override
    public List<Article> findAllarticle() {
        return articles;
    }

    @Override
    public List<Article> saveArticle(Article article) {
        Article article1 = new Article();
        article1.setId(article.getId());
        article1.setName(article.getName());
        article1.setGender(article.getGender());
        article1.setAddress(article.getAddress());
        article1.setPhone(article.getPhone());
        return null;
    }

    @Override
    public boolean update(int id) {
        articles.get(id);
        return false;
    }

    @Override
    public boolean deleteById(int id) {
       articles.remove(id);
       return false;
    }

    @Override
    public Article findById(int id) {
        return articles.get(id);
    }
}



