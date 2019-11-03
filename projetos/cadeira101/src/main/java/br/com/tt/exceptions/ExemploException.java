package br.com.tt.exceptions;

public class ExemploException {
    public static void main(String[] args) {

        try{

            validaNumero();


        } catch (NumeroInvalidoException e){

            System.out.println("Entrou na exceção");
            //e.printStackTrace();   pode ser usado para gerar log

        } catch (IllegalArgumentException r){
        //} catch (RuntimeException r){

            System.out.println("Ocorreu um illegal".concat(r.getMessage()));

        }finally {
            System.out.println("Sempre vai entrar no finally");
        }

    }

    public static void validaNumero() throws NumeroInvalidoException {

        String numero = null; //"12";

        if( numero == null ){
            throw new IllegalArgumentException("Numero deveria ser informado!!!!!");
        }

        if(!numero.equals("12")){
            throw new NumeroInvalidoException();
        }

    }


}
