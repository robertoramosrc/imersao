package br.com.tt.petshop.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Response status funciona mas continua entregando os campos so spring
 *
 * @ResponseStatus(HttpStatus.NOT_FOUND)
*/
public class RegistroNaoExisteException extends RuntimeException {

    public RegistroNaoExisteException(String message) {
        super(message);
    }
}
