
public class Main {

    public static void main(String[] args) {
        Usuario usuario1 = new Usuario("Sammya", "sammya@gmail.com", "12345");
        Categoria categoria1 = new Categoria(1, "Outubro");
        Postagem p1 = usuario1.criarPostagem("Atividade de POO", categoria1);

        Usuario usuario2 = new Usuario("José", "jogui@gmail.com", "1234");
        Comentario comentario1 = new Comentario("Bom dia!!", usuario2);

        usuario2.comentar(p1, comentario1);

        usuario2.curtir(p1);
        mostraPostagem(p1);

        comentario1.editarTexto("Python eh melhor!");
        usuario1.editarPostagem(p1, "Aprendendo Java :)", null, null);

        Comentario comentario2 = new Comentario("Café", usuario2);
        usuario2.comentar(p1, comentario2);
        mostraPostagem(p1);
    }

    public static void mostraPostagem(Postagem postagem) {
        System.out.println("\nPostagem: " + postagem.getTexto());
        System.out.println("| Data de Criação: " + postagem.getDataCriacao());

        mostraCurtidas(postagem, "\n| Curtidas:");
        mostraComentarios(postagem, "\n| Comentários:");
    }

    public static void mostraCurtidas(Postagem postagem, String message) {
        System.out.println(message);
        for (Curtida curtida : postagem.getCurtidas()) {
            System.out.println("> Curtido em " + curtida.getDataCurtida() + " por: " + curtida.getUsuario().getNome());
        }
    }

    public static void mostraComentarios(Postagem postagem, String message) {
        System.out.println(message);
        for (Comentario comentario : postagem.getComentarios()) {
            System.out.println("> " + comentario.getTexto() + " (por: " + comentario.getUsuario().getNome() + ")\n");
        }
    }
}
