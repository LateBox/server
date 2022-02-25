package com.latebox.server.foodorder;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
class FoodOrderNotFound {

    @ResponseBody
    @ExceptionHandler(FoodOrderNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String orderNotFoundHandler(FoodOrderNotFoundException ex) {
        return ex.getMessage();
    }
}
