package blogs.services.controller;


import blogs.services.exception.ResourceNotFoundException;
import blogs.services.model.Blog;
import blogs.services.repository.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by manju on 26-06-2020.
 * Maintains creation/deletion/updation of blog
 */
@RestController
public class BlogsServiceController {

    @Autowired
    private BlogRepository blogRepository;

    @GetMapping("/blogs")
    public Page<Blog> getAllBlogs(Pageable pageable) {
        return blogRepository.findAll(pageable);
    }

    @GetMapping("/blogs/{id}")
    public ResponseEntity< Blog > getBlogById(@PathVariable(value = "id") Long blogId)
            throws ResourceNotFoundException {
        Blog blogs = blogRepository.findById(blogId)
                .orElseThrow(() -> new ResourceNotFoundException("No blog information available :: " + blogId));
        return ResponseEntity.ok().body(blogs);
    }

    @PostMapping("/blogs")
    public Blog createBlog(@Valid @RequestBody Blog blog) {
        return blogRepository.save(blog);
    }

    @PutMapping("/blogs/{blogId}")
    public Blog updateBlog(@PathVariable Long blogId, @Valid @RequestBody Blog postRequest) {
        return blogRepository.findById(blogId).map(blog -> {
            blog.setBlogName(postRequest.getBlogName());
          //  blog.setArticlesList(postRequest.getArticlesList());
            return blogRepository.save(blog);
        }).orElseThrow(() -> new ResourceNotFoundException("BlogId " + blogId + " not found"));
    }

    @DeleteMapping("/blogs/{blogId}")
    public ResponseEntity<?> deleteBlog(@PathVariable Long blogId) {
        return blogRepository.findById(blogId).map(blog -> {
            blogRepository.delete(blog);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundException("PostId " + blogId + " not found"));
    }

}
