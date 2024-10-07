export class Conta {
    private id: number;
    private cpf: string;
    private saldo: number;

    constructor(id: number, cpf: string, saldo: number) {
        this.id = id;
        this.cpf = cpf;
        this.saldo = saldo;
    }

    getCpf() {
        return this.cpf;
    }

    getId() {
        return this.id;
    }

    getSaldo() {
        return this.saldo;
    }

    sacar(valor: number) {
        this.saldo -= valor;
    }

    depositar(valor: number) {
        this.saldo += valor;
    }
}

function main(){
    const c1: Conta = new Conta(1, '123.456.789-00', 500.0);
    console.log('\n--------------------------------');
    mostraDadosConta(c1, "> Saldo antes do depósito: ");

    // deposito
    c1.depositar(400.0);
    mostraDadosConta(c1, "\n> Saldo após o depósito: ");

    // saque
    c1.sacar(100.0);
    mostraDadosConta(c1, "\n> Saldo após o saque: ");
    console.log('--------------------------------\n');
}

function mostraDadosConta(conta: Conta, message: string): void {
    console.log(message);
    console.log("\n| CPF do Titular: " + conta.getCpf() + "\n| Saldo: " + conta.getSaldo().toFixed(2));
}

main();