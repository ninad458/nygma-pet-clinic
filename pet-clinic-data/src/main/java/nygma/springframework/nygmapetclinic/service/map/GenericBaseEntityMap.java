package nygma.springframework.nygmapetclinic.service.map;

import nygma.springframework.nygmapetclinic.model.BaseEntity;

import java.util.Collections;

public abstract class GenericBaseEntityMap<T extends BaseEntity> extends GenericMap<T, Long> {

    @Override
    public T save(T object) {
        if (object != null) {
            if (object.getId() == null) {
                Long id = generateId();
                object.setId(id);
                return save(object.getId(), object);
            } else return object;
        } else throw new RuntimeException("object cannot be null");
    }

    private Long generateId() {
        if (getKeys().isEmpty()) return 1L;
        return Collections.max(getKeys()) + 1;
    }
}
