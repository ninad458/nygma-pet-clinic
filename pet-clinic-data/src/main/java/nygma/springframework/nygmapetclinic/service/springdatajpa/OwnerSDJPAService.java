package nygma.springframework.nygmapetclinic.service.springdatajpa;

import nygma.springframework.nygmapetclinic.model.Owner;
import nygma.springframework.nygmapetclinic.repositories.OwnerRepository;
import nygma.springframework.nygmapetclinic.service.OwnerService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@Profile("springdatajpa")
public class OwnerSDJPAService implements OwnerService {

    private final OwnerRepository ownerRepository;

    public OwnerSDJPAService(OwnerRepository ownerRepository) {
        this.ownerRepository = ownerRepository;
    }

    @Override
    public Owner findOwnerByLastName(String lastName) {
        return ownerRepository.findByLastName(lastName).orElse(null);
    }

    @Override
    public List<Owner> findAllByLastNameLike(String lastName) {
        return ownerRepository.findAllByLastNameLike(lastName);
    }

    @Override
    public Owner findById(Long aLong) {
        return ownerRepository.findById(aLong).orElse(null);
    }

    @Override
    public Owner save(Owner object) {
        return ownerRepository.save(object);
    }

    @Override
    public Set<Owner> findAll() {
        Set<Owner> owners = new HashSet<>();
        ownerRepository.findAll().forEach(owners::add);
        return owners;
    }

    @Override
    public void delete(Owner object) {
        ownerRepository.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        ownerRepository.deleteById(aLong);
    }
}
