package br.com.tt.petshop.repository;

import br.com.tt.petshop.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    @Query("select c from Cliente c where c.nome like :nomeCliente or c.cpf like :cpfCliente ")
    List<Cliente> buscarPorNomeCPF(@Param("nomeCliente") String nome,
                                   @Param("cpfCliente") String cpf);

    @Query("select c from Cliente c where c.nome like :nomeCliente ")
    List<Cliente> buscarPorNome(@Param("nomeCliente") String nome);

    @Query("select c from Cliente c where c.cpf like :cpfCliente")
    List<Cliente> buscarPorCPF(@Param("cpfCliente") String cpf);

    List<Cliente> findByUnidadeNome(String nomeUnidade);

    List<Cliente> findByNome(String nome);

}
