package org.example.petmanage1.service;

import org.example.petmanage1.entity.Admin;

import java.util.List;

public interface AdminService {
    List<Admin> getAdminList();
    Admin selectAdminById(Long adminId);
    Admin adminSave(Admin admin);
    Admin adminEdit(Long adminId,Admin updatedAdmin);
    void adminDelete(Long adminId);
}
