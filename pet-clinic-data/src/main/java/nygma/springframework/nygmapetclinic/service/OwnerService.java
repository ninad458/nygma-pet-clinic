package nygma.springframework.nygmapetclinic.service;

import nygma.springframework.nygmapetclinic.model.Owner;

public interface OwnerService extends CrudService<Owner, Long> {

    Owner findOwnerByLastName(String lastName);
}
