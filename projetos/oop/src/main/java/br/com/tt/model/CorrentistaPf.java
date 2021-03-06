package br.com.tt.model;

public class CorrentistaPf extends Correntista {

    private String tipoDocumento;
    private String documento;

    private static final String TIPO_CONTA = "PF";

    public CorrentistaPf(String nome, Conta conta, String tipoDocumento, String documento) {

        super(nome, conta);
        this.tipoDocumento = tipoDocumento;
        this.documento = documento;

    }

    @Override
    public String getDescricao(){

        return new StringBuffer()
                .append(super.getDescricao())
                .append(" Tipo Documento: ")
                .append(this.tipoDocumento)
                .append(" Documento: ")
                .append(this.documento).toString();

    }

}
