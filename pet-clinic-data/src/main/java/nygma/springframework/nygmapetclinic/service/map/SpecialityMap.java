package nygma.springframework.nygmapetclinic.service.map;

import nygma.springframework.nygmapetclinic.model.Speciality;
import nygma.springframework.nygmapetclinic.service.SpecialityService;
import org.springframework.stereotype.Service;

@Service
public class SpecialityMap extends GenericBaseEntityMap<Speciality> implements SpecialityService {
}
