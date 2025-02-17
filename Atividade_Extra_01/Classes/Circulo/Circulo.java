
public class Circulo {

    double raio;

    public Circulo(double raio) {
        this.raio = raio;
    }

    public Circulo() {
        this.raio = 0;
    }

    private double calcularArea() {
        double pi = 3.14;
        double area = this.raio * pi;
        return area;
    }

    private double calcularPerimetro() {
        double pi = 3.14;
        double perimetro = 2 * pi * this.raio;
        return perimetro;
    }

    public void showArea() {
        double area = this.calcularArea();
        System.out.printf("A área do círculo é %.2f%n", area);
    }

    public void showPerimetro() {
        double perimetro = this.calcularPerimetro();
        System.out.printf("O perímetro do círculo é %.2f%n", perimetro);
    }
}
