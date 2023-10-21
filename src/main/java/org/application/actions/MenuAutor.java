package org.application.actions;

import org.application.dao.AutorDao;
import org.application.model.AutorBean;

import java.util.List;
import java.util.Scanner;

public class MenuAutor {
    public void exibirMenuAutores() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nMenu Autores:");
            System.out.println("1. Listar todos os autores");
            System.out.println("2. Adicionar autor");
            System.out.println("3. Atualizar autor");
            System.out.println("4. Excluir autor");
            System.out.println("0. Voltar");

            System.out.print("Opção: ");
            int opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    listarAutores();
                    break;
                case 2:
                    adicionarAutor();
                    break;
                case 3:
                    atualizarAutor();
                    break;
                case 4:
                    excluirAutor();
                    break;
                case 0:
                    return;  // Voltar ao menu principal
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }

    public static void listarAutores() {
        List<AutorBean> autores = AutorDao.listarTodas();
        if (autores.isEmpty()) {
            System.out.println("Nenhum autor cadastrado.");
        } else {
            System.out.println("\nLista de Autores:");
            for (AutorBean autor : autores) {
                System.out.println(autor);
            }
        }
    }

    public static void adicionarAutor() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nome do autor: ");
        String nome = scanner.nextLine();
        System.out.print("Documento do autor: ");
        String documento = scanner.nextLine();
        System.out.print("Status do autor: ");
        String status = scanner.nextLine();

        AutorBean autor = new AutorBean(null, nome, documento, status);
        AutorDao.inserir(autor);
        System.out.println("Autor inserido com sucesso.");
    }

    public static void atualizarAutor() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("ID do autor que deseja atualizar: ");
        int idAutor = scanner.nextInt();

        AutorBean autor = AutorDao.buscarAutorPorId(idAutor);
        if (autor == null) {
            System.out.println("Autor não encontrado.");
            return;
        }

        scanner.nextLine(); // Limpar a quebra de linha
        System.out.print("Novo nome do autor: ");
        String novoNome = scanner.nextLine();
        System.out.print("Novo documento do autor: ");
        String novoDocumento = scanner.nextLine();
        System.out.print("Novo status do autor: ");
        String novoStatus = scanner.nextLine();

        autor.setNome(novoNome);
        autor.setDocumento(novoDocumento);
        autor.setStatus(novoStatus);
        autor.setIdAutor(idAutor);

        AutorDao.atualizar(autor);
        System.out.println("Autor atualizado com sucesso.");
    }

    public static void excluirAutor() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("ID do autor que deseja excluir: ");
        int idAutor = scanner.nextInt();

        AutorBean autor = AutorDao.buscarAutorPorId(idAutor);
        if (autor == null) {
            System.out.println("Autor não encontrado.");
            return;
        }

        AutorDao.excluir(idAutor);
        System.out.println("Autor excluído com sucesso.");
    }

}
