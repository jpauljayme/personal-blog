package dev.mayhm.blog.service;

import dev.mayhm.blog.mapper.PostMapper;
import dev.mayhm.blog.model.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class BlogService {

    private final PostMapper postMapper;

    @Autowired
    public BlogService(PostMapper postMapper) {
        this.postMapper = postMapper;
    }

    public List<Post> getAllPosts() {
        return postMapper.getAllPosts();
    }

    public void createPost(Post post){
        post.setDateCreated(LocalDate.now());
        post.setDateUpdated(LocalDate.now());
        post.setAuthor("John Paul Jayme");
        postMapper.insertPost(post);
    }

    public Optional<Post> getPostById(int id) {
        return postMapper.getPostById(id);
    }
}
