package nygma.springframework.nygmapetclinic.formatters;

import nygma.springframework.nygmapetclinic.model.PetType;
import nygma.springframework.nygmapetclinic.service.PetTypeService;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.util.Locale;

@Component
public class PetTypeFormatter implements Formatter<PetType> {

    private final PetTypeService petTypeService;

    public PetTypeFormatter(PetTypeService petTypeService) {
        this.petTypeService = petTypeService;
    }

    @Override
    public PetType parse(String s, Locale locale) throws ParseException {
        for (PetType type : petTypeService.findAll()) {
            if (type.getName().equals(s))
                return type;
        }
        throw new ParseException("Pet Type Doesn't Exist for " + s, 0);
    }

    @Override
    public String print(PetType petType, Locale locale) {
        return petType.getName();
    }
}
