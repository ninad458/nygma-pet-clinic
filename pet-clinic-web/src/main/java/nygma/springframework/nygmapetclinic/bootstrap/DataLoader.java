package nygma.springframework.nygmapetclinic.bootstrap;

import nygma.springframework.nygmapetclinic.model.Owner;
import nygma.springframework.nygmapetclinic.model.Vet;
import nygma.springframework.nygmapetclinic.service.OwnerService;
import nygma.springframework.nygmapetclinic.service.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;

    public DataLoader(OwnerService ownerService, VetService vetService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
    }

    @Override
    public void run(String... args) {
        Owner owner1 = new Owner();
        owner1.setFirstName("Podrick");
        owner1.setLastName("Slavoj");
        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Jessica");
        owner2.setLastName("Dunhum");
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
