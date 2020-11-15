package com.puppyloper.todo;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code=HttpStatus.INTERNAL_SERVER_ERROR, reason="this is test")
public class TestException extends RuntimeException {
    static final long serialVersionUID = -3387516993124229948L;

    TestException() {
        super("test exception");
    }
}