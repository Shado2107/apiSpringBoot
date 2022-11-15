package sn.supdeco.blog.services.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import sn.supdeco.blog.models.Article;
import sn.supdeco.blog.repositories.ArticleRepository;
import sn.supdeco.blog.services.ArticleService;

@Service
@AllArgsConstructor
public class ArticleServiceImpl implements ArticleService{

    private final ArticleRepository articleRepository;

    @Override
    public Article create(Article article) {
        return articleRepository.save(article);
    }

    @Override
    public List<Article> getAll() {
        return articleRepository.findAll();
    }


    @Override
    public Article updateArticle(Article article) {
        return articleRepository.save(article);
    }

    @Override
    public Article findArticleById(Long id) {
        return articleRepository.findArticleById(id);
    }

    public void deleteArticle(Long id){
        articleRepository.deleteArticleById(id);
    }

}
