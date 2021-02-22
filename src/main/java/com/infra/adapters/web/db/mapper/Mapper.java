package com.infra.adapters.web.db.mapper;

import com.infra.domain.file.BaseEntity;
import com.infra.domain.file.jpa.JpaBaseEntity;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public interface Mapper<T extends JpaBaseEntity, S extends BaseEntity> {
    public T map(S source);

    public S map(T target);

    default List<T> mapEntitiesListToJpaEntities(final Collection<S> entities) {
        return entities.stream()
                .map(this::map)
                .collect(Collectors.toList());
    }

//    default List<S> mapEntitiesListToJpa(final Collection<T> jpaEntities) {
//        return jpaEntities.stream()
//                .map(this::map)
//                .collect(Collectors.toList());
//    }

}
