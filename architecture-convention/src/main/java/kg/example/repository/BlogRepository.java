package kg.example.repository;

import kg.example.entity.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface BlogRepository extends JpaRepository<Blog, Long>, PagingAndSortingRepository<Blog, Long> {

}