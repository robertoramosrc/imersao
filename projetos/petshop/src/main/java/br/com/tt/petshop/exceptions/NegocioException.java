package br.com.tt.petshop.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

//@ResponseStatus(HttpStatus.BAD_REQUEST)   comentei porque criei o handle
public class NegocioException extends RuntimeException {
    public NegocioException(String message) {
        super(message);
    }
}
