import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class GerenciadorEstoque {
    public static void main(String[] args) {
        try {
            Connection conexao = ConexaoBanco.conectar();

            // Exemplo de adição de produto
            Produto produto1 = new Produto(1, "Arroz", 20.0, 100, new Date());
            adicionarProduto(produto1, conexao);

            // Exemplo de edição de produto
            Produto produto2 = new Produto(2, "Feijão", 10.0, 50, new Date());
            atualizarProduto(produto2, conexao);

            // Exemplo de remoção de produto
            removerProduto(1, conexao);

            // Exemplo de busca de produto
            Produto produto3 = buscarProduto("Feijão", conexao);
            System.out.println(produto3.getNome() + " - " + produto3.getPreco());

            // Exemplo de geração de relatório
            List<Produto> produtos = listarProdutos(conexao);
            double valorTotal = 0.0;
            int quantidadeTotal = 0;
            for (Produto produto : produtos) {
                valorTotal += produto.getPreco() * produto.getQuantidade();
                quantidadeTotal += produto.getQuantidade();
            }
            System.out.println("Número total de produtos: " + produtos.size());
            System.out.println("Valor total do estoque: " + valorTotal);
            System.out.println("Quantidade de produtos em
