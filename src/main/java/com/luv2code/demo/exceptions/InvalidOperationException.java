package com.luv2code.demo.exceptions;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class InvalidOperationException extends RuntimeException{

    private final String errorMsg;
    private final String operation;

}
