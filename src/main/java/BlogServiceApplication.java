
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan({ "blogs.services" })
@EnableJpaRepositories
@EntityScan("blogs.services.model")
public class BlogServiceApplication extends SpringBootServletInitializer{

    public static void main(String... args) {
        SpringApplication.run(BlogServiceApplication.class, args);
    }

   /* @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/").permitAll()
                .antMatchers("/admin").access("hasRole('ADMIN')")
                .and().formLogin();
        http.csrf().disable();
    }
*/

}
