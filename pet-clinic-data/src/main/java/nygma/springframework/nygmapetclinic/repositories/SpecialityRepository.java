package nygma.springframework.nygmapetclinic.repositories;

import nygma.springframework.nygmapetclinic.model.Speciality;
import org.springframework.data.repository.CrudRepository;

public interface SpecialityRepository extends CrudRepository<Speciality, Long> {
}
