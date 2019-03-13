package nygma.springframework.nygmapetclinic.repositories;

import nygma.springframework.nygmapetclinic.model.Owner;
import org.springframework.data.repository.CrudRepository;

public interface OwnerRepository extends CrudRepository<Owner, Long> {
}
