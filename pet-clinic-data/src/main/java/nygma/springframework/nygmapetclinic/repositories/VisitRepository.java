package nygma.springframework.nygmapetclinic.repositories;

import nygma.springframework.nygmapetclinic.model.Visit;
import org.springframework.data.repository.CrudRepository;

public interface VisitRepository extends CrudRepository<Visit, Long> {
}
