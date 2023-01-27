package com.ssafy.antenna.service;

import com.ssafy.antenna.domain.post.Post;
import com.ssafy.antenna.domain.post.dto.PostPostReq;
import com.ssafy.antenna.repository.PostRepository;
import com.ssafy.antenna.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PostService {
    private final PostRepository postRepository;
    private final UserRepository userRepository;

    public String createPost(Long userId, PostPostReq postPostReq){
        Post post = postRepository.save(Post.builder()
                .title(postPostReq.title())
                .content(postPostReq.content())
                .isPublic(postPostReq.isPublic())
                .user(userRepository.findById(userId).get())
                .build()
        );
        int result = postRepository.setPoint(post.getPostId(), String.format("POINT(%f %f)", postPostReq.lng(), postPostReq.lat()));
        return "success";
    }
}
