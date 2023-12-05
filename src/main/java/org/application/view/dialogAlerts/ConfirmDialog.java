package org.application.view.dialogAlerts;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ConfirmDialog extends JDialog {
    private boolean confirmed = false;

    public ConfirmDialog(String message) {
        setTitle("Confirmação");
        setModal(true);

        JPanel messagePanel = new JPanel(new FlowLayout());
        messagePanel.add(new JLabel(message));

        JPanel buttonPanel = new JPanel(new FlowLayout());
        JButton yesButton = new JButton("Sim");
        JButton noButton = new JButton("Não");

        yesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                confirmed = true;
                dispose();
            }
        });

        noButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        buttonPanel.add(yesButton);
        buttonPanel.add(noButton);

        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(messagePanel, BorderLayout.CENTER);
        getContentPane().add(buttonPanel, BorderLayout.SOUTH);

        pack();
        setLocationRelativeTo(null);
    }

    public boolean isConfirmed() {
        return confirmed;
    }
}
