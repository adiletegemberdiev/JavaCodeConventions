package kg.example.controller;

import kg.example.dto.BlogDTO;
import kg.example.endpoint.BlogEndpoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("rest-blog")
public class BlogRestController {

    private final BlogEndpoint blogEndpoint;

    @Autowired
    public BlogRestController(BlogEndpoint blogEndpoint) {
        this.blogEndpoint = blogEndpoint;
    }

    @GetMapping("/")
    public ResponseEntity<List<BlogDTO>> index() {
        List<BlogDTO> blogDTOS = new ArrayList<>();
        return new ResponseEntity<>(blogDTOS, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<BlogDTO> createBlog(@RequestBody BlogDTO blogDTO) {

        BlogDTO createdBlogDTO = null;
        try {
            createdBlogDTO = blogEndpoint.createAndGetBlog(blogDTO);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(createdBlogDTO, HttpStatus.OK);
    }

    @PutMapping("/{id}/update")
    public ResponseEntity<BlogDTO> updateBlog(@PathVariable("id") final Long id, @RequestBody BlogDTO blogDTO) {
        BlogDTO updatedBlogDTO = null;
        try {
            updatedBlogDTO = blogEndpoint.updateAndGetBlog(id, blogDTO);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return new ResponseEntity<>(updatedBlogDTO, HttpStatus.OK);
    }

    @GetMapping("/{id}/get")
    public ResponseEntity<BlogDTO> getBlog(@PathVariable("id") final Long id) {
        BlogDTO blogDTO = blogEndpoint.getBlog(id);
        return new ResponseEntity<>(blogDTO, HttpStatus.OK);
    }

    @DeleteMapping("/{id}/delete")
    public ResponseEntity<String> deleteBlog(@PathVariable("id") final Long id) {
        blogEndpoint.deleteBlog(id);
        return new ResponseEntity<>("deleted", HttpStatus.OK);
    }
}