package br.com.tt.tela;

import br.com.tt.dao.BancoDao;
import br.com.tt.model.Conta;
import br.com.tt.model.Correntista;
import br.com.tt.model.CorrentistaPf;
import br.com.tt.model.CorrentistaPj;
import br.com.tt.util.ScannerInterface;
import br.com.tt.util.UsuarioUtil;

import java.util.List;

public class TelaCorrentista implements Tela {

    private BancoDao bancoDao;
    private ScannerInterface scanner;
    private UsuarioUtil usuarioUtil;

    public TelaCorrentista(BancoDao bancoDao, ScannerInterface scanner, UsuarioUtil usuarioUtil) {
        this.bancoDao = bancoDao;
        this.scanner = scanner;
        this.usuarioUtil = usuarioUtil;
    }

    public void imprime() {
        this.exibeMenu();
    }

    @Override
    public void exibeMenu() {
        int opcao = this.usuarioUtil.exibeMensagem(new StringBuffer()
                .append("\nMenu Correntista\n")
                .append("Escolha uma opção:\n")
                .append(" 1 - Criar Correntista\n")
                .append(" 2 - Listar Correntistas\n").toString()).nextInt();

        if (opcao == 1) {
            String tipoConta =  usuarioUtil.exibeMensagem("Escolha um tipo de conta: PF / PJ").nextLine();

            if("PF".equalsIgnoreCase(tipoConta)) {

                exibeMenuCriarCorrentista(new CorrentistaPf(
                                            this.usuarioUtil.exibeMensagem("Informe um tipo de documento: ")
                                                    .nextLine(),
                                            this.usuarioUtil.exibeMensagem("Informe o número do documento: ")
                                                    .nextLine()));

            }else if("PJ".equalsIgnoreCase(tipoConta)){
                exibeMenuCriarCorrentista(new CorrentistaPj());
            }

        } else if (opcao == 2) {
            exibeMenuListaCorrentista();
        }

    }

    private void exibeMenuCriarCorrentista(Correntista correntista) {

        String nome = this.usuarioUtil.exibeMensagem("Informe o nome do correntista: ").nextLine();

        this.usuarioUtil.exibeMensagem("Escolha uma das contas abaixo para associar ao Correntista: ");

        List<Conta> contas = bancoDao.listarContas();
        for (int opcaoConta = 0; opcaoConta < contas.size(); opcaoConta++) {

            this.usuarioUtil.exibeMensagem(new StringBuffer()
                    .append(opcaoConta)
                    .append(" - ")
                    .append(contas.get(opcaoConta).getDescricao())
                    .toString());
        }

        int numero = Integer.parseInt(this.scanner.nextLine());

        if ((contas.get(numero) == null)) {
            this.usuarioUtil.exibeMensagem("Conta inválida, correntista não cadastrado");
            return;
        }

        correntista.setNome(nome);
        correntista.setConta(contas.get(numero));
        bancoDao.adicionarCorrentista(correntista);

        this.usuarioUtil.exibeMensagem("Correntista cadastrado com sucesso!");
    }

    private void exibeMenuListaCorrentista() {

        this.usuarioUtil.exibeMensagem("<<Lista de Correntistas>>");
        for (Correntista correntista : bancoDao.listarCorrentistas()) {
            this.usuarioUtil.exibeMensagem(correntista.getDescricao());
        }

    }

}
