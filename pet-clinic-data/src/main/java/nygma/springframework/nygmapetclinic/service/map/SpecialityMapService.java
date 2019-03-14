package nygma.springframework.nygmapetclinic.service.map;

import nygma.springframework.nygmapetclinic.model.Speciality;
import nygma.springframework.nygmapetclinic.service.SpecialityService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile({"default", "map"})
public class SpecialityMapService extends GenericBaseEntityMap<Speciality> implements SpecialityService {
}
