
package com.sengmean.demo.service;

import com.sengmean.demo.model.Article;
import org.springframework.http.ResponseEntity;

import java.util.List;


/**
 * Sengmean 01/04/2019
 */

public interface ArticleService {

   List<Article> findAll();
    Article saveArticle(Article article);
    boolean update(int id);
    List<Article> findAllarticle();
    boolean deleteById(int id);
    Article findById(int id);
}


