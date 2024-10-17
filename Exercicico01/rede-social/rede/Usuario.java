
import java.util.ArrayList;
import java.util.List;

public class Usuario {

    private String nome;
    private String email;
    private String senha;
    private List<Postagem> postagens;

    public Usuario(String nome, String email, String senha) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.postagens = new ArrayList<>();
    }

    public Postagem criarPostagem(String texto, Categoria categoria) {
        Postagem novaPostagem = new Postagem(texto, categoria);
        this.postagens.add(novaPostagem);
        categoria.adicionarPostagem(novaPostagem);
        return novaPostagem;
    }

    public void editarPostagem(Postagem postagem, String novoTexto, List<String> novasFotos, List<String> novosVideos) {
        postagem.editarConteudo(novoTexto, novasFotos, novosVideos);
    }

    public void excluirPostagem(Postagem postagem) {
        this.postagens.remove(postagem);
        postagem.getCategoria().removerPostagem(postagem);
    }

    public void comentar(Postagem postagem, Comentario comentario) {
        postagem.getComentarios().add(comentario);
    }

    public void curtir(Postagem postagem) {
        postagem.getCurtidas().add(new Curtida(this));
    }

    public List<Postagem> organizarPostagens(String nomeCategoria) {
        List<Postagem> result = new ArrayList<>();
        for (Postagem postagem : this.postagens) {
            if (postagem.getCategoria().getNome().equals(nomeCategoria)) {
                result.add(postagem);
            }
        }
        return result;
    }

    public List<Postagem> exibirPostagens() {
        return this.postagens;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
