
package com.sengmean.demo.service;

import com.sengmean.demo.model.Article;
import com.sengmean.demo.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Sengmean 9/4/2019
 */
@Service
public class ArticleServiceImp implements ArticleService {

    private ArticleRepository articleRepository;

    @Autowired
    public ArticleServiceImp(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    @Override
    public List<Article> findAll() {
        return articleRepository.findAll();
    }

    @Override
    public void saveArticle(Article article) {
        articleRepository.saveArticle(article);
    }

    @Override
    public void update(int id) {
        articleRepository.update(id);
    }

    @Override
    public List<Article> findAllarticle() {
        return articleRepository.findAllarticle();
    }

    @Override
    public void deleteById(String id) {
       articleRepository.deleteById(id);
    }

    @Override
    public Article findById(int id) {
        return articleRepository.findById(id);
    }
}

