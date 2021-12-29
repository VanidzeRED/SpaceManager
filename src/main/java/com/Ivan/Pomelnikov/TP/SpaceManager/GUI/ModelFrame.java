package com.Ivan.Pomelnikov.TP.SpaceManager.GUI;

import javax.swing.*;

public class ModelFrame extends JFrame {

    public ModelFrame() {
        super("Model Manager");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(630, 250);

        JPanel panel = new JPanel();
        panel.setLayout(null);

        JTextField nameTextField = new JTextField("name");
        nameTextField.setBounds(10, 10, Index.buttonWidth, Index.buttonHeight);

        JTextField payloadTextField = new JTextField("payload");
        payloadTextField.setBounds(10, 50, Index.buttonWidth, Index.buttonHeight);

        JTextField maxRouteLengthTextField = new JTextField("max route length");
        maxRouteLengthTextField.setBounds(10, 90, Index.buttonWidth, Index.buttonHeight);

        JTextField speedTextField = new JTextField("speed");
        speedTextField.setBounds(10, 130, Index.buttonWidth, Index.buttonHeight);

        JButton addButton = new JButton("add new");
        addButton.setBounds(10, 170, Index.buttonWidth, Index.buttonHeight);

        JTextField shipIdTextField = new JTextField("ship Id");
        shipIdTextField.setBounds(210, 10, Index.buttonWidth, Index.buttonHeight);

        JTextField routeIdTextField = new JTextField("route Id");
        routeIdTextField.setBounds(210, 50, Index.buttonWidth, Index.buttonHeight);

        JButton setButton = new JButton("set ship on route");
        setButton.setBounds(210, 90, Index.buttonWidth, Index.buttonHeight);

        JTextField shipToRemoveTextField = new JTextField("ship Id");
        shipToRemoveTextField.setBounds(410, 10, Index.buttonWidth, Index.buttonHeight);

        JButton putFromRouteButton = new JButton("put out from route");
        putFromRouteButton.setBounds(410, 50, Index.buttonWidth, Index.buttonHeight);

        JButton deleteButton = new JButton("delete ship");
        deleteButton.setBounds(410, 90, Index.buttonWidth, Index.buttonHeight);

        JButton exitButton = new JButton("Exit");
        exitButton.setBounds(410, 170, Index.buttonWidth, Index.buttonHeight);
        exitButton.addActionListener(e -> this.setVisible(false));

        panel.add(nameTextField);
        panel.add(payloadTextField);
        panel.add(maxRouteLengthTextField);
        panel.add(speedTextField);
        panel.add(addButton);
        panel.add(shipIdTextField);
        panel.add(routeIdTextField);
        panel.add(setButton);
        panel.add(shipToRemoveTextField);
        panel.add(putFromRouteButton);
        panel.add(deleteButton);
        panel.add(exitButton);
        this.getContentPane().add(panel);
        this.setVisible(false);
    }
}
