package org.example.petmanage1.repository;

import org.example.petmanage1.entity.Pet;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PetRepository extends JpaRepository<Pet, Long> {
    //根据宠物ID查询宠物
    Optional<Pet> findPetByPetId(Long petId);
    //根据主人ID查询宠物
    List<Pet> findPetByOwnerId(Long ownerId);
    //支持分页显示pet列表请求
    Page<Pet> findAllPet(Pageable pageable);
    //addPet()实现添加宠物请求
    //editPet()实现编辑更新宠物信息
    //deletePet()实现删除宠物信息

}
