
public class Program {

    public static void main(String[] args) {
        Retangulo r1 = new Retangulo(5.0, 7.0);

        r1.showArea();
        r1.showPerimetro();

        Retangulo r2 = new Retangulo(5.0, 5.0);
        System.out.println("r2 é quadrado: " + r2.isQuadrado());
        System.out.println("r1 é quadrado: " + r1.isQuadrado());
    }
}
