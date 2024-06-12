package org.example.petmanage1.repository;

import org.example.petmanage1.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    //根据用户名称查询用户
    User findUserByUserName(String userName);
    //根据用户ID查询用户
    Optional<User> findUserByUserId(long userId);
    //分页查询所有用户
//    Optional<User> findUserByUserId(Long userId);
    //根据用户ID删除用户
    void deleteUserByUserId(long userId);
}
