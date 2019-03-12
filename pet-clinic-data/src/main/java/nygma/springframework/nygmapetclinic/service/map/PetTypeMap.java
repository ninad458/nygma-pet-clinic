package nygma.springframework.nygmapetclinic.service.map;

import nygma.springframework.nygmapetclinic.model.PetType;
import nygma.springframework.nygmapetclinic.service.PetTypeService;
import org.springframework.stereotype.Service;

@Service
public class PetTypeMap extends GenericBaseEntityMap<PetType> implements PetTypeService {
}
