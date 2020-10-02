package com.infra.adapters.mysqldb;

import com.infra.domain.file.jpa.JpaFileAttributes;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
@Lazy
public interface FileAttributesRepo extends CrudRepository<JpaFileAttributes, Integer> {


}
