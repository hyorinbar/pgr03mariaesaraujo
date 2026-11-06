
package br.com.ifba.infrastructure.dao;

import br.com.ifba.infrastructure.entity.PersistenceEntity;
import java.util.List;

public interface GenericIDao<Entity extends PersistenceEntity, ID> {

    void save(Entity entity);

    void update(Entity entity);

    void delete(Entity entity);

    Entity findById(ID id);

    List<Entity> findAll();

}

