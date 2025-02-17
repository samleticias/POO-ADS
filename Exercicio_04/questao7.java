
class Triangulo {

    double a;
    double b;
    double c;

    public Triangulo(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public boolean isTriangulo() {
        return (a > Math.abs(b - c)) && (a < b + c);
    }

    public boolean isEquilatero() {
        if (!isTriangulo()) {
            return false;
        }
        return a == b & b == c;
    }

    public boolean isIsosceles() {
        if (!isTriangulo()) {
            return false;
        }
        return a == b || b == c || a == c;
    }

    public boolean isEscaleno() {
        if (!isTriangulo()) {
            return false;
        }
        return a != b && a != c && b != c;
    }
}

public class questao7 {

    public static void main(String[] args) {
        Triangulo triangulo2 = new Triangulo(3, 4, 5);
        System.out.println("é triângulo? " + triangulo2.isTriangulo());
        System.out.println("é equilátero? " + triangulo2.isEquilatero());
        System.out.println("é isósceles? " + triangulo2.isIsosceles());
        System.out.println("é escaleno? " + triangulo2.isEscaleno());
    }
}
