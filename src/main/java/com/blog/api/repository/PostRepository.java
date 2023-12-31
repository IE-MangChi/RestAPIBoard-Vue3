package com.blog.api.repository;

import com.blog.api.domain.Post;
import com.blog.api.request.PostEdit;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class PostRepository {

    private final PostMapper postMapper;

    public Long save(Post post) {
        postMapper.save(post);
        return post.getId();
    }

    public Optional<Post> findById(Long postId) {
        return postMapper.findById(postId);
    }

    public int count() {
        return postMapper.count();
    }

    public List<Post> findAll(int offset, int boardSize) {
        return postMapper.findAll(offset, boardSize);
    }

    public void edit(Long postId, PostEdit postEdit) {
        postMapper.update(postId, postEdit);
    }

    public void delete(Long postId) {
        postMapper.delete(postId);
    }

    //테스트 데이터 초기화용
    public void deleteAll() {
        postMapper.deleteAll();
    }

}
