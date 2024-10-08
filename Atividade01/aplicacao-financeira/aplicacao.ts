class Transacao {
    tipo: string;
    valor: number;
    data: Date;
    descricao: string;

    constructor(tipo: string, valor: number, descricao: string = "") {
        this.tipo = tipo;
        this.valor = valor;
        this.data = new Date();
        this.descricao = descricao;
    }
}

class Historico {
    transacoes: Transacao[];

    constructor() {
        this.transacoes = [];
    }

    adicionarTransacao(transacao: Transacao): void {
        this.transacoes.push(transacao);
    }

    consultarTransacoes(): Transacao[] {
        return this.transacoes;
    }
}

class Cliente {
    nome: string;
    cpf: string;
    listaContas: ContaBancaria[];

    constructor(nome: string, cpf: string) {
        this.nome = nome;
        this.cpf = cpf;
        this.listaContas = [];
    }

    abrirConta(tipoConta: string): ContaBancaria {
        const novaConta = new ContaBancaria(tipoConta, this);
        this.listaContas.push(novaConta);
        return novaConta;
    }

    consultarContas(): ContaBancaria[] {
        return this.listaContas;
    }
}

class ContaBancaria {
    numeroConta: string;
    saldo: number;
    tipoConta: string;
    cliente: Cliente;
    historico: Historico;

    constructor(tipoConta: string, cliente: Cliente) {
        this.numeroConta = this.gerarNumeroConta();
        this.saldo = 0;
        this.tipoConta = tipoConta;
        this.cliente = cliente;
        this.historico = new Historico();
    }

    private gerarNumeroConta(): string {
        return Math.random().toString(36).substring(2, 9); 
    }

    depositar(valor: number): void {
        this.saldo = this.saldo + valor;
        this.historico.adicionarTransacao(new Transacao("depósito", valor));
    }

    sacar(valor: number): void {
        if (valor <= this.saldo) {
            this.saldo = this.saldo - valor;
            this.historico.adicionarTransacao(new Transacao("saque", valor));
        } else {
            console.log("Saldo insuficiente");
        }
    }

    consultarSaldo(): number {
        return this.saldo;
    }

    consultarHistorico(): Transacao[] {
        return this.historico.consultarTransacoes();
    }
}

class Sistema {
    contas: ContaBancaria[];

    constructor() {
        this.contas = [];
    }

    buscarConta(numeroConta: string): ContaBancaria | undefined {
        for (const conta of this.contas) {
            if (conta.numeroConta === numeroConta) {
                return conta;
            }
        }
        return undefined; 
    }

    excluirConta(numeroConta: string): void {
        this.contas = this.contas.filter(conta => conta.numeroConta !== numeroConta);
    }

    adicionarConta(conta: ContaBancaria): void {
        this.contas.push(conta);
    }

    listarContas(): ContaBancaria[] {
        return this.contas;
    }
}

function mostraHistorico(historico: Transacao[]): void {
    for (const transacao of historico) {
        const t = `
        > Transação
        | Tipo: ${transacao.tipo}
        | Valor R$: ${transacao.valor.toFixed(2)}
        | Data: ${transacao.data}\n`;
        console.log(t);
    }
}

function main() {
    const sistema = new Sistema();
    const cliente1 = new Cliente("joao", "123.456.789-00");
    const conta1 = cliente1.abrirConta("corrente");
    sistema.adicionarConta(conta1);

    mostraDadosCliente(cliente1, "\n> Dados do Cliente: ")
    
    // deposito
    console.log('\n--------------------------------');
    mostraDadosConta(conta1, "> Saldo antes do depósito: ");

    conta1.depositar(200.0);
    mostraDadosConta(conta1, "\n> Saldo após o depósito: ");

    // saque
    conta1.sacar(50);
    mostraDadosConta(conta1, "\n> Saldo após o saque: ");
    console.log('\n--------------------------------\n');
    
    console.log("Saldo da conta R$:", conta1.consultarSaldo().toFixed(2));
    console.log("\nHistórico de transações:");
    mostraHistorico(conta1.consultarHistorico());
}

function mostraDadosCliente(cliente: Cliente, message: string): void {
    console.log(message);
    console.log("\n| CPF: " + cliente.cpf + "\n| Nome do Cliente: " + cliente.nome);
}

function mostraDadosConta(conta: ContaBancaria, message: string): void {
    console.log(message);
    console.log("\n| Número da Conta: " + conta.numeroConta + "\n| Saldo R$: " + conta.saldo.toFixed(2));
}

main();
