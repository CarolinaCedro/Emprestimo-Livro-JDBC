package org.application.actions;

import org.application.dao.LivroDao;
import org.application.model.LivroBean;

import java.util.List;
import java.util.Scanner;

public class MenuLivro {
    public void exibirMenuLivros() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nMenu Livros:");
            System.out.println("1. Listar todas os livros");
            System.out.println("2. Adicionar livro");
            System.out.println("3. Atualizar livro");
            System.out.println("4. Excluir livro");
            System.out.println("0. Voltar");

            System.out.print("Opção: ");
            int opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    listarLivros();
                    break;
                case 2:
                    adicionarLivro();
                    break;
                case 3:
                    atualizarLivro();
                    break;
                case 4:
                    excluirLivro();
                    break;
                case 0:
                    return;  // Voltar ao menu principal
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }

    public static void listarLivros() {
        List<LivroBean> livros = LivroDao.listarTodas();
        System.out.println("listando todos os livros" + livros);
        if (livros.isEmpty()) {
            System.out.println("Nenhum Livro cadastrado.");
        } else {
            System.out.println("\nLista de Livros:");
            for (LivroBean autor : livros) {
                System.out.println(autor);
            }
        }
    }

    public static void adicionarLivro() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nome do Titulo: ");
        String titulo = scanner.nextLine();
        System.out.print("Status da editora: ");
        String status = scanner.nextLine();
        System.out.print("Id da editora: ");
        Integer id_editora = scanner.nextInt();
        System.out.print("Id da autor: ");
        Integer id_autor = scanner.nextInt();


        LivroBean livro = new LivroBean(null, titulo, status, id_editora, id_autor, null, null);
        LivroDao.inserir(livro);
        System.out.println("Livro inserido com sucesso.");
    }

    public static void atualizarLivro() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("ID do Livro que deseja atualizar: ");
        int idLivro = scanner.nextInt();

        LivroBean livro = LivroDao.buscarLivroPorId(idLivro);
        if (livro == null) {
            System.out.println("Livro não encontrado.");
            return;
        }

        scanner.nextLine();
        System.out.print("Título do livro: ");
        String titulo = scanner.nextLine();
        System.out.print("ID do autor: ");
        int autor_id = scanner.nextInt();
        System.out.print("ID da editora: ");
        int editora_id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Status do livro: ");
        String status = scanner.nextLine();

        LivroBean novoLIvro = new LivroBean(idLivro, titulo, status, editora_id, autor_id, null, null);
        LivroDao.atualizar(novoLIvro);
        System.out.println("Livro atualizado com sucesso.");
    }

    public static void excluirLivro() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("ID do Livro que deseja excluir: ");
        int idLivro = scanner.nextInt();

        LivroBean editora = LivroDao.buscarLivroPorId(idLivro);
        if (editora == null) {
            System.out.println("Livro não encontrado.");
            return;
        }

        LivroDao.excluir(idLivro);
        System.out.println("Livro excluído com sucesso.");
    }

}
