package DesafioSemana4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Loja {
    private static Scanner entrada = new Scanner(System.in);
    private static Map<Produto, Integer> sacola;
    public static ArrayList<Produto> produtos;
    public static void main(String[] args) {
        produtos = new ArrayList<>();
        sacola = new HashMap<>();
        Produto produto = new Produto("Iphone 11", "eletro",2999, 10);
        produtos.add(produto);
        produto = new Produto("Iphone 12", "eletro",3999, 10);
        produtos.add(produto);
        produto = new Produto("Iphone 13", "eletro",4999, 10);
        produtos.add(produto);
        produto = new Produto("Camisa Nike", "roupa",180, 10);
        produtos.add(produto);
        produto = new Produto("Camisa Adidas", "roupa",200, 10);
        produtos.add(produto);
        produto = new Produto("Camisa Puma", "roupa",250, 10);
        produtos.add(produto);
        produto = new Produto("Hamburguer", "alimento",20, 10);
        produtos.add(produto);
        produto = new Produto("Lasanha", "alimento",30, 10);
        produtos.add(produto);
        produto = new Produto("Pizza", "alimento",45, 10);
        produtos.add(produto);
        menu();
    }

    public static void menu() {
        System.out.println("=======================");
        System.out.println("[1]-Adicionar produtos ao estoque.");
        System.out.println("[2]-Controlar a quantidade de produtos.");
        System.out.println("[3]-Registrar Venda.");
        System.out.println("[4]-Procurar produto por categoria.");
        System.out.println("[0]-Sair do Programa.");
        System.out.println("=======================");
        int n = entrada.nextInt();
        switch (n) {
            case 1:
                Estoque.addProdutos();
                menu();
                break;
            case 2:
                Estoque.controlarEstoque();
                Estoque.alertaEstoque();
                menu();
                break;
            case 3:
                Venda.registrarVenda();
                Estoque.alertaEstoque();
                menu();
                break;
            case 4:
                Estoque.procurarProduto();
                menu();
                break;
            case 0:
                System.out.println("Saindo...");
                break;
            default:
                System.out.println("Opção Inválida!");
                menu();
                break;
        }
    }


}