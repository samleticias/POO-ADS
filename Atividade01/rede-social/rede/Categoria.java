
import java.util.ArrayList;
import java.util.List;

public class Categoria {

    private int id;
    private String nome;
    private List<Postagem> postagens;

    public Categoria(int id, String nome) {
        this.id = id;
        this.nome = nome;
        this.postagens = new ArrayList<>();
    }

    public void adicionarPostagem(Postagem postagem) {
        this.postagens.add(postagem);
    }

    public void removerPostagem(Postagem postagem) {
        this.postagens.remove(postagem);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Postagem> getPostagens() {
        return postagens;
    }

    public void setPostagens(List<Postagem> postagens) {
        this.postagens = postagens;
    }
}
