
package com.sengmean.demo.service;

import com.sengmean.demo.model.Article;

import java.util.List;

/**
 * Sengmean 01/04/2019
 */
public interface ArticleService {

    List<Article> findAll();

    List<Article> saveArticle(Article article);

    boolean update(int id);

    List<Article> findAllarticle();

    boolean deleteById(int id);

    Article findById(int id);
}


