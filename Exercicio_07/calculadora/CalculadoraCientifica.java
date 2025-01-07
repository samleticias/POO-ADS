package calculadora;

class CalculadoraCientifica extends Calculadora {

    public CalculadoraCientifica(double operando1, double operando2) {
        super(operando1, operando2);
    }

    public double exponenciar() {
        return Math.pow(getOperando1(), getOperando2());
    }

    public static void main(String[] args) {
        CalculadoraCientifica calculadora = new CalculadoraCientifica(5, 2);

        System.out.println(calculadora.exponenciar()); // Saída = 25.0

        // 3. Foi necessário criar os métodos getOperando1 e getOperando2 para acessar os atributos da superclasse Calculadora
    }
}
