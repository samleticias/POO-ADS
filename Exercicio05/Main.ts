import Conta from "./Conta";
import Cliente from "./Cliente";
import Banco from "./Banco";

function main() : void {

    const banco = new Banco();

    banco.inserirConta(new Conta(1, "123-1", 200));
    banco.inserirConta(new Conta(2, "100-2", 600));
    banco.inserirConta(new Conta(3, "101-2", 0));
    banco.inserirConta(new Conta(4, "102-2", 100));
    banco.inserirConta(new Conta(4, "177-2", 100));

    banco.inserirCliente(new Cliente(1, "José", "123.456.789-00", new Date()));
    banco.inserirCliente(new Cliente(2, "João", "111.222.333-98", new Date()));

    banco.associarContaCliente("123-1", "123.456.789-00");   // cliente José
    banco.associarContaCliente("100-2", "111.222.333-98");   // cliente João
    banco.associarContaCliente("102-2", "123.456.789-00");   // cliente José
    banco.associarContaCliente("102-2", "111.222.333-98");   // cliente João
    banco.associarContaCliente("177-2", "123.456.789-00");  // cliente José

    const saldoJose = banco.totalizarSaldoCliente("123.456.789-00"); 
    const saldoJoao = banco.totalizarSaldoCliente("111.222.333-98"); 

    console.log(">>> Saldos dos clientes <<<")
    console.log("\nSaldo total do José: R$ "+ saldoJose.toFixed(2));
    console.log("\nSaldo total do João: R$ "+ saldoJoao.toFixed(2));

    const listaContasJose = banco.listarContasCliente("123.456.789-00");
    const listaContasJoao = banco.listarContasCliente("111.222.333-98");

    console.log("\nLista de contas do José: ", listaContasJose);
    console.log("\nLista de contas do João: ", listaContasJoao);

    banco.inserirCliente(new Cliente(1, "José", "123.456.789-00", new Date())); // Saída: cliente já existe
    banco.inserirConta(new Conta(1, "123-1", 0)); // Saída: já existe uma conta cadastrada
    banco.inserirConta(new Conta(1, "177-2", 0)); // Saída: já existe uma conta cadastrada
}

main();