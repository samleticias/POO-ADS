
public class Postagem {

    Integer id;
    String texto;
    Integer quantidadeCurtidas;

    public Postagem(Integer id, String texto, Integer quantidadeCurtidas) {
        this.id = id;
        this.texto = texto;
        this.quantidadeCurtidas = quantidadeCurtidas;
    }

    void curtir() {
        this.quantidadeCurtidas++;
    }

    String mostra() {
        return "Postagem: " + this.texto + "\n" + "Curtidas: " + this.quantidadeCurtidas;
    }

    public static void main(String[] args) {
        Postagem postagem = new Postagem(1, "Atividade de POO", 50);
        System.out.println(postagem.mostra());
    }
}
