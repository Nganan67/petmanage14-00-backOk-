package org.example.petmanage1.repository;

import org.example.petmanage1.entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Long> {
    //根据管理员名称查询管理员
    Admin findAdminByAdminName(String adminName);
    //根据管理员ID查询管理员
    Optional<Admin> findAdminByAdminId(long adminId);
    //根据管理员ID删除管理员
    void deleteAdminByAdminId(long adminId);
}
