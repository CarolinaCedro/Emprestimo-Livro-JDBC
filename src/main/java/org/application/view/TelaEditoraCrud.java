/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.application.view;


import org.application.dao.EditoraDao;
import org.application.model.EditoraBEAN;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

//TODO PRECISO TERMINAR DE AJUSTAR A TABELA DE EDITORA

public class TelaEditoraCrud extends JFrame {

    private JProgressBar progressBar;

    private DefaultTableModel modelo = new DefaultTableModel();
    private EditoraDao editoraDao = new EditoraDao();

    /**
     * Creates new form TelaPrincipal
     */
    public TelaEditoraCrud() {
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

        lblRazao = new javax.swing.JLabel();
        txtRazao = new javax.swing.JTextField();
        btnSalvar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaClientes = new javax.swing.JTable();
        btnExcluir = new javax.swing.JButton();
        lblStatus = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        txtIdAmigo = new javax.swing.JTextField();
        txtStatus = new javax.swing.JTextField();
        jButtonBack = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        menuItemSair = new javax.swing.JMenu();
        jMenuItemSair = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblRazao.setText("Razão Social");

        btnSalvar.setText("Salvar");
        txtStatus.setText("ATIVO");
        txtStatus.setEnabled(false);
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        tabelaClientes.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{
                        {null, null, null},
                        {null, null, null},
                        {null, null, null},
                        {null, null, null}
                },
                new String[]{
                        "Title 1", "Title 2", "Title 3",
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
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });

        lblStatus.setText("Status");

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jButton1.setText("Buscar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("restore");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Liberation Sans", 1, 36)); // NOI18N
        jLabel1.setText("Editoras");

        jButton3.setText("Atualizar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        txtIdAmigo.setText("jTextField2");

        jButtonBack.setText("Voltar");
        jButtonBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBackActionPerformed(evt);
            }
        });

        menuItemSair.setText("Opções");
        menuItemSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemSairActionPerformed(evt);
            }
        });

        jMenuItemSair.setText("Sair");
        jMenuItemSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemSairActionPerformed(evt);
            }
        });
        menuItemSair.add(jMenuItemSair);

        jMenuBar1.add(menuItemSair);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap(94, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(txtIdAmigo, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(225, 225, 225)
                                                .addComponent(jButtonBack)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jButton2))
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(jButton3)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel1)
                                                .addGap(268, 268, 268))
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(layout.createSequentialGroup()
                                                        .addComponent(btnSalvar)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                        .addComponent(btnExcluir))
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                                .addComponent(lblRazao)
                                                                .addGap(18, 18, 18)
                                                                .addComponent(txtRazao, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(18, 18, 18)
                                                                .addComponent(lblStatus)
                                                                .addGap(18, 18, 18)
                                                                .addComponent(txtStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 663, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addComponent(jTextField1))
                                .addGap(119, 119, 119))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(19, 19, 19)
                                .addComponent(jLabel1)
                                .addGap(44, 44, 44)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(lblRazao)
                                        .addComponent(txtRazao, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lblStatus)
                                        .addComponent(txtStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(btnSalvar)
                                        .addComponent(btnExcluir))
                                .addGap(59, 59, 59)
                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(jButtonBack)))
                                        .addGroup(layout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(txtIdAmigo, javax.swing.GroupLayout.PREFERRED_SIZE, 4, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(9, 9, 9)))
                                .addGap(81, 81, 81))
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

        List<EditoraBEAN> amigos = EditoraDao.listarTodas();

        for (EditoraBEAN amigo : amigos) {
            modelo.addRow(new Object[]{
                    amigo.getIdEditora(),
                    amigo.getRazaoSocial(),
                    amigo.getStatus()
            });
        }
    }


    private void btnSalvarActionPerformed(ActionEvent evt) {
        String razao = txtRazao.getText();
        String status = "ATIVO";

        if (!isCamposValidos(razao, status)) {
            JOptionPane.showMessageDialog(null, "Existem campos a serem preenchidos", "ATENÇÃO", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        int linhaSelecionada = tabelaClientes.getSelectedRow();

        if (linhaSelecionada >= 0) {
            Integer idAmigoSelecionado = (Integer) tabelaClientes.getValueAt(linhaSelecionada, 0);

            System.out.println("o carinha selecionado " + idAmigoSelecionado);

            // Atualizar um amigo existente com base no ID
            EditoraBEAN amigo = new EditoraBEAN(idAmigoSelecionado, razao, status);
            boolean isAtualizado = EditoraDao.atualizar(amigo);

            System.out.println("status atualização " + isAtualizado);

            if (!isAtualizado) {
                modelo.setValueAt(razao, linhaSelecionada, 1);
                modelo.setValueAt(status, linhaSelecionada, 2);
                limparCampos();
            } else {
                JOptionPane.showMessageDialog(null, "Erro ao atualizar o amigo", "ATENÇÃO", JOptionPane.INFORMATION_MESSAGE);
            }
        } else {
            // Criar um novo amigo, pois nenhum amigo está selecionado na tabela
            EditoraBEAN editora = new EditoraBEAN(razao, status);
            boolean isCadastrado = EditoraDao.inserir(editora);

            if (!isCadastrado) {
                int idAmigo = EditoraDao.getLastInsertedId();
                modelo.addRow(new Object[]{idAmigo, editora.getRazaoSocial(), editora.getStatus()});
                limparCampos();
            } else {
                JOptionPane.showMessageDialog(null, "Editora já se encontra cadastrada", "ATENÇÃO", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }


    private void tabelaClientesMouseClicked(java.awt.event.MouseEvent evt) throws Exception {//GEN-FIRST:event_tabelaClientesMouseClicked
        int linhaSelecionada = tabelaClientes.getSelectedRow();
        Integer idAmigo = (Integer) tabelaClientes.getValueAt(linhaSelecionada, 0);
        try {
            EditoraBEAN editora = EditoraDao.buscarEditoraPorId(idAmigo);
            txtRazao.setText(editora.getRazaoSocial());
            txtStatus.setText(editora.getStatus());
        } catch (Exception err) {
            throw new Exception(err);
        }

    }//GEN-LAST:event_tabelaClientesMouseClicked

    private void btnExcluirActionPerformed(ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        int linhaSelecionada = tabelaClientes.getSelectedRow();

        if (linhaSelecionada >= 0) {
            int result = JOptionPane.showConfirmDialog(this, "Deseja realmente excluir esta Editora?", "CUIDADO",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE);

            if (result == JOptionPane.YES_OPTION) {

                Integer id = (Integer) tabelaClientes.getValueAt(linhaSelecionada, 0);
                this.editoraDao.excluir(id);
                modelo.removeRow(linhaSelecionada);

                JOptionPane.showMessageDialog(null, "Editora excluída com sucesso", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
                limparCampos();
            }
        } else {
            JOptionPane.showMessageDialog(null, "Nenhum Editora selecionada.", "ERRO", JOptionPane.INFORMATION_MESSAGE);
        }


    }//GEN-LAST:event_btnExcluirActionPerformed

    private void jTextField1ActionPerformed(ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void atualizarTabela(List<EditoraBEAN> amigos) {
        DefaultTableModel modelo = (DefaultTableModel) tabelaClientes.getModel();
        modelo.setRowCount(0); // Limpa a tabela

        for (EditoraBEAN amigo : amigos) {
            modelo.addRow(new Object[]{
                    amigo.getRazaoSocial(),
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
                List<EditoraBEAN> EditorasFiltradas = EditoraDao.buscarAmigosPorNome(filtroNome);

                // Atualize a tabela na UI thread
                SwingUtilities.invokeLater(() -> {
                    atualizarTabela(EditorasFiltradas);
                });

                return null;
            }
        };

        worker.execute(); // Inicie a execução do SwingWorker
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        btnExcluir.setEnabled(false);
        txtRazao.setEnabled(false);
        DefaultTableModel modelo = (DefaultTableModel) tabelaClientes.getModel();
        modelo.setRowCount(0); // Limpa a tabela

        List<EditoraBEAN> amigos = EditoraDao.listarTodosInativos();

        jButtonBack.setEnabled(true);


        txtStatus.setText("ATIVO");
        txtStatus.setEnabled(false);

        btnSalvar.setText("Restaurar");

        jButton3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                btnExcluir.setEnabled(true);
                txtRazao.setEnabled(true);
                DefaultTableModel modelo = (DefaultTableModel) tabelaClientes.getModel();
                modelo.setRowCount(0); // Limpa a tabela

                List<EditoraBEAN> amigos = EditoraDao.listarTodosInativos();
            }
        });


        btnSalvar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                int selectedRow = tabelaClientes.getSelectedRow();
                if (selectedRow >= 0) {
                    int idAmigo = (int) modelo.getValueAt(selectedRow, 0);


                    for (EditoraBEAN amigo : amigos) {
                        if (amigo.getIdEditora() == idAmigo) {
                            amigo.setStatus("ATIVO");
                            break;
                        }
                    }

                    modelo.setValueAt("ATIVO", selectedRow, 3);

                }
            }
        });

        for (EditoraBEAN editora : amigos) {
            modelo.addRow(new Object[]{
                    editora.getRazaoSocial(),
                    editora.getStatus()
            });
        }

    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButtonBackActionPerformed(ActionEvent evt) {//GEN-FIRST:event_jButtonBackActionPerformed


        btnExcluir.setEnabled(true);
        txtRazao.setEnabled(true);
        DefaultTableModel modelo = (DefaultTableModel) tabelaClientes.getModel();
        modelo.setRowCount(0); // Limpa a tabela

        List<EditoraBEAN> amigos = EditoraDao.listarTodas();

        jButtonBack.setEnabled(false);


        txtStatus.setText("ATIVO");
        txtStatus.setEnabled(false);

        btnSalvar.setText("Salvar");


        List<EditoraBEAN> editoras = EditoraDao.listarTodosOrdenadosPorNomeAsc();

        for (EditoraBEAN editora : editoras) {
            modelo.addRow(new Object[]{
                    editora.getIdEditora(),
                    editora.getRazaoSocial(),
                    editora.getStatus()
            });
        }

    }//GEN-LAST:event_jButtonBackActionPerformed

    private void jButton3ActionPerformed(ActionEvent evt) {


        DefaultTableModel modelo = (DefaultTableModel) tabelaClientes.getModel();
        modelo.setRowCount(0); // Limpa a tabela

        List<EditoraBEAN> editoras = EditoraDao.listarTodosOrdenadosPorNomeAsc();

        for (EditoraBEAN editora : editoras) {
            modelo.addRow(new Object[]{
                    editora.getIdEditora(),
                    editora.getRazaoSocial(),
                    editora.getStatus()
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
            java.util.logging.Logger.getLogger(TelaEditoraCrud.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaEditoraCrud.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaEditoraCrud.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaEditoraCrud.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaEditoraCrud().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButtonBack;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItemSair;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JLabel lblRazao;
    private javax.swing.JLabel lblStatus;
    private javax.swing.JMenu menuItemSair;
    private javax.swing.JTable tabelaClientes;
    private javax.swing.JTextField txtIdAmigo;
    private javax.swing.JTextField txtRazao;
    private javax.swing.JTextField txtStatus;
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
        modelo.addColumn("Id.Amigo");
        modelo.addColumn("NOME");
        modelo.addColumn("DOCUMENTO");
        modelo.addColumn("STATUS");

        tabelaClientes.setModel(modelo);
    }

    private void limparCampos() {
        txtIdAmigo.setText("");
        txtRazao.setText("");
        txtStatus.setText("   ATIVO   ");
    }
}