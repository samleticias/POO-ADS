
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Postagem {

    private String texto;
    private List<String> fotos;
    private List<String> videos;
    private Date dataCriacao;
    private Date dataEdicao;
    private List<Comentario> comentarios;
    private List<Curtida> curtidas;
    private Categoria categoria;

    public Postagem(String texto, Categoria categoria) {
        this.texto = texto;
        this.fotos = new ArrayList<>();
        this.videos = new ArrayList<>();
        this.dataCriacao = new Date();
        this.dataEdicao = new Date();
        this.comentarios = new ArrayList<>();
        this.curtidas = new ArrayList<>();
        this.categoria = categoria;
    }

    public void editarConteudo(String novoTexto, List<String> novasFotos, List<String> novosVideos) {
        if (novoTexto != null) {
            this.texto = novoTexto;
        }
        if (novasFotos != null) {
            this.fotos = novasFotos;
        }
        if (novosVideos != null) {
            this.videos = novosVideos;
        }
        this.dataEdicao = new Date();
    }

    // Getters e Setters
    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public List<String> getFotos() {
        return fotos;
    }

    public void setFotos(List<String> fotos) {
        this.fotos = fotos;
    }

    public List<String> getVideos() {
        return videos;
    }

    public void setVideos(List<String> videos) {
        this.videos = videos;
    }

    public Date getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(Date dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public Date getDataEdicao() {
        return dataEdicao;
    }

    public void setDataEdicao(Date dataEdicao) {
        this.dataEdicao = dataEdicao;
    }

    public List<Comentario> getComentarios() {
        return comentarios;
    }

    public void setComentarios(List<Comentario> comentarios) {
        this.comentarios = comentarios;
    }

    public List<Curtida> getCurtidas() {
        return curtidas;
    }

    public void setCurtidas(List<Curtida> curtidas) {
        this.curtidas = curtidas;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
}
