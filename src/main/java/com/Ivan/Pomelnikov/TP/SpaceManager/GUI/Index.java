package com.Ivan.Pomelnikov.TP.SpaceManager.GUI;

import com.Ivan.Pomelnikov.TP.SpaceManager.TableModels.ModelTableModel;
import com.Ivan.Pomelnikov.TP.SpaceManager.TableModels.RoutesTableModel;
import com.Ivan.Pomelnikov.TP.SpaceManager.TableModels.ShipsTableModel;

import javax.swing.*;
import java.awt.*;

public class Index extends JFrame {
    static int buttonWidth = 195;
    static int buttonHeight = 30;
    static int tableWidth = 600;
    static int tableHeight = 140;

    public Index() {
        super("Space Manager");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(635, 330);

        final ModelFrame modelFrame = new ModelFrame();
        final RoutesFrame routesFrame = new RoutesFrame();
        final ShipsFrame shipsFrame = new ShipsFrame();

        JPanel panel = new JPanel();
        panel.setLayout(null);

        JLabel label = new JLabel("Space Manager", SwingConstants.CENTER);
        label.setFont(new Font(null, Font.BOLD, 76));
        label.setBounds(10, 10, tableWidth, tableHeight);

        JButton shipsViewButton = new JButton("View ships");
        shipsViewButton.setBounds(10, 160, buttonWidth, buttonHeight);
        shipsViewButton.addActionListener(e -> {
            JTable table = new JTable(new ShipsTableModel());
            table.setVisible(true);
            JScrollPane tableScrollPane = new JScrollPane(table);
            tableScrollPane.setBounds(10, 10, tableWidth, tableHeight);
            panel.add(tableScrollPane);
            label.setVisible(false);
        });

        JButton routesViewButton = new JButton("View routes");
        routesViewButton.setBounds(210, 160, buttonWidth, buttonHeight);
        routesViewButton.addActionListener(e -> {
            JTable table = new JTable(new RoutesTableModel());
            table.setVisible(true);
            JScrollPane tableScrollPane = new JScrollPane(table);
            tableScrollPane.setBounds(10, 10, tableWidth, tableHeight);
            panel.add(tableScrollPane);
            label.setVisible(false);
        });

        JButton modelViewButton = new JButton("View models");
        modelViewButton.setBounds(410, 160, buttonWidth, buttonHeight);
        modelViewButton.addActionListener(e -> {
            JTable table = new JTable(new ModelTableModel());
            table.setVisible(true);
            JScrollPane tableScrollPane = new JScrollPane(table);
            tableScrollPane.setBounds(10, 10, tableWidth, tableHeight);
            panel.add(tableScrollPane);
            label.setVisible(false);
        });

        JButton shipsManageButton = new JButton("Manage ships");
        shipsManageButton.setBounds(10, 200, buttonWidth, buttonHeight);
        shipsManageButton.addActionListener(e -> shipsFrame.setVisible(true));

        JButton routesManageButton = new JButton("Manage routes");
        routesManageButton.setBounds(210, 200, buttonWidth, buttonHeight);
        routesManageButton.addActionListener(e -> routesFrame.setVisible(true));

        JButton modelManageButton = new JButton("Manage models");
        modelManageButton.setBounds(410, 200, buttonWidth, buttonHeight);
        modelManageButton.addActionListener(e -> modelFrame.setVisible(true));

        JButton exitButton = new JButton("Exit");
        exitButton.setBounds(410, 250, buttonWidth, buttonHeight);
        exitButton.addActionListener(e -> System.exit(0));

        panel.add(exitButton);
        panel.add(shipsManageButton);
        panel.add(routesManageButton);
        panel.add(modelManageButton);
        panel.add(shipsViewButton);
        panel.add(routesViewButton);
        panel.add(modelViewButton);
        panel.add(label);
        this.getContentPane().add(panel);
        this.setVisible(true);
    }
}