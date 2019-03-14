package nygma.springframework.nygmapetclinic.service.map;

import nygma.springframework.nygmapetclinic.model.Owner;
import nygma.springframework.nygmapetclinic.service.OwnerService;
import nygma.springframework.nygmapetclinic.service.PetService;
import nygma.springframework.nygmapetclinic.service.PetTypeService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile({"default", "map"})
public class OwnerMapService extends GenericBaseEntityMap<Owner> implements OwnerService {

    private final PetTypeService petTypeService;
    private final PetService petService;

    public OwnerMapService(PetTypeService petTypeService, PetService petService) {
        this.petTypeService = petTypeService;
        this.petService = petService;
    }

    @Override
    public Owner save(Owner object) {
        Owner owner = super.save(object);
        if (owner.getPets() != null) {
            owner.getPets().forEach(pet -> {
                if (pet.getPetType() != null) {
                    if (pet.getId() == null) {
                        pet.setPetType(petTypeService.save(pet.getPetType()));
                    }
                } else throw new RuntimeException("Pet Type is Required");

                if (pet.getId() == null) {
                    pet.setId(petService.save(pet).getId());
                }
            });
        }
        return owner;
    }

    @Override
    public Owner findOwnerByLastName(String lastName) {
        return null;
    }
}
