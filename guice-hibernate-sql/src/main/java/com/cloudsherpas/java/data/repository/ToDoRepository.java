package com.cloudsherpas.java.data.repository;

import com.cloudsherpas.java.data.domain.ToDo;
import com.google.inject.Inject;
import com.google.inject.Provider;

import javax.inject.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.Collection;
import java.util.List;

@Singleton
public class ToDoRepository extends BaseCrudRepository<ToDo, Long> {

    @Inject
    private Provider<EntityManager> entityManagerProvider;

    public Collection<ToDo> findByOwnerEmail(String email) {
        EntityManager em = getEntityManager();
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<ToDo> criteria = cb.createQuery(ToDo.class);
        Root<ToDo> root = criteria.from(ToDo.class);
        criteria.select(root);
        criteria.where(
            cb.equal(root.get("ownerEmail"), cb.literal(email))
        );
        List<ToDo> resultList = em.createQuery(criteria)
                                  .getResultList();
        return resultList;
    }

    @Override
    public <S extends ToDo> S save(S entity) {
        EntityManager em = getEntityManager();
        EntityTransaction tx = em.getTransaction();
        if (!tx.isActive()) {
            tx.begin();
            em.persist(entity);
            em.flush();
            tx.commit();
        } else {
            em.persist(entity);
            em.flush();
        }

        return entity;
    }

    @Override
    public ToDo findOne(Long id) {
        EntityManager em = getEntityManager();
        return em.find(ToDo.class, id);
    }

    @Override
    public void delete(Long id) {
        EntityManager em = getEntityManager();
        em.remove(findOne(id));
    }

    @Override
    protected EntityManager getEntityManager() {
        return entityManagerProvider.get();
    }
}
