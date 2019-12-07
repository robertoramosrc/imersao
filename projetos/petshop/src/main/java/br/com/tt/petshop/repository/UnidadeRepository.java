package br.com.tt.petshop.repository;

import br.com.tt.petshop.model.Unidade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UnidadeRepository extends JpaRepository<Unidade, Long> {

    List<Unidade> findByNome(String nome);

}
