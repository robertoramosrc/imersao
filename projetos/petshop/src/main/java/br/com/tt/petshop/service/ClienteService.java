package br.com.tt.petshop.service;

import br.com.tt.petshop.client.SituacaoCredito;
import br.com.tt.petshop.client.SituacaoCreditoClient;
import br.com.tt.petshop.client.SituacaoCreditoDTO;
import br.com.tt.petshop.exceptions.NegocioException;
import br.com.tt.petshop.exceptions.RegistroNaoExisteException;
import br.com.tt.petshop.model.Cliente;
import br.com.tt.petshop.repository.ClienteRepository;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Optional;

@Service
@Validated //para usar o @notnull
public class ClienteService {
    private static final int QTD_MINIMA_PARTES_NOME = 2;
    private static final int QTD_MINIMA_LETRAS_PRIMEIRO_NOME = 2;
    private static final int TAMANHO_CPF = 11;

    private final ClienteRepository clienteRepository;
    private final SituacaoCreditoClient situacaoCreditoClient;

    public ClienteService(ClienteRepository clienteRepository, SituacaoCreditoClient situacaoCreditoClient) {
        this.clienteRepository = clienteRepository;
        this.situacaoCreditoClient = situacaoCreditoClient;
    }

    public List<Cliente> listar(Optional<String> nome, Optional<String> cpf) {

        if (nome.isPresent() && cpf.isPresent()) {
            return this.clienteRepository.buscarPorNomeCPF(nome.get(), cpf.get());
        } else if (nome.isPresent()) {
            return this.clienteRepository.buscarPorNome(nome.get());
        } else if (cpf.isPresent()) {
            return this.clienteRepository.buscarPorCPF(cpf.get());
        }

        return clienteRepository.findAll();

    }

    public Cliente buscarPorId(@NotNull(message = "ID do cliente obrigatório")
                                       Long id) {
        return this.clienteRepository.findById(id)
                .orElseThrow(() -> new RegistroNaoExisteException("Cliente não existe"));

    }

    public Cliente salvar(Cliente cliente) throws NegocioException {

        validaQuantidadePartesNome(cliente);
        validaQuantidadeLetrasDaParteNome(cliente);
        validaTamanhoCPF(cliente);
        validaSituacaoCredito(cliente.getCpf());
        return clienteRepository.save(cliente);
    }

    private void validaSituacaoCredito(String cpf) throws NegocioException {

        SituacaoCreditoDTO situacaoCreditoDTO =
                this.situacaoCreditoClient.consultaSituacao(cpf);

        if( situacaoCreditoDTO.isRegular() ){

            throw new NegocioException(new StringBuffer()
                    .append("O Cliente não pode ser cadastrado.")
                    .append("Verifique sua situação.")
                    .toString());
        }

    }

    private void validaQuantidadeLetrasDaParteNome(Cliente cliente) throws NegocioException {
        int numCarateresValidos = 0;

        if (cliente.getNome() == null) {
            throw new NegocioException("Nome não informado!");
        }

        String primeiroNome = cliente
                .getNome()
                .trim()
                .split(" ")[0];

        for (int posicao = 0; posicao < primeiroNome.length(); posicao++) {

            char c = primeiroNome.charAt(posicao);

            if ((c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z')) {

                numCarateresValidos++;
            }
        }

        if (numCarateresValidos < this.QTD_MINIMA_LETRAS_PRIMEIRO_NOME) {
            throw new NegocioException(new StringBuffer()
                    .append("O primeiro nome deve ter no mínimo ")
                    .append(this.QTD_MINIMA_LETRAS_PRIMEIRO_NOME)
                    .append(" letras.").toString());
        }

    }

    private void validaTamanhoCPF(Cliente cliente) throws NegocioException {
        String cpfSemFormatacao = cliente
                .getCpf()
                .replaceAll("\\D", "");

        if ((cpfSemFormatacao.length() != this.TAMANHO_CPF)) {

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

        if (numPartesNomeDigitado < QTD_MINIMA_PARTES_NOME) {

            throw new NegocioException(new StringBuffer()
                    .append("O nome da pessoa deve ser composto de no mínimo ")
                    .append(QTD_MINIMA_PARTES_NOME)
                    .append(" partes.").toString());
        }
    }
}
