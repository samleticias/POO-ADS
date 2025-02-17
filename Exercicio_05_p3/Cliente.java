
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Cliente {

    int id;
    String nome;
    String cpf;
    Date dataNascimento;
    List<Conta> contas;

    public Cliente(int id, String nome, String cpf, Date dataNascimento) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
        this.contas = new ArrayList<>();
    }
}
