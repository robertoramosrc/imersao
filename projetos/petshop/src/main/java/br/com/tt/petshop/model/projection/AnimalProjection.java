package br.com.tt.petshop.model.projection;

import java.time.LocalDate;

public interface AnimalProjection {
    String getNome();
    LocalDate getDataNascimento();
}
