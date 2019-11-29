package kg.example.service;

import kg.example.entity.Blog;

public interface BlogService{

    Blog save(Blog blog);

    Blog getBlogById(Long id);

    void delete(Long id);
}