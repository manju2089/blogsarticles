package blogs.services.model;

import javax.persistence.*;
import java.util.List;

/**
 * Created by manju on 26-06-2020.
 */
@Entity
@Table(name = "blogs")

public class Blog {


    private long id;

    @Column(name = "blogName", nullable = false)
    private String blogName;


   // private List<Article> articlesList;

    public Blog(){

    }

    public Blog(String name) {
        this.blogName = name;
     //   this.articlesList = articlesList;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public long getId(){
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }

    public String getBlogName() {
        return blogName;
    }
    public void setBlogName(String name) {
        this.blogName = name;
    }
    /*@OneToMany(cascade = CascadeType.ALL, targetEntity=Article.class, mappedBy="blog", fetch=FetchType.LAZY)

    public List<Article> getArticlesList() {
        return articlesList;
    }

    public void setArticlesList(List<Article> articlesList) {
        this.articlesList = articlesList;
    }*/

}
