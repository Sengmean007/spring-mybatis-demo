
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

    @Autowired(required = true)
    public ArticleServiceImp(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    @Override
    public List<Article> findAll() {
        return articleRepository.findAll();
    }

    @Override
    public Article saveArticle(Article article) {
        return (Article) articleRepository.saveArticle(article);
    }

    @Override
    public boolean update(int id) {
        return false;
    }

    @Override
    public List<Article> findAllarticle() {
        return articleRepository.findAllarticle();
    }

    @Override
    public boolean deleteById(int id) {
        articleRepository.deleteById(id);
        return false;
    }

    @Override
    public Article findById(int id) {
        return articleRepository.findById(id);
    }
}

