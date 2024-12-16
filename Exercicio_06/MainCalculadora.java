
class Calculadora {

    private double operando1;
    private double operando2;

    public Calculadora(double operando1, double operando2) {
        this.operando1 = operando1;
        this.operando2 = operando2;
    }

    public double somar() {
        return operando1 + operando2;
    }

    public double multiplicar() {
        return operando1 * operando2;
    }

    public double getOperando1() {
        return this.operando1;
    }

    public void setOperando1(double operando1) {
        this.operando1 = operando1;
    }

    public double getOperando2() {
        return this.operando2;
    }

    public void setOperando2(double operando2) {
        this.operando2 = operando2;
    }
}

public class MainCalculadora {

    public static void main(String[] args) {
        Calculadora calculadora = new Calculadora(20, 25);
        System.out.println("Soma = " + calculadora.somar()); // Saída: Soma = 45.0

        // Emitirá um erro, pois o atributo operando1 é private e só pode ser acessado dentro da própria classe
        System.out.println(calculadora.operando1);

        System.out.println(calculadora.getOperando1());  // Saída: 20.0

    }
}
