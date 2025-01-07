package veiculo;

public class CarroEletrico extends Carro {

    private double autonomiaBateria;

    public CarroEletrico(String placa, int ano, String modelo, double autonomiaBateria) {
        super(placa, ano, modelo);
        this.autonomiaBateria = autonomiaBateria;
    }
}
