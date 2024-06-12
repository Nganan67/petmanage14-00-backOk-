package org.example.petmanage1.service.Impl;

import org.example.petmanage1.entity.Admin;
import org.example.petmanage1.entity.Pet;
import org.example.petmanage1.repository.PetRepository;
import org.example.petmanage1.service.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PetServiceImpl implements PetService {
    private final PetRepository petRepository;
    @Autowired
    public PetServiceImpl(PetRepository petRepository) {
        this.petRepository = petRepository;
    }
    @Override
    public List<Pet> selectPetByOwnerId(Long ownerId) {
        return petRepository.findPetByOwnerId(ownerId);
    }
    @Override
    public Pet selectPetByPetId(Long petId){
        return petRepository.findPetByPetId(petId).orElse(null);
    }
    @Override
    public Page<Pet> selectPetByOwnerId(Long ownerId,Pageable pageable) {
        return petRepository.findAllPet(pageable);
    }
    @Override
    public Pet petAdd(Pet pet){
        return petRepository.save(pet);
    }
    @Override
    public Pet petEdit(Long petId,Pet updatePet){
        Pet pet = petRepository.findPetByPetId(petId).orElse(null);
        if(pet != null){
            pet.setPetName(updatePet.getPetName());
            pet.setPetGender(updatePet.getPetGender());
            pet.setPetAge(updatePet.getPetAge());
            pet.setOwner(updatePet.getOwner());
            return petRepository.save(pet);
        }
        return null;
    }
    @Override
    public void petDelete(Long petId){
        petRepository.deleteById(petId);
    }
}