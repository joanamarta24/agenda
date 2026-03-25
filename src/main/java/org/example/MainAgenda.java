package org.example;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class MainAgenda {
    private  static final ContatoDAO dao = new ContatoDAO();
    private static final Scanner scanner = new Scanner(System.in);

    static void main() {
        Database.criarTabela();

        System.out.println("Minha Agenda de Contato (com BAnco de Dado SQLite)");
        int opcao = 0;
        while (opcao!=5){
            exibirMenu();
            try{
                opcao = scanner.nextInt();
                scanner.nextLine();
             switch (opcao){
                 case 1:adicionarContato();break;
                 case 2:listarContato();break;
                 case 3:aatualizarContato();break;
                 case 4:removerContato();break;
                 case 5: System.out.println("Encerrando....");;break;
                 default:
                     System.out.println("Opção inválida!");break;
             }
            }catch (InputMismatchException e){
                System.out.println("Erro: Por Favor, digite um número.");
                scanner.nextLine();
            }
        }

    }
    private static void exibirMenu(){
        System.out.println("\n---AGENDA---");
        System.out.println("1. Adicionar Contato");
        System.out.println("2. Listar Contatos.");
        System.out.println("3. Atualizar Contato.");
        System.out.println("4. Remover Contato.");
        System.out.println("5. Sair");
        System.out.println("Escolha uma opção: ");
    }
    private static void adicionarContato(){
        System.out.println("\n---Adionar Contato---");
        System.out.println("Nome: ");
        String nome = scanner.nextLine();
        System.out.println("Telefone: ");
        String telefone = scanner.nextLine();

        dao.adicionar(new Contato(nome,telefone));
        System.out.println("Contato salvo com Sucesso!");
    }
    private static void listarContato(){
        System.out.println("\n--- Lista de Contatos ---");
        List<Contato> contatoes = dao.listar();
        if (contatoes.isEmpty()){
            System.out.println("Nenhum contato cadastrado.");
        }else {
            contatoes.forEach(System.out::println);
        }
    }
    private  static void aatualizarContato(){
        System.out.println("\n--- Atualizar Contato ---");
        System.out.println("Digite o ID do contato a ser atualizado: ");
        try{
            int id = scanner.nextInt();
            scanner.nextLine();

            System.out.println("Novo Nome:  ");
            String nome = scanner.nextLine();
            System.out.println("Novo Telefone: ");
            String telefone = scanner.nextLine();

            dao.atualizar(new Contato(id, nome,telefone));
            System.out.println("Contato atualizado com sucesso!");
        }catch (InputMismatchException e){
            System.out.println("ID inválido.Digite um número.");
            scanner.nextLine();
        }
    }
    private  static void removerContato(){
        System.out.println("\n--- Remover Contato ---");
        System.out.println("Digite o ID do contato a ser removido: ");
        try {
            int id = scanner.nextInt();
            scanner.nextLine();

            dao.remover(id);
            System.out.println("Contato removido com sucesso!");
        }catch (InputMismatchException e){
            System.out.println("ID inválido.Digite um número.");
            scanner.nextLine();
        }
    }
}
