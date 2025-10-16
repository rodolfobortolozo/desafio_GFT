package io.github.rodolfobortolozo.arquitetura.core.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

@RestControllerAdvice
public class Handler {

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ErrorResponse> trataErro400(Exception ex) {
        HttpStatus codigo = HttpStatus.BAD_REQUEST;
        ErrorResponse error = new ErrorResponse(ex.getMessage(), codigo.value(), codigo.toString(), ex.getClass().getSimpleName(), null);
        return ResponseEntity.status(codigo).body(error);
    }

    private ErrorResponse getErrorResponse(MethodArgumentNotValidException ex, HttpStatusCode status, List<ErrorObject> errors) {
        return new ErrorResponse("Requisição possui Campo(s) Inválido(s)", status.value(),
                status.toString(), ex.getBindingResult().getObjectName(), errors);
    }

    private List<ErrorObject> getErrors(MethodArgumentNotValidException ex) {
        return ex.getBindingResult().getFieldErrors().stream()
                .map(error -> new ErrorObject(error.getField(), error.getDefaultMessage(), error.getRejectedValue()))
                .toList();
    }

}