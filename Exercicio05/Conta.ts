import Cliente from "./Cliente";

class Conta {

    id: number;
    numero : string;
    saldo : number;
    cliente : Cliente;

    constructor(id: number, numero: string, saldo : number){
        this.numero = numero;
        this.saldo = saldo;
    }

    sacar(valor: number) : boolean {
        if (valor > this.saldo){
            return false;
        }
        this.saldo -= valor;
        return true;
    }

    depositar(valor: number) : void{
        this.saldo += valor;
    }

    consultarSaldo() : number {
        return this.saldo;
    }

    transferir(contaDestino: Conta, valor: number) : boolean {
        if (!this.sacar(valor)){
            return false;
        }
        contaDestino.depositar(valor);
        return true;
    }

}

export default Conta;