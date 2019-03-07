package nygma.springframework.nygmapetclinic.service;

import nygma.springframework.nygmapetclinic.model.Vet;

import java.util.List;

public interface VetService {

    Vet findVetById(Long id);

    void saveVet(Vet pet);

    List<Vet> findAllVets();
}
