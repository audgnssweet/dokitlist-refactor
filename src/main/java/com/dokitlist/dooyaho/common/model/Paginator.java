package com.dokitlist.dooyaho.common.model;

import com.dokitlist.dooyaho.common.exception.InvalidPagingArgumentException;
import com.dokitlist.dooyaho.common.exception.InvalidPagingPropertyException;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Paginator {

    private Class<? extends BaseTimeEntity> clazz;

    public static Paginator from(Class<? extends BaseTimeEntity> clazz) {
        return new Paginator(clazz);
    }

    public PageRequest execute(Integer page, Integer size, String property, Sort.Direction direction) {
        page = page == null ? 0 : page;
        size = size == null ? 15 : size;
        property = property == null ? "id" : property;
        direction = direction == null ? Direction.DESC : direction;

        if (page < 0 || size > 20) {
            throw new InvalidPagingArgumentException();
        }

        try {
            clazz.getDeclaredField(property);
        } catch (NoSuchFieldException e) {
            throw new InvalidPagingPropertyException();
        }

        Sort sort = Sort.by(direction, property);

        return PageRequest.of(
            page,
            size,
            sort
        );
    }

}
