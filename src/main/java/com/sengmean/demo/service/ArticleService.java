
package com.sengmean.demo.service;

import com.sengmean.demo.model.Article;

import java.util.List;

/**
 * Sengmean 01/04/2019
 */
public interface ArticleService {

    List<Article> findAll();

    Article saveArticle(Article article);

    void update(int id);

    void deleteById(Integer id);

    Article findById(int id);
}


