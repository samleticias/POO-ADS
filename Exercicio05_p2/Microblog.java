
import java.util.ArrayList;

public class Microblog {

    ArrayList<Postagem> postagens = new ArrayList<>();

    // incluir post no array de postagens
    void incluir(Postagem postagem) {
        this.postagens.add(postagem);
    }

    // excluir um post passando o id no método
    void excluir(Integer id) {
        int indiceProcurado = -1;

        for (int i = 0; i < this.postagens.size(); i++) {
            if (this.postagens.get(i).id == id) {
                indiceProcurado = i;
                break;
            }
        }

        if (indiceProcurado != -1) {
            for (int i = indiceProcurado; i < this.postagens.size() - 1; i++) {
                this.postagens.set(i, this.postagens.get(i + 1));
            }
            this.postagens.remove(this.postagens.size() - 1);
        }
    }

    // consultar quantidade de posts 
    int consultarTamanho(ArrayList<Postagem> postagem) {
        return postagem.size();
    }

    // curtir post passando o id dele no método
    void curtirPost(Integer id) {
        for (Postagem post : postagens) {
            if (post.id == id) {
                post.curtir();
            }
        }
    }

    // mostrar o post mais curtido
    String mostraPostMaisCurtido() {
        Integer maiorQuantidadeCurtidas = -1;
        Postagem postMaisCurtido = null;
        for (Postagem post : postagens) {
            if (post.quantidadeCurtidas > maiorQuantidadeCurtidas) {
                postMaisCurtido = post;
                maiorQuantidadeCurtidas = post.quantidadeCurtidas;
            }
        }
        return postMaisCurtido.mostra();
    }

    // concatenação de todos os posts do array de postagens
    String mostraPosts() {
        String postagensString = "";
        for (Postagem post : postagens) {
            postagensString += "> Post " + post.id + "\n" + post.mostra() + "\n\n";
        }
        return postagensString;
    }

    public static void main(String[] args) {
        Microblog blog = new Microblog();
        Postagem post2 = new Postagem(1, "Provinha amanhã", 70);
        Postagem post1 = new Postagem(2, "Atividade de POO", 40);
        Postagem post3 = new Postagem(3, "Blog", 100);

        blog.incluir(post1);
        blog.incluir(post2);
        blog.incluir(post3);

        System.out.println(blog.mostraPosts());
        System.out.println(">>> Post mais curtido <<<\n" + blog.mostraPostMaisCurtido());
    }
}
