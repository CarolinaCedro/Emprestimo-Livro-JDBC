package org.application.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LivroCRUDGUI extends JFrame {

    private JTextField txtTitulo;
    private JTextField txtAutor;
    private JTextField txtEditora;
    private JButton btnAdicionar;
    private JButton btnEditar;
    private JButton btnAtualizar;
    private JButton btnExcluir;

    public LivroCRUDGUI() {
        setTitle("CRUD de Livros");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 200);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 2));

        JLabel lblTitulo = new JLabel("Título:");
        JLabel lblAutor = new JLabel("Autor:");
        JLabel lblEditora = new JLabel("Editora:");

        txtTitulo = new JTextField();
        txtAutor = new JTextField();
        txtEditora = new JTextField();

        btnAdicionar = new JButton("Adicionar");
        btnEditar = new JButton("Editar");
        btnAtualizar = new JButton("Atualizar");
        btnExcluir = new JButton("Excluir");

        panel.add(lblTitulo);
        panel.add(txtTitulo);
        panel.add(lblAutor);
        panel.add(txtAutor);
        panel.add(lblEditora);
        panel.add(txtEditora);
        panel.add(btnAdicionar);
        panel.add(btnEditar);
        panel.add(btnAtualizar);
        panel.add(btnExcluir);

        add(panel);

        btnAdicionar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Lógica para adicionar um livro
            }
        });

        btnEditar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Lógica para editar um livro
            }
        });

        btnAtualizar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Lógica para atualizar um livro
            }
        });

        btnExcluir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Lógica para excluir um livro
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new LivroCRUDGUI().setVisible(true);
            }
        });
    }
}
