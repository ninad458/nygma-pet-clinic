package nygma.springframework.nygmapetclinic.repositories;

import nygma.springframework.nygmapetclinic.model.PetType;
import org.springframework.data.repository.CrudRepository;

public interface PetTypeRepository extends CrudRepository<PetType, Long> {
}
