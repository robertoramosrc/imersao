package br.com.tt.petshop.service;

import br.com.tt.petshop.exceptions.NegocioException;
import br.com.tt.petshop.model.Cliente;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ClienteService {
    private static final int QTD_MINIMA_PARTES_NOME = 2;
    private static final int TAMANHO_CPF = 11;

    private List<Cliente> clientes = new ArrayList<Cliente>();

    public List<Cliente> listar() {
        return clientes;
    }

    public void salvar(Cliente cliente) throws NegocioException {

        validaQuantidadePartesNome(cliente);
        validaTamanhoCPF(cliente);
        clientes.add(cliente);
    }

    private void validaTamanhoCPF(Cliente cliente) throws NegocioException {
        String cpfSemFormatacao = cliente
                .getCpf()
                .replaceAll("\\D","");

        if(  ( cpfSemFormatacao.length() != this.TAMANHO_CPF) ){

            throw new NegocioException("O CPF deve conter 11 números.");
        }

        return;
    }

    private void validaQuantidadePartesNome(Cliente cliente) throws NegocioException {
        int numPartesNomeDigitado = cliente
                .getNome()
                .trim()
                .split(" ")
                .length;

        if ( numPartesNomeDigitado < QTD_MINIMA_PARTES_NOME ) {

            throw new NegocioException(new StringBuffer()
                    .append("O nome da pessoa deve ser composto de no mínimo ")
                    .append(QTD_MINIMA_PARTES_NOME)
                    .append(" partes.").toString());
        }
    }
}
