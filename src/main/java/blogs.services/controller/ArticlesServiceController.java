package blogs.services.controller;


import blogs.services.exception.ResourceNotFoundException;
import blogs.services.model.Article;
import blogs.services.model.Blog;
import blogs.services.repository.ArticleRepository;
import blogs.services.repository.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

/**
 * Created by manju on 26-06-2020.
 * Maintains creaation,deletion and updation of articles for a blog
 */
@RestController
public class ArticlesServiceController {

    @Autowired
    private BlogRepository blogRepository;

    @Autowired
    private ArticleRepository articleRepository;

    @GetMapping("/blogs/{blogId}/articles")
    public Page<Article> getAllArticlesByBlogId(@PathVariable (value = "blogId") Long blogId,
                                               Pageable pageable) {
        return articleRepository.findByBlogId(blogId,pageable);
    }

    @PostMapping("/blogs/{blogId}/articles")
    public Article createArticle(@PathVariable (value = "blogId") Long blogId,
                                 @Valid @RequestBody Article article) {
        return blogRepository.findById(blogId).map(blog -> {
            article.setBlog(blog);
            return articleRepository.save(article);
        }).orElseThrow(() -> new ResourceNotFoundException("BlogId " + blogId + " not found"));
    }

    @PutMapping("/blogs/{blogId}/articles/{articleId}")
    public Article updateArticle(@PathVariable (value = "blogId") Long blogId,
                                 @PathVariable (value = "articleId") Long articleId,
                                 @Valid @RequestBody Article articleRequest) {
        if(!blogRepository.existsById(blogId)) {
            throw new ResourceNotFoundException("BlogId " + blogId + " not found");
        }

        return articleRepository.findById(articleId).map(article -> {
            article.setArticleName(articleRequest.getArticleName());
            return articleRepository.save(article);
        }).orElseThrow(() -> new ResourceNotFoundException("articleId " + articleId + "not found"));
    }

    @GetMapping("/blogs/{blogId}/articles/{articleId}")
    public Optional<Article> updateArticle(@PathVariable (value = "blogId") Long blogId,
                                  @PathVariable (value = "articleId") Long articleId
                                 ) {
        if(!blogRepository.existsById(blogId)) {
            throw new ResourceNotFoundException("BlogId " + blogId + " not found");
        }

        return articleRepository.findById(articleId);
    }

    @DeleteMapping("/blogs/{blogId}/articles/{articleId}")
    public ResponseEntity<?> deleteArticle(@PathVariable (value = "blogId") Long blogId,
                                           @PathVariable (value = "articleId") Long articleId) {
        return articleRepository.findByArticleIdAndBlogId(articleId, blogId).map(article -> {
            articleRepository.delete(article);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundException("Article not found with id " + articleId + " and blogId " + blogId));
    }


}
