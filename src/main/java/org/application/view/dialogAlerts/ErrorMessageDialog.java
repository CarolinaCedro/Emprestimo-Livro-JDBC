package org.application.view.dialogAlerts;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ErrorMessageDialog extends JDialog {

    public ErrorMessageDialog(String message) {
        setTitle("Erro");
        setModal(true);

        JPanel messagePanel = new JPanel(new FlowLayout());
        messagePanel.add(new JLabel(message));

        JPanel buttonPanel = new JPanel(new FlowLayout());
        JButton okButton = new JButton("OK");

        okButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        buttonPanel.add(okButton);

        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(messagePanel, BorderLayout.CENTER);
        getContentPane().add(buttonPanel, BorderLayout.SOUTH);

        pack();
        setLocationRelativeTo(null);
    }
}
