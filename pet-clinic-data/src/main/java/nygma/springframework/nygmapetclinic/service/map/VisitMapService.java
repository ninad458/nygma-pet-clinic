package nygma.springframework.nygmapetclinic.service.map;

import nygma.springframework.nygmapetclinic.model.Visit;
import nygma.springframework.nygmapetclinic.service.VisitService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile({"default", "map"})
public class VisitMapService extends GenericBaseEntityMap<Visit> implements VisitService {

    @Override
    public Visit save(Visit object) {
        Visit visit = super.save(object);
        if (visit.getPet() == null || visit.getPet().getId() == null || visit.getPet().getOwner() == null ||
                visit.getPet().getOwner().getId() == null) {
            throw new RuntimeException("Invalid Visit");
        }
        return visit;
    }
}
