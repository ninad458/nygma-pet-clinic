package nygma.springframework.nygmapetclinic.service.map;

import nygma.springframework.nygmapetclinic.model.PetType;
import nygma.springframework.nygmapetclinic.service.PetTypeService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile({"default", "map"})
public class PetTypeMapService extends GenericBaseEntityMap<PetType> implements PetTypeService {
}
