package org.example.petmanage1.controller;

import org.example.petmanage1.entity.Admin;
import org.example.petmanage1.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admins")
public class AdminController {
    private AdminService adminService;
    @Autowired
    public void setAdminService(AdminService adminService) {
        this.adminService = adminService;
    }
    //支持分页显示admin列表请求
    //getAdminList()全部管理员信息
    @GetMapping("/{id}")
    public Admin getAdminByAdminId(@PathVariable Long adminId){
        return adminService.selectAdminById(adminId);
    }
    //addAdmin()实现添加管理员请求
    @PostMapping
    public Admin createAdmin(@RequestBody Admin admin){
        return adminService.adminSave(admin);
    }
    //editAdmin()实现编辑更新管理员信息
    @PutMapping("/{id}")
    public Admin updateAdmin(@PathVariable Long adminId, @RequestBody Admin admin){
        return adminService.adminEdit(adminId,admin);
    }
    //deleteAdmin()实现删除管理员信息
    @DeleteMapping("{id}")
    public void deleteAdmin(@PathVariable Long adminId){
        adminService.adminDelete(adminId);
    }
    //getAdminList()全部管理员信息
    @GetMapping
    public List<Admin> getAllAdmins(){
        return adminService.getAdminList();
    }
}
