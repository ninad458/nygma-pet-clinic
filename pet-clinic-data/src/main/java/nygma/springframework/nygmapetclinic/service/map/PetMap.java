package nygma.springframework.nygmapetclinic.service.map;

import nygma.springframework.nygmapetclinic.model.Pet;
import nygma.springframework.nygmapetclinic.service.PetService;
import org.springframework.stereotype.Service;

@Service
public class PetMap extends GenericBaseEntityMap<Pet> implements PetService {
}
