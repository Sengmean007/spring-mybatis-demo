
package com.sengmean.demo.repository;

import com.sengmean.demo.model.Article;
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
    public Article saveArticle(Article article) {
        Article article1 = new Article();
        article1.setName(article.getName());
        article1.setGender(article.getGender());
        article1.setAddress(article.getAddress());
        article1.setPhone(article.getPhone());
    return article;
    }

    @Override
    public void update(int id) {
        articles.get(id);
    }

    @Override
    public void deleteById(Integer id) {
       articles.remove(id);

    }

    @Override
    public Article findById(int id) {
        return articles.get(id);
    }
}



