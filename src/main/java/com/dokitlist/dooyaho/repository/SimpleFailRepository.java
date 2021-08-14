package com.dokitlist.dooyaho.repository;

import com.dokitlist.dooyaho.exception.EntityNotFoundException;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import lombok.RequiredArgsConstructor;
import org.springframework.data.repository.NoRepositoryBean;

@RequiredArgsConstructor
@NoRepositoryBean
public abstract class SimpleFailRepository<E, ID> implements FailRepository<E, ID> {

    @PersistenceContext
    private EntityManager em;

    private final Class<E> clazz;

    @Override
    public E findByIdElseError(ID id) {
        final E e = em.find(clazz, id);
        if (e == null) {
            throw new EntityNotFoundException();
        }
        return e;
    }

    @Override
    public void deleteByIdElseError(ID id) {
        final E e = findByIdElseError(id);
        em.remove(e);
    }
}
