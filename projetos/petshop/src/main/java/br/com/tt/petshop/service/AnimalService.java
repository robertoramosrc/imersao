package br.com.tt.petshop.service;

import br.com.tt.petshop.dto.AnimalInDTO;
import br.com.tt.petshop.exceptions.NegocioException;
import br.com.tt.petshop.exceptions.RegistroNaoExisteException;
import br.com.tt.petshop.model.Animal;
import br.com.tt.petshop.model.Cliente;
import br.com.tt.petshop.model.Unidade;
import br.com.tt.petshop.model.projection.AnimalProjection;
import br.com.tt.petshop.repository.AnimalRepository;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;
import org.modelmapper.ModelMapper;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class AnimalService {

    private final ModelMapper mapper;
    private final UnidadeService unidadeService;
    private final ClienteService clienteService;
    private final AnimalRepository animalRepository;

    //temporário, até criar o repository
    //List<Animal> animais = new ArrayList<Animal>();


    public AnimalService(ModelMapper mapper, UnidadeService unidadeService, ClienteService clienteService, AnimalRepository animalRepository) {
        this.mapper = mapper;
        this.unidadeService = unidadeService;
        this.clienteService = clienteService;
        this.animalRepository = animalRepository;
    }

    public Animal salvar(AnimalInDTO animalInDTO) throws NegocioException {

        Animal animal = this.mapper.map(animalInDTO, Animal.class);

        animal.setCliente(buscarClientePorId(animalInDTO.getCliente()));
        animal.setUnidade(buscarUnidadePorId(animalInDTO.getUnidade()));

        validarDataDeNascimento(animal);
        this.animalRepository.save(animal);

        return animal;

    }

    private Cliente buscarClientePorId(Long IdCliente) {
        return this.clienteService.buscarPorId(IdCliente);
    }

    private Unidade buscarUnidadePorId(Long IdUnidade) {
        return this.unidadeService.buscarPorId(IdUnidade);
    }

    public List<Animal> listar(Optional<String> nome,
                               Optional<Long> idUnidade,
                               Optional<Long> idCliente,
                               Optional<String> nomeLike) {


        if (nomeLike.isPresent()) {
            return this.animalRepository.buscarPorNome(nomeLike.get());
        }

        Animal animal = new Animal();
        nome.ifPresent(s -> animal.setNome(s));  //com lambda

        if (idUnidade.isPresent()) {            //sem lambda
            Unidade unidade = new Unidade();
            unidade.setId(idUnidade.get());
            animal.setUnidade(unidade);
        }

        if (idCliente.isPresent()) {    //sem lambda
            Cliente cliente = new Cliente();
            cliente.setId(idCliente.get());
            animal.setCliente(cliente);
        }

        return animalRepository.findAll(Example.of(animal));

    }

    public Animal buscarPorId(Long id) {
        return this.animalRepository.findById(id)
                .orElseThrow(() -> new RegistroNaoExisteException("Animal não encontrado"));
    }

    public void excluir(Long id) {
        this.buscarPorId(id);
        this.animalRepository.deleteById(id);
    }

    private void validarDataDeNascimento(Animal animal) throws NegocioException {

        if (animal.getDataNascimento().isAfter(LocalDate.now())) {
            throw new NegocioException("A data de nascimento do animal não pode ser maior que hoje");
        }

    }

    public List<AnimalProjection> listarParaRelatorio() {
        return this.animalRepository.findAllOrderByNome();
    }

}
