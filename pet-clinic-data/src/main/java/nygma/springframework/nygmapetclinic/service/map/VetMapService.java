package nygma.springframework.nygmapetclinic.service.map;

import nygma.springframework.nygmapetclinic.model.Vet;
import nygma.springframework.nygmapetclinic.service.SpecialityService;
import nygma.springframework.nygmapetclinic.service.VetService;
import org.springframework.stereotype.Service;

@Service
public class VetMapService extends GenericBaseEntityMap<Vet> implements VetService {

    private final SpecialityService specialityService;

    public VetMapService(SpecialityService specialityService) {
        this.specialityService = specialityService;
    }

    @Override
    public Vet save(Vet object) {
        Vet vet = super.save(object);
        vet.getSpecialities().forEach(speciality -> {
            if (speciality.getDescription() != null) {
                if (speciality.getId() == null) {
                    speciality.setId(specialityService.save(speciality).getId());
                }
            } else throw new RuntimeException("Specialities Description Cannot be null");
        });
        return vet;
    }
}
