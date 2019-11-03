package br.com.tt.exemplos;

public class ExercicioWrapper {

    public static void main(String[] args) {

        //converterCaracterParaMinusculo('K');
        //converterMensagemParaEnvioTwitter("2 - Crie uma função que trunca o texto informado nos primeiros 140 caracteres. Caso ultrapasse utilize reticências." +
        //           "Explore os métodos length(), .substring() e concat() da String para facilitar o trabalho");
        converterArrayNumeroParaArrayLetras();

    }

    public static void converterCaracterParaMinusculo(char letraASerConvertida) {
        System.out.println((char) ((int) letraASerConvertida + 32));
    }

    public static void converterMensagemParaEnvioTwitter(String mensagem) {

        String mensagemTwitter = mensagem;

        if (mensagem.length() > 144) {
            mensagemTwitter = mensagem.substring(0, 141).concat("...");
        }

        System.out.println(mensagemTwitter);
        System.out.println(mensagemTwitter.length());

    }

    public static void converterArrayNumeroParaArrayLetras() {

        int[] numeros = {86, 99, 32, 101, 104, 32, 100, 101, 109, 97, 105,
                115, 33, 32, 83, 117, 97, 32, 114, 101, 115, 111, 108, 117,
                99, 97, 111, 32, 101, 115, 116, 97, 104, 32, 99, 111, 114,
                114, 101, 116, 97, 33, 33, 32, 78, 97, 111, 32, 99, 111, 110,
                116, 101, 32, 97, 111, 115, 32, 100, 101, 109, 97, 105, 115,
                32, 58, 41};

        String frase = new String();

        for( int elemento : numeros){
            frase = frase.concat(String.valueOf( (char) elemento ));
        }

        System.out.println(frase);

    }

}
