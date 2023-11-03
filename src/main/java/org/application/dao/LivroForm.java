package org.application.dao;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class LivroForm extends JFrame {
    private List<String> editoras; // Suponha que você tenha uma lista de editoras
    private List<String> autores;   // Suponha que você tenha uma lista de autores

    public LivroForm() {
        editoras = obterEditorasDoBancoDeDados(); // Substitua por sua lógica para obter as editoras
        autores = obterAutoresDoBancoDeDados();   // Substitua por sua lógica para obter os autores

        setTitle("Formulário de Livro");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        // Crie checkboxes para as editoras
        JLabel editorasLabel = new JLabel("Editoras:");
        add(editorasLabel);
        for (String editora : editoras) {
            JCheckBox checkBox = new JCheckBox(editora);
            add(checkBox);
        }

        // Crie checkboxes para os autores
        JLabel autoresLabel = new JLabel("Autores:");
        add(autoresLabel);
        for (String autor : autores) {
            JCheckBox checkBox = new JCheckBox(autor);
            add(checkBox);
        }

        JButton salvarButton = new JButton("Salvar");
        add(salvarButton);

        setVisible(true);
    }

    private List<String> obterEditorasDoBancoDeDados() {
        // Lógica para obter a lista de editoras do banco de dados
        // Substitua isso pela sua implementação
        return null;
    }

    private List<String> obterAutoresDoBancoDeDados() {
        // Lógica para obter a lista de autores do banco de dados
        // Substitua isso pela sua implementação
        return null;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new LivroForm());
    }
}

