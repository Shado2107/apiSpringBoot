package sn.supdeco.blog.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import lombok.AllArgsConstructor;
import sn.supdeco.blog.models.Article;
import sn.supdeco.blog.services.ArticleService;
import sn.supdeco.blog.services.dtos.ArticleCreationDto;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/v1/articles")
@AllArgsConstructor
public class ArticleController {

    private final ArticleService articleService;

    @PostMapping("/add")
    public ResponseEntity<Article> createArticle(@RequestBody ArticleCreationDto articleDto){
        Article article = new Article();
        article.setContent(articleDto.getContent());
        article.setTitle(articleDto.getTitle());

        return ResponseEntity.ok(articleService.create(article));
    }

    @GetMapping("")
    public ResponseEntity<List<Article>> getAllArticle() {

        return ResponseEntity.ok(articleService.getAll());
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Article> getArticleById (@PathVariable("id") Long id) {
        Article article = articleService.findArticleById(id);
        return new ResponseEntity<>(article, HttpStatus.OK);
    }

    @RequestMapping("/update")
    public ResponseEntity<Article> updateArticle(@RequestBody Article article) {
        Article updateArticle = articleService.updateArticle(article);
        return new ResponseEntity<>(updateArticle, HttpStatus.OK);
    }

    @RequestMapping("/delete/{id}")
    public ResponseEntity<?> deleteArticle(@PathVariable("id") Long id) {
        articleService.deleteArticle(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
