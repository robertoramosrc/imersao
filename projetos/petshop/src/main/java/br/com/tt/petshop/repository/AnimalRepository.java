package br.com.tt.petshop.repository;

import br.com.tt.petshop.model.Animal;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnimalRepository extends JpaRepository<Animal, Long>{
}
