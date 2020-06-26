package blogs.services.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.List;

/**
 * Created by manju on 26-06-2020.
 */
@Entity
@Table(name = "articles")

public class Article {

    private long articleId;
    private String articleName;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "blog_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private Blog blog;

    public Article(){

    }

    public Article(String name,Blog blog) {
        this.articleName = name;
        this.blog = blog;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public long getArticleId() {
        return articleId;
    }
    public void setArticleId(long id) {
        this.articleId = id;
    }

    @Column(name = "articleName", nullable = false)
    public String getArticleName() {
        return articleName;
    }
    public void setArticleName(String name) {
        this.articleName = name;
    }


   @ManyToOne(fetch = FetchType.LAZY, optional = false)
   @JoinColumn(name = "blog_id", nullable = false)
   @OnDelete(action = OnDeleteAction.CASCADE)
   @JsonIgnore
    public Blog getBlog() {
        return blog;
    }

    public void setBlog(Blog blog) {
        this.blog = blog;
    }

}
