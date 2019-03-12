package nygma.springframework.nygmapetclinic.bootstrap;

import nygma.springframework.nygmapetclinic.model.Owner;
import nygma.springframework.nygmapetclinic.model.Pet;
import nygma.springframework.nygmapetclinic.model.PetType;
import nygma.springframework.nygmapetclinic.model.Vet;
import nygma.springframework.nygmapetclinic.service.OwnerService;
import nygma.springframework.nygmapetclinic.service.PetTypeService;
import nygma.springframework.nygmapetclinic.service.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
    }

    @Override
    public void run(String... args) {
        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDog = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("Cat");
        PetType savedCat = petTypeService.save(cat);

        Owner owner1 = new Owner();
        owner1.setFirstName("Podrick");
        owner1.setLastName("Slavoj");
        owner1.setAddress("221B Baker Street");
        owner1.setCity("London");
        owner1.setTelephone("1122223333");

        Pet rosco = new Pet();
        rosco.setPetType(savedDog);
        rosco.setBirthDate(LocalDate.now());
        rosco.setName("Rosco");
        rosco.setOwner(owner1);
        owner1.getPets().add(rosco);

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Jessica");
        owner2.setLastName("Dunhum");
        owner2.setAddress("221B Baker Street");
        owner2.setCity("London");
        owner2.setTelephone("1122223333");

        Pet smokey = new Pet();
        smokey.setPetType(savedCat);
        smokey.setName("Smokey");
        smokey.setBirthDate(LocalDate.now());
        smokey.setOwner(owner2);
        owner2.getPets().add(smokey);

        ownerService.save(owner2);

        System.out.println("Loading Owners");

        Vet vet1 = new Vet();
        vet1.setFirstName("Hamliton");
        vet1.setLastName("Joseph");
        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Olivia");
        vet2.setLastName("Magnus");
        vetService.save(vet2);

        System.out.println("Loading Vets");
    }
}
