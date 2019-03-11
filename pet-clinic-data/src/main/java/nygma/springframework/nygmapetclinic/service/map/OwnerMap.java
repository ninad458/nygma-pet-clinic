package nygma.springframework.nygmapetclinic.service.map;

import nygma.springframework.nygmapetclinic.model.Owner;
import nygma.springframework.nygmapetclinic.service.OwnerService;

public class OwnerMap extends GenericBaseEntityMap<Owner> implements OwnerService {

    @Override
    public Owner findOwnerByLastName(String lastName) {
        return null;
    }
}
