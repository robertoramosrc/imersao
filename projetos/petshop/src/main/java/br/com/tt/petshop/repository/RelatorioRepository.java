package br.com.tt.petshop.repository;

import br.com.tt.petshop.dto.RelatorioClienteDTO;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public class RelatorioRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public List<RelatorioClienteDTO> listarClientes() {
        Query query = entityManager.createQuery("Select" +
                " new br.com.tt.petshop.dto.RelatorioClienteDTO( c.nome, c.cpf, c.unidade.id, c.unidade.nome ) " +
                "from Cliente c");

        return query.getResultList();
    }
}
