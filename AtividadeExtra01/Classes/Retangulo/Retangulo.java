
public class Retangulo {

    double comprimento;
    double largura;

    public Retangulo(double comprimento, double largura) {
        this.comprimento = comprimento;
        this.largura = largura;
    }

    public double calcularArea() {
        double area = this.comprimento * this.largura;
        return area;
    }

    public double calcularPerimetro() {
        double perimetro = 2 * (this.comprimento + this.largura);
        return perimetro;
    }

    public void showArea() {
        double area = this.calcularArea();
        System.out.printf("A área do retângulo é %.2f%n", area);
    }

    public void showPerimetro() {
        double perimetro = this.calcularPerimetro();
        System.out.printf("O perímetro do retângulo é %.2f%n", perimetro);
    }

    public boolean isQuadrado() {
        return this.comprimento == this.largura;
    }

}
