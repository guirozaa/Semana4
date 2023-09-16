package DesafioSemana4;

import java.util.Scanner;

public class Estoque {
    private static Scanner entrada = new Scanner(System.in);
    public static void addProdutos(){
        System.out.println("Nome do produto: ");
        String nome = entrada.nextLine();

        System.out.println("Categoria do produto(eletro/roupa/alimento): ");
        String categoriaProduto = entrada.next();

        System.out.println("Preço do produto: ");
        float preco = entrada.nextFloat();

        System.out.println("Quantidade do produto: ");
        int quantidade = entrada.nextInt();

        Produto produto = new Produto(nome, categoriaProduto,preco,quantidade);
        Loja.produtos.add(produto);
    }
    public static void procurarProduto() {
        System.out.println("Qual a categoria do produto?(eletro/roupa/alimento)");
        String categoriaDesejada = entrada.next();

        System.out.println("Produtos da categoria " + categoriaDesejada + ":");
        for (Produto produto : Loja.produtos) {
            if (produto.getCategoriaProduto().equalsIgnoreCase(categoriaDesejada)) {
                System.out.println("Nome: " + produto.getNomeProduto() + ", Preço: R$" + produto.getPrecoProduto() +
                        ", Código: " + produto.getCodigoProduto());
            }
        }
    }
    public static void controlarEstoque(){
        System.out.println("============================");
        System.out.println("ÁREA DE CONTROLE DE ESTOQUE");

        for (Produto produto : Loja.produtos) {
            System.out.println("Nome: " + produto.getNomeProduto() + "Código: " + produto.getCodigoProduto() +
                    "Quantidade: " + produto.getQuantProduto());
        }

        System.out.println("=========================================");
        System.out.println("Qual código do produto do estoque que deseja modificar?");
        int produtoEscolhido = entrada.nextInt();

        System.out.println("Você deseja adicionar(add) ou subtrair(sub) o estoque de produtos?");
        String acaoEscolhida = entrada.next();

        if (acaoEscolhida.equalsIgnoreCase("add")) {
            System.out.println("Deseja adicionar quanto ao estoque?");
            int novaQuantidade = entrada.nextInt();
            Loja.produtos.get(produtoEscolhido).setQuantProduto(Loja.produtos.get(produtoEscolhido).getQuantProduto() + novaQuantidade);
        }

        if (acaoEscolhida.equalsIgnoreCase("sub")) {
            System.out.println("Deseja tirar quanto ao estoque?");
            int novaQuantidade = entrada.nextInt();
            if (novaQuantidade <= Loja.produtos.get(produtoEscolhido).getQuantProduto()) {
                Loja.produtos.get(produtoEscolhido).setQuantProduto(Loja.produtos.get(produtoEscolhido).getQuantProduto() - novaQuantidade);
            }
            else{
                System.out.println("N");
            }
        }
        else{
            System.out.println("Digitação incorreta escreva add ou sub");
        }
    }
    public static void alertaEstoque(){
        for (Produto produto: Loja.produtos) {
            if (produto.getQuantProduto() < 3){
                System.out.println("ESTOQUE BAIXO DE "+ produto.getNomeProduto() +"!! ADICIONE PRODUTOS AO ESTOQUE");
            }
        }
    }
}