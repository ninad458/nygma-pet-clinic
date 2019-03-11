package nygma.springframework.nygmapetclinic.service.map;

import nygma.springframework.nygmapetclinic.model.BaseEntity;

public abstract class GenericBaseEntityMap<T extends BaseEntity> extends GenericMap<T, Long> {

    @Override
    public T save(T object) {
        return save(object.getId(), object);
    }
}
