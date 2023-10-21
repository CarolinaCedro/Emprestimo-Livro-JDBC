package org.application.actions;

import org.application.dao.AmigoDao;
import org.application.model.AmigoBean;

import java.util.List;
import java.util.Scanner;

public class MenuAmigo {
    public void exibirMenuAmigos() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nMenu Amigos:");
            System.out.println("1. Listar todos os amigos");
            System.out.println("2. Adicionar amigo");
            System.out.println("3. Atualizar amigo");
            System.out.println("4. Excluir amigo");
            System.out.println("0. Voltar");

            System.out.print("Opção: ");
            int opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    listarAmigos();
                    break;
                case 2:
                    adicionarAmigo();
                    break;
                case 3:
                    atualizarAmigo();
                    break;
                case 4:
                    excluirAmigo();
                    break;
                case 0:
                    return;  // Voltar ao menu principal
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }

    public static void listarAmigos() {
        List<AmigoBean> amigos = AmigoDao.listarTodos();
        if (amigos.isEmpty()) {
            System.out.println("Nenhum amigo cadastrado.");
        } else {
            System.out.println("\nLista de Amigos:");
            for (AmigoBean amigo : amigos) {
                System.out.println(amigo);
            }
        }
    }

    public static void adicionarAmigo() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nome do Amigo: ");
        String nome = scanner.nextLine();
        System.out.print("Documento do Amigo: ");
        String documento = scanner.nextLine();
        System.out.print("Status do Amigo: ");
        String status = scanner.nextLine();

        AmigoBean amigo = new AmigoBean(null, nome, documento, status);
        AmigoDao.inserir(amigo);
        System.out.println("Amigo inserido com sucesso.");
    }

    public static void atualizarAmigo() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("ID do Amigo que deseja atualizar: ");
        int idAmigo = scanner.nextInt();

        AmigoBean amigo = AmigoDao.buscarAmigoPorId(idAmigo);
        if (amigo == null) {
            System.out.println("Amigo não encontrado.");
            return;
        }

        scanner.nextLine();
        System.out.print("Novo nome do Amigo: ");
        String novoNome = scanner.nextLine();
        System.out.print("Novo documento do Amigo: ");
        String novoDocumento = scanner.nextLine();
        System.out.print("Novo status do Amigo: ");
        String novoStatus = scanner.nextLine();

        amigo.setNome(novoNome);
        amigo.setDocumento(novoDocumento);
        amigo.setStatus(novoStatus);
        amigo.setIdAmigo(idAmigo);

        AmigoDao.atualizar(amigo);
        System.out.println("Amigo atualizado com sucesso.");
    }

    public static void excluirAmigo() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("ID do Amigo que deseja excluir: ");
        int idAmigo = scanner.nextInt();

        AmigoBean amigo = AmigoDao.buscarAmigoPorId(idAmigo);
        if (amigo == null) {
            System.out.println("Amigo não encontrado.");
            return;
        }

        AmigoDao.excluir(idAmigo);
        System.out.println("Amigo excluído com sucesso.");
    }
}
