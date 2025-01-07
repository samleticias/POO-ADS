package veiculo;

public class Carro extends Veiculo {

    private String modelo;

    public Carro(String placa, int ano, String modelo) {
        super(placa, ano);
        this.modelo = modelo;
    }
}
