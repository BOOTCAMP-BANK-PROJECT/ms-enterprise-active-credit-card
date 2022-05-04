package com.bootcamp.enterprise.active.creditcard.util.handler.exceptions;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public abstract class BaseException extends RuntimeException {
    private String code;
    private String detail;
    private Class context_class;
    private String context;

    public BaseException(String message) {
        super(message);
    }
}
