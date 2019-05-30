
package com.sengmean.demo.service;

import com.sengmean.demo.model.Article;

import java.util.List;

/**
 * Sengmean 01/04/2019
 */
public interface ArticleService {

    List<Article> findAll();

    void saveArticle(Article article);

    void update(int id);

    List<Article> findAllarticle();

    void deleteById(String id);

    Article findById(int id);
}


