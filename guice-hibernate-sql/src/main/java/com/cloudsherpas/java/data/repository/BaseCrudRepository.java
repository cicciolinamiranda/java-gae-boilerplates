package com.cloudsherpas.java.data.repository;

import javax.persistence.EntityManager;
import java.io.Serializable;

/**
 * Base class for Repositories that only need to implement a subset of methods from {@link CrudRepository}.
 *
 * @author RMPader
 */
public abstract class BaseCrudRepository<T, ID extends Serializable> implements CrudRepository<T, ID> {

    abstract protected EntityManager getEntityManager();


    @Override
    public <S extends T> S save(S entity) {
        throw new UnsupportedOperationException("Not implemented");
    }

    @Override
    public <S extends T> Iterable<S> save(Iterable<S> entities) {
        throw new UnsupportedOperationException("Not implemented");
    }

    @Override
    public T findOne(ID id) {
        throw new UnsupportedOperationException("Not implemented");
    }

    @Override
    public boolean exists(ID id) {
        throw new UnsupportedOperationException("Not implemented");
    }

    @Override
    public Iterable<T> findAll() {
        throw new UnsupportedOperationException("Not implemented");
    }

    @Override
    public Iterable<T> findAll(Iterable<ID> ids) {
        throw new UnsupportedOperationException("Not implemented");
    }

    @Override
    public long count() {
        throw new UnsupportedOperationException("Not implemented");
    }

    @Override
    public void delete(ID id) {
        throw new UnsupportedOperationException("Not implemented");
    }

    @Override
    public void delete(T entity) {
        throw new UnsupportedOperationException("Not implemented");
    }

    @Override
    public void delete(Iterable<? extends T> entities) {
        throw new UnsupportedOperationException("Not implemented");
    }

    @Override
    public void deleteAll() {
        throw new UnsupportedOperationException("Not implemented");
    }
}
