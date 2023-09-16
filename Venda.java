package DesafioSemana4;

import java.util.Scanner;

public class Venda {
    public static void registrarVenda(){
        Scanner entrada = new Scanner(System.in);
        System.out.println("============================================");
        for ( Produto produto : Loja.produtos) {
            System.out.println("Nome: " + produto.getNomeProduto() + ", Preço: R$" + produto.getPrecoProduto() +
                    ", Código: " + produto.getCodigoProduto());
        }
        System.out.println("=================");
        System.out.println("=Qual o Código do produto você quer comprar? ");
        int codigoProduto = entrada.nextInt();
        System.out.println("Você quer comprar quantos " + Loja.produtos.get(codigoProduto).getNomeProduto() + "?");
        int quantProdutoComprar = entrada.nextInt();

        if (quantProdutoComprar <= Loja.produtos.get(codigoProduto).getQuantProduto()) {
            float totalCompra = quantProdutoComprar * Loja.produtos.get(codigoProduto).getPrecoProduto();
            System.out.println("Total da compra: R$" + totalCompra);

            Loja.produtos.get(codigoProduto).setQuantProduto(Loja.produtos.get(codigoProduto).getQuantProduto() - quantProdutoComprar);
        }
        else{
            System.out.println("Desculpe não há estoque o suficiente para essa compra");
        }
    }
}