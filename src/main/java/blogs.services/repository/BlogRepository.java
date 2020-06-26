package blogs.services.repository;

import blogs.services.model.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by manju on 26-06-2020.
 */
@Repository
public interface BlogRepository extends JpaRepository<Blog,Long>{

}
