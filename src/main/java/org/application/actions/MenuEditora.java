package org.application.actions;

import org.application.dao.AutorDao;
import org.application.dao.EditoraDao;
import org.application.model.AutorBean;
import org.application.model.EditoraBEAN;

import java.util.List;
import java.util.Scanner;

public class MenuEditora {
    public void exibirMenuAutores() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nMenu Editora:");
            System.out.println("1. Listar todas os editoras");
            System.out.println("2. Adicionar editora");
            System.out.println("3. Atualizar editora");
            System.out.println("4. Excluir editora");
            System.out.println("0. Voltar");

            System.out.print("Opção: ");
            int opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    listarEditoras();
                    break;
                case 2:
                    adicionarEditora();
                    break;
                case 3:
                    atualizarEditora();
                    break;
                case 4:
                    excluirEditora();
                    break;
                case 0:
                    return;  // Voltar ao menu principal
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }

    public static void listarEditoras() {
        List<EditoraBEAN> editoras = EditoraDao.listarTodas();
        if (editoras.isEmpty()) {
            System.out.println("Nenhuma Editora cadastrado.");
        } else {
            System.out.println("\nLista de Editoras:");
            for (EditoraBEAN editora : editoras) {
                System.out.println(editora);
            }
        }
    }

    public static void adicionarEditora() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nome da Razao Social: ");
        String razao = scanner.nextLine();
        System.out.print("Status da editora: ");
        String status = scanner.nextLine();

        EditoraBEAN editora = new EditoraBEAN(null,razao, status);
        EditoraDao.inserir(editora);
        System.out.println("Editora inserida com sucesso.");
    }

    public static void atualizarEditora() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("ID da editora que deseja atualizar: ");
        int idEditora = scanner.nextInt();

        EditoraBEAN editora = EditoraDao.buscarAutorPorId(idEditora);
        if (editora == null) {
            System.out.println("Editora não encontrada.");
            return;
        }

        scanner.nextLine();
        System.out.print("Novo nome para razao social: ");
        String razao = scanner.nextLine();
        System.out.print("Novo status do editora: ");
        String novoStatus = scanner.nextLine();

        editora.setRazaoSocial(razao);
        editora.setStatus(novoStatus);
        editora.setIdEditora(idEditora);

        EditoraDao.atualizar(editora);
        System.out.println("Editora atualizada com sucesso.");
    }

    public static void excluirEditora() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("ID da editora que deseja excluir: ");
        int idEditora = scanner.nextInt();

        EditoraBEAN editora = EditoraDao.buscarAutorPorId(idEditora);
        if (editora == null) {
            System.out.println("Editora não encontrada.");
            return;
        }

        EditoraDao.excluir(idEditora);
        System.out.println("Editora excluída com sucesso.");
    }

}
