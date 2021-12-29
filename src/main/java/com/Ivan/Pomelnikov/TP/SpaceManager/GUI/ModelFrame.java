package com.Ivan.Pomelnikov.TP.SpaceManager.GUI;

import javax.swing.*;

public class ModelFrame extends JFrame {

    public ModelFrame() {

        super("Model Manager");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(600, 400);

        JPanel panel = new JPanel();
        panel.setLayout(null);

        JButton exitButton = new JButton("Exit");
        exitButton.setBounds(235, 200, Index.buttonWidth, Index.buttonHeight);
        exitButton.addActionListener(e -> this.setVisible(false));

        panel.add(exitButton);
        this.getContentPane().add(panel);
        this.setVisible(false);
    }
}