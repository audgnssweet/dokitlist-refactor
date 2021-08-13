package com.dokitlist.dooyaho.repository;

import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.transaction.annotation.Transactional;

@NoRepositoryBean
public interface FailRepository<E, ID> {

    @Transactional
    E findByIdOrFail(ID id);

    @Transactional
    void deleteByIdOrFail(ID id);
}
