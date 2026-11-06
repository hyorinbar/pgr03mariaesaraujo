
package br.com.ifba.infrastructure.dao;

import java.util.List;

public interface GenericIDao<Entity, ID> {

    void save(Entity entity);

    void update(Entity entity);

    void delete(Entity entity);

    Entity findById(ID id);

    List<Entity> findAll();

}

