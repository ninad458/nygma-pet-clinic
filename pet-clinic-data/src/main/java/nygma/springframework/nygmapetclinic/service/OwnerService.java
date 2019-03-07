package nygma.springframework.nygmapetclinic.service;

import nygma.springframework.nygmapetclinic.model.Owner;

import java.util.List;

public interface OwnerService {

    Owner findOwnerById(Long id);

    void saveOwner(Owner owner);

    List<Owner> findAllOwners();
}
