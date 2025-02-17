package Retangulo;

public class Main {
    public static void main(String[] args) {
        Retangulo r1= new Retangulo(7.0, 6.0);
        System.out.println("\n--------------------------");
        System.out.println("> Altura do retângulo: " + r1.getAltura());
        System.out.println("> Largura do retângulo: " + r1.getLargura());
        
        // calculando area do retangulo
        Double area = r1.calcularArea(r1.getAltura(), r1.getLargura());
        System.out.println("> Área do retângulo: " + area);
        System.out.println("--------------------------\n");
    }
}
