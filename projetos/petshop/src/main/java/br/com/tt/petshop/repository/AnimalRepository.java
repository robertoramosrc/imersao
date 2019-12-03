package br.com.tt.petshop.repository;

import br.com.tt.petshop.model.Animal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.persistence.SqlResultSetMapping;
import java.util.List;

@Repository
public interface AnimalRepository extends JpaRepository<Animal, Long>{

    //preferencialmente usar JPQL
    @Query("select a from Animal a where a.nome = :nomeAnimal")
    List<Animal> buscarPorNome(@Param("nomeAnimal") String nome);

}
