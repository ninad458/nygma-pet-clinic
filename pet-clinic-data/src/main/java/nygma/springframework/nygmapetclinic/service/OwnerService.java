package nygma.springframework.nygmapetclinic.service;

import nygma.springframework.nygmapetclinic.model.Owner;

import java.util.List;

public interface OwnerService extends CrudService<Owner, Long> {

    Owner findOwnerByLastName(String lastName);

    List<Owner> findAllByLastNameLike(String lastName);
}
