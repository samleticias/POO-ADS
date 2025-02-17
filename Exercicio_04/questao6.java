
class Saudacao {

    String texto;
    String destinatario;

    public Saudacao(String texto, String destinatario) {
        this.texto = texto;
        this.destinatario = destinatario;
    }

    public void obterSaudacao() {
        System.out.println(this.texto + ", " + this.destinatario + "!");
    }
}

public class questao6 {

    public static void main(String[] args) {
        Saudacao saudacao = new Saudacao("Bom dia", "Sammya");
        saudacao.obterSaudacao();
    }
}
