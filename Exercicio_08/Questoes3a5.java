package app;

public class Questoes3a5 {

    public static void main(String[] args) throws Exception {
        Questao3.main(args);
        Questao4.main(args);
        Questao5.main(args);
    }
}

/*3) Crie duas contas e teste o método transferir de modo que a conta a ser debitada
não possua saldo suficiente. Explique o que ocorreu.*/
class Questao3 {

    public static void main(String[] args) throws Exception {
        Conta c1 = new Conta("111-1", 0);
        Conta c2 = new Conta("222-2", 0);
        c1.transferir(c2, 100);
    }
    /* O método transferir() utiliza o método sacar() e a conta de origem não possui saldo suficiente para realizar o saque,
    o método sacar lança uma exceção. Como essa exceção não está sendo tratada no método transferir,
    ela se propaga para o método que chamou transferir, que, no caso, é o método main. Por não ser tratada na main, o programa
    é abortado.
     */
}

/*4) Instancie uma classe App e, caso necessário, crie duas contas. Acesse a opção de
transferir com valor alto o suficiente para lançar uma exceção/erro. Verifique que o
lançamento da exceção foi “propagado” para o método conta.transferir(),
banco.transferir() e App.menu()? Como você avalia a confiabilidade dessa
implementação. */
class Questao4 {

    public static void main(String[] args) throws Exception {
        App app = new App();
        Conta c1 = new Conta("123-1", 0);
        Conta c2 = new Conta("256-2", 0);
        app.inserirConta(c1);
        app.inserirConta(c2);
        app.transferir("123-1", "256-2", 100);
    }
    /* Ao lançar uma exceção e não tratá-la, ela continuará sendo propagada para métodos superiores na pilha de chamadas.
    Sendo assim, a confiabilidade dessa aplicação ainda não está ideal, pois, sem tratamento adequado em nenhuma camada,
    o mecanismo padrão utilizado para lidar com o erro é abortar o programa, o que não é uma abordagem adequada.
    Em um design robusto, é essencial implementar estratégias de tratamento de exceções em diferentes camadas da aplicação e garantir
    que a aplicação continue em funcionamento.
     */
}

/* 5) Crie um método chamado validaValor(valor) na que lance um erro caso o valor
repassado seja menor ou igual a zero ou em formato inválido. Chame o método no
construtor da classe conta para validar o saldo inicial. Chame o método também
nos métodos sacar e depositar. Reexecute a classe App e chame as opções de
menu que aceitam valores referentes a saldo, débito, crédito e transferir. Avalie o
tratamento do erro. */
class Questao5 {

    public static void main(String[] args) throws Exception {
        App app = new App();
        Conta c1 = new Conta("123-1", 0);
        Conta c2 = new Conta("256-2", 0);
        app.inserirConta(c1);
        app.inserirConta(c2);
        app.transferir("123-1", "256-2", 100);
    }
}
