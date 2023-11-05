/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.application.view;


import org.application.dao.AutorDao;
import org.application.model.AutorBean;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class TelaAutorCrud extends JFrame {

    private JProgressBar progressBar;

    private DefaultTableModel modelo = new DefaultTableModel();
    private AutorDao autorDAO = new AutorDao();

    /**
     * Creates new form TelaPrincipal
     */
    public TelaAutorCrud() {
        initComponents();
        initCustomComponents();
        popularTabela();
    }


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblNome = new JLabel();
        txtNome = new JTextField();
        btnSalvar = new JButton();
        lblDocument = new JLabel();
        txtDocument = new JTextField();
        jScrollPane1 = new JScrollPane();
        tabelaClientes = new JTable();
        btnExcluir = new JButton();
        lblStatus = new JLabel();
        jTextField1 = new JTextField();
        jButton1 = new JButton();
        jButton2 = new JButton();
        jLabel1 = new JLabel();
        jButton3 = new JButton();
        txtIdAutor = new JTextField();
        txtStatus = new JTextField();
        jButtonBack = new JButton();
        jMenuBar1 = new JMenuBar();
        menuItemSair = new JMenu();
        jMenuItemSair = new JMenuItem();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        lblNome.setText("Nome:");

        btnSalvar.setText("Salvar");

        txtStatus.setText("ATIVO");
        txtStatus.setEnabled(false);
        btnSalvar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        lblDocument.setText("Documento");

        tabelaClientes.setModel(new DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tabelaClientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                try {
                    tabelaClientesMouseClicked(evt);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        });
        jScrollPane1.setViewportView(tabelaClientes);

        btnExcluir.setText("Excluir");
        btnExcluir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });

        lblStatus.setText("Status");

        jTextField1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jButton1.setText("Buscar");
        jButton1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("restore");
        jButton2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Liberation Sans", 1, 36)); // NOI18N
        jLabel1.setText("Autores");

        jButton3.setText("Atualizar");
        jButton3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        txtIdAutor.setText("jTextField2");

        jButtonBack.setText("Voltar");
        jButtonBack.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jButtonBackActionPerformed(evt);
            }
        });

        menuItemSair.setText("Opções");
        menuItemSair.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                menuItemSairActionPerformed(evt);
            }
        });

        jMenuItemSair.setText("Sair");
        jMenuItemSair.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jMenuItemSairActionPerformed(evt);
            }
        });
        menuItemSair.add(jMenuItemSair);

        jMenuBar1.add(menuItemSair);

        setJMenuBar(jMenuBar1);

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(132, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtIdAutor, GroupLayout.PREFERRED_SIZE, 0, GroupLayout.PREFERRED_SIZE)
                        .addGap(225, 225, 225)
                        .addComponent(jButtonBack)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton3)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton1, GroupLayout.PREFERRED_SIZE, 77, GroupLayout.PREFERRED_SIZE))
                    .addComponent(jTextField1, GroupLayout.PREFERRED_SIZE, 663, GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addComponent(lblNome)
                            .addGap(18, 18, 18)
                            .addComponent(txtNome, GroupLayout.PREFERRED_SIZE, 262, GroupLayout.PREFERRED_SIZE)
                            .addGap(32, 32, 32)
                            .addComponent(lblDocument)
                            .addGap(18, 18, 18)
                            .addComponent(txtDocument, GroupLayout.PREFERRED_SIZE, 214, GroupLayout.PREFERRED_SIZE))
                        .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 663, GroupLayout.PREFERRED_SIZE)
                        .addGroup(GroupLayout.Alignment.TRAILING, layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(lblStatus)
                                .addGap(18, 18, 18)
                                .addComponent(txtStatus, GroupLayout.PREFERRED_SIZE, 262, GroupLayout.PREFERRED_SIZE)
                                .addGap(340, 340, 340))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnSalvar)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnExcluir))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(268, 268, 268)))
                .addGap(125, 125, 125))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel1)
                .addGap(44, 44, 44)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNome)
                    .addComponent(txtNome, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblDocument)
                    .addComponent(txtDocument, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(lblStatus)
                    .addComponent(txtStatus, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSalvar)
                    .addComponent(btnExcluir))
                .addGap(18, 18, 18)
                .addComponent(jTextField1, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton1, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton3, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButtonBack)))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtIdAutor, GroupLayout.PREFERRED_SIZE, 4, GroupLayout.PREFERRED_SIZE)
                        .addGap(9, 9, 9)))
                .addGap(22, 22, 22))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    private void menuItemSairActionPerformed(ActionEvent evt) {//GEN-FIRST:event_menuItemSairActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_menuItemSairActionPerformed

    private void jMenuItemSairActionPerformed(ActionEvent evt) {//GEN-FIRST:event_jMenuItemSairActionPerformed
        int result = JOptionPane.showConfirmDialog(this, "Deseja sair da aplicação?", "Sair",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE);
        if (result == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }//GEN-LAST:event_jMenuItemSairActionPerformed

    private void popularTabela() {
        DefaultTableModel modelo = (DefaultTableModel) tabelaClientes.getModel();
        modelo.setRowCount(0); // Limpa a tabela

        List<AutorBean> amigos = AutorDao.listarTodas();

        for (AutorBean amigo : amigos) {
            modelo.addRow(new Object[]{
                    amigo.getIdAutor(),
                    amigo.getNome(),
                    amigo.getDocumento(),
                    amigo.getStatus()
            });
        }
    }


    private void btnSalvarActionPerformed(ActionEvent evt) {
        String nome = txtNome.getText();
        String doc = txtDocument.getText();
//        String status = txtStatus.setText("Ativo");
        String status = "ATIVO";

        if (!isCamposValidos(nome, doc, status)) {
            JOptionPane.showMessageDialog(null, "Existem campos a serem preenchidos", "ATENÇÃO", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        int linhaSelecionada = tabelaClientes.getSelectedRow();

        if (linhaSelecionada >= 0) {
            Integer idAutorSelecionado = (Integer) tabelaClientes.getValueAt(linhaSelecionada, 0);


            System.out.println("o carinha selecionado " + idAutorSelecionado);

            // Atualizar um amigo existente com base no ID
            AutorBean autor = new AutorBean(idAutorSelecionado, nome, doc, status);
            boolean isAtualizado = AutorDao.atualizar(autor);

            System.out.println("status atualização " + isAtualizado);

            if (!isAtualizado) {
                modelo.setValueAt(nome, linhaSelecionada, 1);
                modelo.setValueAt(doc, linhaSelecionada, 2);
                modelo.setValueAt(status, linhaSelecionada, 3);
                limparCampos();
            } else {
                JOptionPane.showMessageDialog(null, "Erro ao atualizar o autor", "ATENÇÃO", JOptionPane.INFORMATION_MESSAGE);
            }
        } else {
            // Criar um novo amigo, pois nenhum amigo está selecionado na tabela
            AutorBean amigo = new AutorBean(nome, doc, status);
            boolean isCadastrado = AutorDao.inserir(amigo);

            if (!isCadastrado) {
                int idAmigo = AutorDao.getLastInsertedId();
                modelo.addRow(new Object[]{idAmigo, amigo.getNome(), amigo.getDocumento(), amigo.getStatus()});
                limparCampos();
            } else {
                JOptionPane.showMessageDialog(null, "Autor já se encontra cadastrado", "ATENÇÃO", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }


    private void tabelaClientesMouseClicked(java.awt.event.MouseEvent evt) throws Exception {//GEN-FIRST:event_tabelaClientesMouseClicked
        int linhaSelecionada = tabelaClientes.getSelectedRow();
        Integer idAmigo = (Integer) tabelaClientes.getValueAt(linhaSelecionada, 0);
        try {
            AutorBean amigo = AutorDao.buscarAutorPorId(idAmigo);
            txtNome.setText(amigo.getNome());
            txtStatus.setText(amigo.getStatus());
            txtDocument.setText(amigo.getDocumento());
        } catch (Exception err) {
            throw new Exception(err);
        }

    }//GEN-LAST:event_tabelaClientesMouseClicked

    private void btnExcluirActionPerformed(ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        int linhaSelecionada = tabelaClientes.getSelectedRow();

        if (linhaSelecionada >= 0) {
            int result = JOptionPane.showConfirmDialog(this, "Deseja realmente excluir este Autor?", "CUIDADO",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE);

            if (result == JOptionPane.YES_OPTION) {

                Integer id = (Integer) tabelaClientes.getValueAt(linhaSelecionada, 0);
                AutorDao.excluir(id);
                modelo.removeRow(linhaSelecionada);

                JOptionPane.showMessageDialog(null, "Autor excluído com sucesso", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
                limparCampos();
            }
        } else {
            JOptionPane.showMessageDialog(null, "Nenhum Autor selecionado.", "ERRO", JOptionPane.INFORMATION_MESSAGE);
        }


    }//GEN-LAST:event_btnExcluirActionPerformed

    private void jTextField1ActionPerformed(ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void atualizarTabela(List<AutorBean> amigos) {
        DefaultTableModel modelo = (DefaultTableModel) tabelaClientes.getModel();
        modelo.setRowCount(0); // Limpa a tabela

        for (AutorBean amigo : amigos) {
            modelo.addRow(new Object[]{
                    amigo.getIdAutor(),
                    amigo.getNome(),
                    amigo.getDocumento(),
                    amigo.getStatus()
            });
        }
    }


    private void jButton1ActionPerformed(ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String filtroNome = jTextField1.getText(); // Obtenha o texto do campo de filtro
        System.out.println("nome que será filtrado");

        // Crie uma instância de SwingWorker para executar a busca por nome em segundo plano
        SwingWorker<Void, Void> worker = new SwingWorker<Void, Void>() {
            @Override
            protected Void doInBackground() throws Exception {
                // Realize a busca por nome e atualize a tabela com os resultados
                List<AutorBean> amigosFiltrados = AutorDao.buscarAutorPorNome(filtroNome);

                // Atualize a tabela na UI thread
                SwingUtilities.invokeLater(() -> {
                    atualizarTabela(amigosFiltrados);
                });

                return null;
            }
        };

        worker.execute(); // Inicie a execução do SwingWorker
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        btnExcluir.setEnabled(false);
        txtNome.setEnabled(false);
        txtDocument.setEnabled(false);
        DefaultTableModel modelo = (DefaultTableModel) tabelaClientes.getModel();
        modelo.setRowCount(0); // Limpa a tabela

        List<AutorBean> amigos = AutorDao.listarTodosInativos();

        jButtonBack.setEnabled(true);


        txtStatus.setText("ATIVO");
        txtStatus.setEnabled(false);

        btnSalvar.setText("Restaurar");

        jButton3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                System.out.println("chegou no metodo de click");
                btnExcluir.setEnabled(true);
                txtNome.setEnabled(true);
                txtDocument.setEnabled(true);
                DefaultTableModel modelo = (DefaultTableModel) tabelaClientes.getModel();
                modelo.setRowCount(0); // Limpa a tabela

                List<AutorBean> amigos = AutorDao.listarTodosInativos();

            }
        });



        btnSalvar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                int selectedRow = tabelaClientes.getSelectedRow();
                if (selectedRow >= 0) {
                    int idAmigo = (int) modelo.getValueAt(selectedRow, 0);


                    for (AutorBean amigo : amigos) {
                        if (amigo.getIdAutor() == idAmigo) {
                            amigo.setStatus("ATIVO");
                            break;
                        }
                    }

                    modelo.setValueAt("ATIVO", selectedRow, 3);

                }
            }
        });

        for (AutorBean amigo : amigos) {
            modelo.addRow(new Object[]{
                    amigo.getIdAutor(),
                    amigo.getNome(),
                    amigo.getDocumento(),
                    amigo.getStatus()
            });
        }

    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButtonBackActionPerformed(ActionEvent evt) {//GEN-FIRST:event_jButtonBackActionPerformed


        btnExcluir.setEnabled(true);
        txtNome.setEnabled(true);
        txtDocument.setEnabled(true);
        DefaultTableModel modelo = (DefaultTableModel) tabelaClientes.getModel();
        modelo.setRowCount(0); // Limpa a tabela

        List<AutorBean> amigos = AutorDao.listarTodas();

        jButtonBack.setEnabled(false);


        txtStatus.setText("ATIVO");
        txtStatus.setEnabled(false);

        btnSalvar.setText("Salvar");




        List<AutorBean> amigoss = AutorDao.listarTodosOrdenadosPorNomeAsc();

        for (AutorBean amigo : amigos) {
            modelo.addRow(new Object[]{
                    amigo.getIdAutor(),
                    amigo.getNome(),
                    amigo.getDocumento(),
                    amigo.getStatus()
            });
        }

    }//GEN-LAST:event_jButtonBackActionPerformed

    private void jButton3ActionPerformed(ActionEvent evt) {


        DefaultTableModel modelo = (DefaultTableModel) tabelaClientes.getModel();
        modelo.setRowCount(0); // Limpa a tabela

        List<AutorBean> amigos = AutorDao.listarTodosOrdenadosPorNomeAsc();

        for (AutorBean amigo : amigos) {
            modelo.addRow(new Object[]{
                    amigo.getIdAutor(),
                    amigo.getNome(),
                    amigo.getDocumento(),
                    amigo.getStatus()
            });
        }


    }


    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TelaAutorCrud.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaAutorCrud.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaAutorCrud.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaAutorCrud.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaAutorCrud().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private JButton btnExcluir;
    private JButton btnSalvar;
    private JButton jButton1;
    private JButton jButton2;
    private JButton jButton3;
    private JButton jButtonBack;
    private JLabel jLabel1;
    private JMenuBar jMenuBar1;
    private JMenuItem jMenuItemSair;
    private JScrollPane jScrollPane1;
    private JTextField jTextField1;
    private JLabel lblDocument;
    private JLabel lblNome;
    private JLabel lblStatus;
    private JMenu menuItemSair;
    private JTable tabelaClientes;
    private JTextField txtDocument;
    private JTextField txtIdAutor;
    private JTextField txtNome;
    private JTextField txtStatus;
    // End of variables declaration//GEN-END:variables

    private boolean isCamposValidos(String... campos) {
        for (String campo : campos) {
            if (campos == null || "".equals(campo)) {
                return false;
            }
        }
        return true;
    }

    private void initCustomComponents() {
        modelo.addColumn("Id.Autores");
        modelo.addColumn("NOME");
        modelo.addColumn("DOCUMENTO");
        modelo.addColumn("STATUS");

        tabelaClientes.setModel(modelo);
    }

    private void limparCampos() {
        txtIdAutor.setText("");
        txtNome.setText("");
        txtStatus.setText("   ATIVO   ");
        txtDocument.setText("");
    }
}
