import Conta from "./Conta";
import Cliente from "./Cliente";

class Banco {

    private contas: Conta[];
    private clientes: Cliente[];

    constructor() {
        this.contas = [];
        this.clientes = [];
    }

    inserirCliente(cliente: Cliente): void {
        const cpf = cliente.cpf;
        const id = cliente.id;
        if (this.CpfOuIdJaExiste(cpf, id)){
            console.log("cliente já existe");
            return;
        }
        this.clientes.push(cliente);
    }

    consultarCliente(cpf: string) : Cliente {
        let clienteProcurado!: Cliente;
        clienteProcurado = this.clientes.filter(cliente => cliente.cpf == cpf)[0];
        return clienteProcurado;
    }

    associarContaCliente(numeroConta: string, cpfCliente: string) : void{
        const contaProcurada = this.consultarConta(numeroConta);
        const clienteProcurado = this.consultarCliente(cpfCliente);

        if (this.contaPertenceAoCliente(contaProcurada, clienteProcurado)) {
            console.log("o cliente já possui essa conta");
            return;
        }
        clienteProcurado.contas.push(contaProcurada);
    }

    listarContasCliente(cpf: string) : Conta[] {
        const cliente = this.consultarCliente(cpf);
        return cliente.contas;
    }

    totalizarSaldoCliente(cpfCliente: string) : number {
        const cliente = this.consultarCliente(cpfCliente);
        const contas = cliente.contas;
        const saldosDasContas = contas.map(conta => conta.saldo);
        const saldoTotal = saldosDasContas.reduce((anterior, atual) => anterior += atual);
        return saldoTotal;
    }

    inserirConta(conta: Conta) : void {
        const numero = conta.numero;
        const id = conta.id;

        if (this.numeroOuIdJaExiste(numero, id)){
            console.log("já existe uma conta cadastrada");
            return;
        }
        this.contas.push(conta);
    }

    consultarConta(numero: string): Conta {
        let contaProcurada!: Conta;
        contaProcurada = this.contas.filter(conta => conta.numero == numero)[0];
        return contaProcurada;
    }

    private CpfOuIdJaExiste(cpf: string, id: number) : boolean {
        if (this.contas.length == 0){
            return false;
        }
        return this.clientes.filter(cliente => cliente.cpf == cpf || cliente.id == id).length > 0;
    }
    
    private numeroOuIdJaExiste(numeroConta: string, id: number) : boolean {
        if (this.clientes.length == 0){
            return false;
        }
        return this.contas.filter(conta => conta.numero == numeroConta || conta.id == id).length > 0;
    }

    private contaPertenceAoCliente(conta: Conta, cliente: Cliente): boolean{
        return cliente.contas.indexOf(conta) != -1;
    }
}

export default Banco;