package kg.example.endpoint;

import kg.example.dto.BlogDTO;
import kg.example.entity.Blog;
import kg.example.service.BlogService;
import kg.example.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.Date;
import java.util.TimeZone;

@Service
public class BlogEndpoint {

    private final BlogService blogService;
    private final UserService userService;
    private final ModelMapper modelMapper;

    public BlogEndpoint(BlogService blogService, UserService userService, ModelMapper modelMapper) {
        this.blogService = blogService;
        this.userService = userService;
        this.modelMapper = modelMapper;
    }

    public BlogDTO createAndGetBlog(BlogDTO blogDTO) throws ParseException {
        Blog blog = convertToEntity(blogDTO);
        blog.setCreateDate(new Date());
        blog.setExpiryDate(blogDTO.getExpiryDate(TimeZone.getDefault().getDisplayName()));
        Blog createdBlog = blogService.save(blog);

        return convertToDTO(createdBlog);
    }


    public BlogDTO updateAndGetBlog(Long id, BlogDTO blogDTO) throws ParseException {
        Blog blog = convertToEntity(blogDTO);
        Blog updatedBlog = blogService.save(blog);

        return convertToDTO(updatedBlog);
    }

    public BlogDTO getBlog(Long id) {
        Blog blog = blogService.getBlogById(id);

        return convertToDTO(blog);
    }

    public void deleteBlog(Long id) {
        blogService.delete(id);
    }

    private BlogDTO convertToDTO(Blog blog) {
        BlogDTO blogDTO = modelMapper.map(blog, BlogDTO.class);
        blogDTO.setCreateDate(blog.getCreateDate(), userService.getCurrentUser().getPreference().getTimezone());
        blogDTO.setExpiryDate(blog.getExpiryDate(), userService.getCurrentUser().getPreference().getTimezone());

        return blogDTO;
    }

    private Blog convertToEntity(BlogDTO blogDTO) throws ParseException {
        Blog blog = modelMapper.map(blogDTO, Blog.class);
        blog.setExpiryDate(blogDTO.getExpiryDate(userService.getCurrentUser().getPreference().getTimezone()));

        if (blogDTO.getId() != null) {
            Blog oldBlog = blogService.getBlogById(blogDTO.getId());
            blog.setCreateDate(oldBlog.getCreateDate());
        }
        return blog;
    }
}