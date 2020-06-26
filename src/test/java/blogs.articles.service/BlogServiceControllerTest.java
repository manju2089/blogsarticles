package blogs.articles.service;

import blogs.services.controller.BlogsServiceController;
import blogs.services.model.Blog;
import blogs.services.repository.ArticleRepository;
import blogs.services.repository.BlogRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by manju on 26-06-2020.
 */
@RunWith(MockitoJUnitRunner.class)
public class BlogServiceControllerTest {
    @InjectMocks
    private BlogsServiceController blogsServiceController;

    @Mock
    private BlogRepository blogRepository;

    @Mock
    private ArticleRepository articleRepository;



    private MockMvc mock;

    @Before
    public void setUp() {
        this.mock = MockMvcBuilders.standaloneSetup(blogsServiceController).build();
    }

    @Test
    public void checkBlogCreation() throws Exception{
        this.mock.perform(MockMvcRequestBuilders.post("/blogs")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"blogName\" : \"blog1\"}"))
                .andExpect(status().isOk());

    }

    @Test
    public void deleteBlogCreation() throws Exception{
        this.mock.perform(MockMvcRequestBuilders.post("/blogs")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"id\" : \"1\",\"blogName\" : \"blog1\"}"));

        this.mock.perform(MockMvcRequestBuilders.delete("/blogs/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andReturn();
    }

}
