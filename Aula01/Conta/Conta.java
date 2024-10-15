package Conta;

public class Conta {
    private int id;
    private String cpf;
    private Double saldo;

    public Conta(){
    }

    public Conta(int id, String cpf, Double saldo){
        this.id = id;
        this.cpf = cpf;
        this.saldo = saldo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Double getSaldo() {
        return saldo;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void depositar(Double valor){
        this.saldo += valor;
    }

    public void sacar(Double valor){
        this.saldo -= valor;
    }

    public void mostraDadosConta(String message){
        System.out.println(message);
        System.out.println("\n| CPF do Titular: " + cpf + "\n| Saldo da conta: R$ " + String.format("%.2f", saldo));
    }
}
