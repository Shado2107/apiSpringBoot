package sn.supdeco.blog.services;

import java.util.List;

import org.springframework.stereotype.Service;

import sn.supdeco.blog.models.Article;

@Service
public interface ArticleService {
    Article create(Article article);
    List<Article> getAll();

    Article updateArticle(Article article);

    Article findArticleById(Long id);

    void deleteArticle(Long id);
}
