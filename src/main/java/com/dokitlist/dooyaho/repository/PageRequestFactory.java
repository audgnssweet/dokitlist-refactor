package com.dokitlist.dooyaho.repository;

import com.dokitlist.dooyaho.domain.BaseTimeEntity;
import com.dokitlist.dooyaho.exception.InvalidPagingArgumentException;
import com.dokitlist.dooyaho.exception.InvalidPagingPropertyException;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class PageRequestFactory {

    private Class<? extends BaseTimeEntity> clazz;

    public static PageRequestFactory from(Class<? extends BaseTimeEntity> clazz) {
        return new PageRequestFactory(clazz);
    }

    public PageRequest of(Integer page, Integer size, String property, Sort.Direction direction) {
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
