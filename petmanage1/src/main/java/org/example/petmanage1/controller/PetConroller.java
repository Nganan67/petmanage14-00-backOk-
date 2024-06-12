package org.example.petmanage1.controller;

import org.example.petmanage1.entity.Pet;
import org.example.petmanage1.service.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pets")
public class PetConroller {
    private final PetService petService;
    @Autowired
    public PetConroller(PetService petService) {
        this.petService = petService;
    }
    @GetMapping("/{id}")
    public ResponseEntity<Pet> getPetByPetId(@PathVariable Long petId) {
        Pet pet=petService.selectPetByPetId(petId);
        return pet!=null?ResponseEntity.ok(pet):ResponseEntity.notFound().build();
    }
    @GetMapping("/owner/{ownerId}")
    public ResponseEntity<List<Pet>> getPetsByOwnerId(@PathVariable Long ownerId) {
        List<Pet> pets = petService.selectPetByOwnerId(ownerId);
        return ResponseEntity.ok(pets);
    }
    @GetMapping
    public ResponseEntity<Page<Pet>> getAllPets(Long ownerId,Pageable pageable) {
        Page<Pet> page = petService.selectPetByOwnerId(ownerId,pageable);
        return ResponseEntity.ok(page);
    }
    @PostMapping
    public ResponseEntity<Pet> petAdd(@RequestBody Pet pet) {
        Pet newPet = petService.petAdd(pet);
        return ResponseEntity.status(HttpStatus.CREATED).body(newPet);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Pet> petUpdate(@PathVariable Long petId, @RequestBody Pet pet) {
        Pet petUpdate = petService.petEdit(petId, pet);
        return petUpdate != null ? ResponseEntity.ok(petUpdate) : ResponseEntity.notFound().build();
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> petDelete(@PathVariable Long petId) {
        petService.petDelete(petId);
        return ResponseEntity.ok().build();
    }
}
