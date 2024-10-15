
import java.util.Date;

public class Curtida {

    private Usuario usuario;
    private Date dataCurtida;

    public Curtida(Usuario usuario) {
        this.usuario = usuario;
        this.dataCurtida = new Date();
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Date getDataCurtida() {
        return dataCurtida;
    }

    public void setDataCurtida(Date dataCurtida) {
        this.dataCurtida = dataCurtida;
    }
}
