package com.dokitlist.dooyaho.domain;

import java.util.List;
import lombok.Data;

@Data
public class PagePayload<T> {

    private int totalPages;
    private int numberOfElements;
    private List<T> list;

}
