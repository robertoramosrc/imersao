package br.com.tt.petshop.service;

import br.com.tt.petshop.dto.RelatorioClienteDTO;

import java.util.List;
/*
 * implementa não casando com a implementação mas com a interface
 * Estudar SOLID!!!!!!!!
 */

public interface RelatorioService {
    List<RelatorioClienteDTO> listarClientes();
}
