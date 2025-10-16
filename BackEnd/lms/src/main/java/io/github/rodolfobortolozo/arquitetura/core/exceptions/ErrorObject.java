package io.github.rodolfobortolozo.arquitetura.core.exceptions;

public record ErrorObject(
        String field,
        String message,
        Object parameter) {

}