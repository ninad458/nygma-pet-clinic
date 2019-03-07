package nygma.springframework.nygmapetclinic.service;

import nygma.springframework.nygmapetclinic.model.Pet;

import java.util.List;

public interface PetService {

    Pet findPetById(Long id);

    void savePet(Pet pet);

    List<Pet> findAllPets();
}
