package nygma.springframework.nygmapetclinic.bootstrap;

import nygma.springframework.nygmapetclinic.model.*;
import nygma.springframework.nygmapetclinic.service.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialityService specialityService;
    private final VisitService visitService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService,
                      SpecialityService specialityService, VisitService visitService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialityService = specialityService;
        this.visitService = visitService;
    }

    @Override
    public void run(String... args) {
        loadData();
    }

    private void loadData() {
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

        Visit catVisit = new Visit();
        catVisit.setPet(smokey);
        catVisit.setDate(LocalDate.now());
        catVisit.setDescription("Sneezy Kitty");

        visitService.save(catVisit);

        System.out.println("Loading Owners");

        Speciality radiology = new Speciality();
        radiology.setDescription("Radiology");
        Speciality savedRadiology = specialityService.save(radiology);

        Speciality surgery = new Speciality();
        surgery.setDescription("Surgery");
        Speciality savedSurgery = specialityService.save(surgery);

        Speciality dentistry = new Speciality();
        dentistry.setDescription("Dentistry");
        Speciality savedDentistry = specialityService.save(dentistry);

        Vet vet1 = new Vet();
        vet1.setFirstName("Hamliton");
        vet1.setLastName("Joseph");
        vet1.getSpecialities().add(savedRadiology);
        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Olivia");
        vet2.setLastName("Magnus");
        vet2.getSpecialities().add(savedSurgery);
        vetService.save(vet2);

        System.out.println("Loading Vets");
    }
}
