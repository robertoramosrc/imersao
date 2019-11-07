package programa;

import dao.BancoDao;
import tela.TelaConta;
import tela.TelaCorrentista;
import util.MasterUsuarioUtil;
import util.ScannerInterface;
import util.UsuarioUtil;

public class Programa {

    private static BancoDao bancoDao = new BancoDao();
    private static ScannerInterface scanner = new MasterUsuarioUtil();
    private static UsuarioUtil usuarioUtil = new MasterUsuarioUtil();

    private static TelaCorrentista telaCorrentista;
    private static TelaConta telaConta;

    public static void main(String[] args) {

        telaCorrentista = new TelaCorrentista(bancoDao, scanner, usuarioUtil);
        telaConta = new TelaConta(bancoDao, scanner, usuarioUtil);

        boolean pararPrograma;

        do {
            pararPrograma = exibeMenuPrincipal();
        } while (!pararPrograma);

    }

    public static boolean exibeMenuPrincipal() {

        usuarioUtil.exibeMensagem(new StringBuffer()
                .append("\n>> Menu Principal\n")
                .append("Escolha uma opção:\n")
                .append(" 1 - Correntista  \n")
                .append(" 2 - Conta  \n")
                .append(" 3 - Movimento \n")
                .append(" 0 - Out \n").toString());

        int opcao = Integer.parseInt(scanner.nextLine());

        if (opcao == 1) {

            telaCorrentista.exibeMenu();

        } else if (opcao == 2) {
            telaConta.exibeMenu();

        } else if (opcao == 0) {
            return true;
        }

        return false;
    }

}
