package br.com.tt.tela;

import br.com.tt.dao.BancoDao;
import br.com.tt.model.Conta;
import br.com.tt.model.Correntista;
import br.com.tt.model.ObjetoBanco;
import br.com.tt.model.TipoMovimento;
import br.com.tt.util.ScannerInterface;
import br.com.tt.util.UsuarioUtil;

import java.util.Arrays;
import java.util.List;

public class TelaMovimento extends TelaBanco {

    public TelaMovimento(BancoDao bancoDao, ScannerInterface scanner, UsuarioUtil usuarioUtil) {
        super(bancoDao, scanner, usuarioUtil);
    }

    @Override
    public void exibeMenu() {
        int opcao;

        if( bancoDao.listarContas().isEmpty()){
            this.usuarioUtil.exibeMensagem("Não há contas cadastradas.");
            return;
        }

        opcao = this.usuarioUtil.exibeMensagem(new StringBuffer()
                .append("\nMenu Movimento\n")
                .append("Escolha uma opção:\n")
                .append(" 1 - Incluir Movimento\n")
                .append(" 2 - Listar Movimentos\n")
                .append(" 0 - Voltar ao menu principal\n").toString()).nextInt() ;


        if(opcao == 0){
            return;

        }else if(opcao == 1){

            this.usuarioUtil.exibeMensagem("Escolha a Conta: ");

            List<Conta> contas = bancoDao.listarContas();

            for (int opcaoConta = 0; opcaoConta < contas.size(); opcaoConta++) {

                this.usuarioUtil.exibeMensagem(new StringBuffer()
                        .append(opcaoConta)
                        .append(" - ")
                        .append(contas.get(opcaoConta).getDescricao())
                        .toString());
            }

            Conta conta = bancoDao.listarContas().get(this.usuarioUtil.nextInt());

            this.usuarioUtil.exibeMensagem( "Escolha um tipo de movimento:\n");

            for(TipoMovimento tiposMovimento : Arrays.asList(TipoMovimento.values()) ){
                this.usuarioUtil.exibeMensagem(tiposMovimento.toString());
            }

            String tipoMovimento = this.usuarioUtil.nextLine();


            this.usuarioUtil.exibeMensagem( "Escolha uma conta:\n");
            this.usuarioUtil.exibeMensagem( "Informe o valor:\n");

        }



    }


}
