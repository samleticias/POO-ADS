package Retangulo;

public class Retangulo {

    private Double altura;
    private Double largura;

    public Retangulo(){
    }

    public Retangulo(Double altura, Double largura){
        this.altura = altura;
        this.largura = largura;
    }

    public Double getAltura() {
        return altura;
    }

    public void setAltura(Double altura) {
        this.altura = altura;
    }

    public Double getLargura() {
        return largura;
    }

    public void setLargura(Double largura) {
        this.largura = largura;
    }

    public Double calcularArea(Double altura, Double largura){
        return altura * largura;
    }

    public void mostraValores(String message){
        System.out.println(message);
        System.out.println("\n> Altura = " + altura + "\n> Largura = " + largura + "\n> Área = " + calcularArea(altura, largura));
    }
}
