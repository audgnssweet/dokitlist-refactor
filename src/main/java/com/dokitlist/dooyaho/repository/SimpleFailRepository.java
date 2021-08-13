package com.dokitlist.dooyaho.repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.PersistenceContext;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public class SimpleFailRepository<E, ID> implements FailRepository<E, ID> {

    @PersistenceContext
    private EntityManager em;

    Class<E> clazz;

    @Override
    public E findByIdOrFail(ID id) {
        final E e = em.find(clazz, id);
        if (e == null) {
            throw new EntityNotFoundException();
        }
        return e;
    }

    @Override
    public void deleteByIdOrFail(ID id) {
        final E e = findByIdOrFail(id);
        em.remove(e);
    }
}
