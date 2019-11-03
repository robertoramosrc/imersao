- Criar pacotes:
    - br.com.tt.model: Classes do modelo de negócio
    - br.com.tt.programa: Classe programa, que conterá nosso MAIN e guardará nossos dados.
    - br.com.tt.tela: Classes de "Telas" que irão interar com o usuário.
- Vamos criar as classes conforme UML.
- Vamos criar os atributos da classe conforme diagrama.
- Vamos criar o método main na classe Programa
Opções disponíveis no programa:
- Cadastrar correntista (pessoa)
- Cadastrar conta para o correntista.
- Buscar conta por agencia e número.
- Adicionar movimentos na conta.
- Listar movimentos da conta.
Como faremos:
- Criaremos as Opções principais no programa (exibeMenuPrincipal, exibeMenuCorrentista, exibeMenuConta, exibeMenuMovimento)
- Criaremos as classes de tela (TelaCorrentista, TelaConta, TelaMovimento)
- Em cada tela teremos o método exibeMenuPrincipal e os métodos de menus alternativos (exibeMenuCriarConta, etc)
- Criaremos uma dependência que nos ajudará a questionar o usuário Strings e números.
- Adicionaremos a dependência do BancoDAO
- Adicionaremos uma dependência que nos ajudará com o System.out.println().
