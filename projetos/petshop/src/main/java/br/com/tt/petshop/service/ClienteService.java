package br.com.tt.petshop.service;

import br.com.tt.petshop.exceptions.NegocioException;
import br.com.tt.petshop.exceptions.RegistroNaoExisteException;
import br.com.tt.petshop.model.Cliente;
import br.com.tt.petshop.model.Unidade;
import br.com.tt.petshop.repository.ClienteRepository;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;
import java.util.List;

@Service
@Validated //para usar o @notnull
public class ClienteService {
    private static final int QTD_MINIMA_PARTES_NOME = 2;
    private static final int QTD_MINIMA_LETRAS_PRIMEIRO_NOME = 2;
    private static final int TAMANHO_CPF = 11;

    private final ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public List<Cliente> listar() {
        return clienteRepository.findAll();
    }

    public Cliente buscarPorId(@NotNull(message = "ID do cliente obrigatório")
                                       Long id){
        return this.clienteRepository.findById(id)
                .orElseThrow(()-> new RegistroNaoExisteException("Cliente não existe"));

    }

    public void salvar(Cliente cliente) throws NegocioException {

        validaQuantidadePartesNome(cliente);
        validaQuantidadeLetrasDaParteNome(cliente);
        validaTamanhoCPF(cliente);
        clienteRepository.save(cliente);
    }

    private void validaQuantidadeLetrasDaParteNome(Cliente cliente) throws NegocioException {
        int numCarateresValidos = 0;

        if( cliente.getNome() == null ){
            throw new NegocioException("Nome não informado!");
        }

        String primeiroNome = cliente
                .getNome()
                .trim()
                .split(" ")[0];

        for( int posicao = 0; posicao < primeiroNome.length(); posicao++){

            char c =  primeiroNome.charAt(posicao);

            if( (c >= 'A' && c<= 'Z') || ( c >= 'a' && c<= 'z') ) {

                numCarateresValidos ++;
            }
        }

        if(numCarateresValidos < this.QTD_MINIMA_LETRAS_PRIMEIRO_NOME ){
            throw new NegocioException(new StringBuffer()
                        .append("O primeiro nome deve ter no mínimo ")
                        .append(this.QTD_MINIMA_LETRAS_PRIMEIRO_NOME)
                        .append(" letras.").toString()) ;
        }

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
