package com.gamza.nyangflix.common.exception;


import com.gamza.nyangflix.global.Response;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.NoHandlerFoundException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Slf4j
@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(DataNotFoundException.class)
    private ResponseEntity<Response> dataNotFoundException(final DataNotFoundException e) {
        return Response.dataNotFound();
    }

    @ExceptionHandler(NoHandlerFoundException.class)
    private ResponseEntity<Response> pageNotFoundException(final NoHandlerFoundException e) {
        return Response.invalidRequest();
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Response> processValidationError(MethodArgumentNotValidException exception) {
        BindingResult bindingResult = exception.getBindingResult();
        List<HashMap<String, Object>> fieldErrorDataList = new ArrayList<>();
        for (FieldError fieldError : bindingResult.getFieldErrors()) {
            HashMap<String, Object> fieldErrorData = new HashMap<>();
            fieldErrorData.put("field", fieldError.getField());
            fieldErrorData.put("message", fieldError.getDefaultMessage());
            fieldErrorData.put("rejectedValue", fieldError.getRejectedValue());
            fieldErrorDataList.add(fieldErrorData);
        }
        return Response.invalidRequest(fieldErrorDataList);
    }

}
