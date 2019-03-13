package nygma.springframework.nygmapetclinic.repositories;

import nygma.springframework.nygmapetclinic.model.Vet;
import org.springframework.data.repository.CrudRepository;

public interface VetRepository extends CrudRepository<Vet, Long> {
}
