package br.com.tt.tela;

import br.com.tt.dao.BancoDao;
import br.com.tt.model.ObjetoBanco;
import br.com.tt.util.MasterUsuarioUtil;
import br.com.tt.util.ScannerInterface;
import br.com.tt.util.UsuarioUtil;

import java.util.List;

public abstract class TelaBanco implements Tela {

    protected BancoDao bancoDao;
    protected ScannerInterface scanner;
    protected UsuarioUtil usuarioUtil;

    public TelaBanco(BancoDao bancoDao, ScannerInterface scanner, UsuarioUtil usuarioUtil) {
        this.bancoDao = bancoDao;
        this.scanner = scanner;
        this.usuarioUtil = usuarioUtil;
    }

}
