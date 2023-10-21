package org.application;

import org.application.actions.MenuAutor;
import org.application.actions.MenuEditora;
import org.application.actions.MenuLivro;
import org.application.config.ConnectionMySQLDAO;
import org.application.dao.AutorDao;
import org.application.dao.EditoraDao;
import org.application.dao.LivroDao;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        ConnectionMySQLDAO.getConnection();
        Scanner scanner = new Scanner(System.in);
        MenuAutor menuAutor = new MenuAutor();
        MenuEditora menuEditora = new MenuEditora();
        MenuLivro menuLivro = new MenuLivro();

        while (true) {
            System.out.println("Escolha uma opção:");
            System.out.println("1. Autor");
            System.out.println("2. Editora");
            System.out.println("3. Livro");
            System.out.println("4. Criar Tabelas");
            System.out.println("0. Sair");
            System.out.print("Opção: ");

            int opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    menuAutor.exibirMenuAutores();
                    break;
                case 2:
                    menuEditora.exibirMenuAutores();
                    break;
                case 3:
                    menuLivro.exibirMenuLivros();
                    break;
                case 4:
                    criarTabelas();
                    break;
                case 0:
                    System.out.println("Encerrando o programa.");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }

    private static void criarTabelas() {
        try {
            EditoraDao.criarTabelaEditoras();
            AutorDao.criarTabelaAutores();
            LivroDao.criarTabelaLivros();

        } catch (Throwable err) {
            System.out.println(err);
        }
    }

}
