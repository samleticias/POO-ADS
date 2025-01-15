package estoque;

import java.text.ParseException;
import java.util.ArrayList;

public class Estoque {

    private ArrayList<ProdutoPerecivel> produtos = new ArrayList<>();

    public void inserir(ProdutoPerecivel produto) {
        boolean prodExiste = false;

        for (Produto p : produtos) {
            if (p.getId().equals(produto.getId())) {
                prodExiste = true;
                break;
            }
        }
        if (!prodExiste) {
            produtos.add(produto);
        }
    }

    public Produto consultar(String id) {
        Produto prodProcurado = null;
        for (int i = 0; i < this.produtos.size(); i++) {
            if (this.produtos.get(i).getId().equals(id)) {
                prodProcurado = this.produtos.get(i);
                break;
            }
        }
        return prodProcurado;
    }

    public void excluir(String id) {
        int indiceProcurado = -1;

        for (int i = 0; i < this.produtos.size(); i++) {
            if (this.produtos.get(i).getId().equals(id)) {
                indiceProcurado = i;
                break;
            }
        }
        if (indiceProcurado != -1) {
            this.produtos.remove(indiceProcurado);
        }
    }

    public void repor(String id, int quantidade) {
        Produto prodProcurado = consultar(id);
        if (prodProcurado != null) {
            prodProcurado.repor(quantidade);
        }
    }

    public void darBaixa(String Id, int quantidade) {
        Produto prodProcurado = consultar(Id);
        if (prodProcurado != null) {
            prodProcurado.darBaixa(quantidade);
        }
    }

    public void listarVencidos() {
        for (ProdutoPerecivel c : produtos) {
            if (!c.isValido()) {
                System.out.println(c.toString());
            }
        }
    }

    public static void main(String[] args) throws ParseException {
        ProdutoPerecivel prod = new ProdutoPerecivel("14/01/2028", "1", "1", 0, 0);
        Estoque estoque = new Estoque();
        estoque.inserir(prod);
        estoque.repor("1", 2);
        estoque.darBaixa("1", 1);
        System.out.println(prod.toString());
        System.out.println(estoque.consultar("1"));
        estoque.excluir("1");
        System.out.println(estoque.consultar("1"));
    }
}
