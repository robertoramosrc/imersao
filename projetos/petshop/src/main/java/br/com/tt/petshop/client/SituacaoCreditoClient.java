package br.com.tt.petshop.client;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

//poderia ser um service...mas como vamos abstrair
// em um nova camada (cliente), então fica como component
@Component
public class SituacaoCreditoClient {

    private final RestTemplate restTemplate;
    private final String apisCreditoUrl;
    //@Value("S{apis.credito.url}")
    //    private final String apisCreditoUrl;

    public SituacaoCreditoClient(RestTemplate restTemplate,
                                 @Value("S{apis.credito.url}") String apisCreditoUrl) {
        this.restTemplate = restTemplate;
        this.apisCreditoUrl = apisCreditoUrl;
    }

    public SituacaoCreditoDTO consultaSituacao(String cpf) {
        ResponseEntity<SituacaoCreditoDTO> response =
                restTemplate.getForEntity(
                        apisCreditoUrl,
                        SituacaoCreditoDTO.class, cpf);

        if (response.getStatusCode() == HttpStatus.OK) {
            return response.getBody();
        }
        throw new IllegalArgumentException("Erro ao acessar o serviço de crédito");

    }


}
