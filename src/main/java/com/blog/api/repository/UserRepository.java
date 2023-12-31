package com.blog.api.repository;

import com.blog.api.domain.Users;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class UserRepository {

    private final UserMapper userMapper;

    public Optional<Users> findById(Long userId) {
        return userMapper.findById(userId);
    }

    public Optional<Users> findByEmailAndPassword(String email, String password) {
        return userMapper.findByEmailAndPassword(email, password);
    }

    public Optional<Users> findByEmail(String email) {
        return userMapper.findByEmail(email);
    }

    public void save(Users users) {
        userMapper.saveUser(users);
    }


    // 테스트데이터 초기화용
    public void deleteAll() {
        userMapper.deleteAll();
    }
}
