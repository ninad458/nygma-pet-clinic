package nygma.springframework.nygmapetclinic.service.map;

import nygma.springframework.nygmapetclinic.service.CrudService;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public abstract class GenericMap<T, ID> implements CrudService<T, ID> {

    private final Map<ID, T> map = new HashMap<>();

    @Override
    public T findById(ID id) {
        return map.get(id);
    }

    @Override
    public Set<T> findAll() {
        return new HashSet<>(map.values());
    }

    @Override
    public void delete(T object) {
        map.entrySet().removeIf(entry -> entry.equals(object));
    }

    @Override
    public void deleteById(ID id) {

    }

    T save(ID id, T object) {
        map.put(id, object);
        return object;
    }
}
