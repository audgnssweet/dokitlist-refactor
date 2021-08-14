package com.dokitlist.dooyaho.repository;

import org.springframework.transaction.annotation.Transactional;

public interface FailRepository<E, ID> {

    @Transactional
    E findByIdElseError(ID id);

    @Transactional
    void deleteByIdElseError(ID id);

}
