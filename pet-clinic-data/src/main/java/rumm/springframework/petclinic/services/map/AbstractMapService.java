package rumm.springframework.petclinic.services.map;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

import rumm.springframework.petclinic.model.BaseEntity;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

public abstract class AbstractMapService<T extends BaseEntity, ID extends Long> {

    protected Map<Long, T> map = new HashMap<>();

    Set<T> findAll() {
        return new HashSet<>(map.values());
    }

    T findById(ID id) {
        return map.get(id);
    }

    T save(T object) {

        assert nonNull(object);

        if (isNull(object.getId())) {
            object.setId(getNextId());
        }
        map.put(object.getId(), object);

        return object;
    }

    void deletById(ID id) {
        map.remove(id);
    }

    void delete(T object) {
        map.entrySet().removeIf(idtEntry -> idtEntry.getValue().equals(object));
    }

    private Long getNextId() {
        try {
            return Collections.max(map.keySet()) + 1;
        } catch (NoSuchElementException e) {
            return 1L;
        }
    }

}
