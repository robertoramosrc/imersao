package br.com.tt.petshop.controller;

import br.com.tt.petshop.exceptions.NegocioException;
import br.com.tt.petshop.model.Unidade;
import br.com.tt.petshop.service.UnidadeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping
public class UnidadeController {
    private final UnidadeService unidadeService;

    public UnidadeController(UnidadeService unidadeService) {
        this.unidadeService = unidadeService;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/admin/unidades")
    public String listar(Model model) {

        model.addAttribute("mensagem", "Bem vindo a lista de Unidades da petshop");
        model.addAttribute("unidades", unidadeService.listar());

        return "unidade/unidades";

    }

    @RequestMapping(method = RequestMethod.GET, value = "/admin/unidades/criar")
    public String criar(Model model) {

        model.addAttribute("novaUnidade", new Unidade());
        return "unidade/unidade_criar";

    }

    @RequestMapping(method = RequestMethod.POST, value = "/admin/unidades/criarNovo")
    public String criarNova(Unidade unidade, Model model) {

        try {

            unidadeService.salvar(unidade);
            model.addAttribute("mensagem", "Unidade salva com sucesso");

        } catch (NegocioException e) {
            model.addAttribute("mensagem",
                    "Erro: ".concat(e.getMessage()));
        }

        return this.listar(model);

    }

}
