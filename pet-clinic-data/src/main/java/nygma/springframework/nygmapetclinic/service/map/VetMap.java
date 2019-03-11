package nygma.springframework.nygmapetclinic.service.map;

import nygma.springframework.nygmapetclinic.model.Vet;
import nygma.springframework.nygmapetclinic.service.VetService;
import org.springframework.stereotype.Service;

@Service
public class VetMap extends GenericBaseEntityMap<Vet> implements VetService {
}
