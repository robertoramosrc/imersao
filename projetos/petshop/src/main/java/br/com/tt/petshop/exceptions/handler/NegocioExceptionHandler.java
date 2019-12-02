package br.com.tt.petshop.exceptions.handler;

import br.com.tt.petshop.exceptions.NegocioException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class NegocioExceptionHandler {

    @ExceptionHandler(NegocioException.class)
    public ResponseEntity<ApiError> handle(NegocioException e){
        ApiError apiError = new ApiError("Vc não é uma exceção à regra...", e.getMessage());

        return ResponseEntity.badRequest().body(apiError);
    }

}
