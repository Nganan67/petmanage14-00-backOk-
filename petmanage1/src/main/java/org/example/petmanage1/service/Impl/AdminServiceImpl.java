package org.example.petmanage1.service.Impl;

import org.example.petmanage1.entity.Admin;
import org.example.petmanage1.repository.AdminRepository;
import org.example.petmanage1.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {
    private final AdminRepository adminRepository;
    @Autowired
    public AdminServiceImpl(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }
    //返回全部管理员列表getAdminList()
    @Override
    public List<Admin> getAdminList(){
        return adminRepository.findAll();
    }
    //通过管理员ID选择管理员selectAdminById()
    @Override
    public Admin selectAdminById(Long adminId){
        return adminRepository.findAdminByAdminId(adminId).orElse(null);
    }
    //保存管理员adminSave()
    @Override
    public Admin adminSave(Admin admin){
        return adminRepository.save(admin);
    }
    //更新管理员adminEdit()
    @Override
    public Admin adminEdit(Long adminId,Admin updatedAdmin){
        Admin admin = adminRepository.findAdminByAdminId(adminId).orElse(null);
        if(admin != null){
            //更新属性
            admin.setAdminName(updatedAdmin.getAdminName());
            admin.setAdminPassword(updatedAdmin.getAdminPassword());
            return adminRepository.save(admin);
        }
        return null;
    }
    //删除管理员adminDelete()
    @Override
    public void adminDelete(Long adminId){
        adminRepository.deleteAdminByAdminId(adminId);
    }
    //获取管理员getAdminList()
}
