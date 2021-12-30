package com.Ivan.Pomelnikov.TP.SpaceManager.GUI;

import com.Ivan.Pomelnikov.TP.SpaceManager.entity.ModelEntity;
import com.Ivan.Pomelnikov.TP.SpaceManager.entity.RoutesEntity;
import com.Ivan.Pomelnikov.TP.SpaceManager.entity.ShipsEntity;
import com.Ivan.Pomelnikov.TP.SpaceManager.service.ModelService;
import com.Ivan.Pomelnikov.TP.SpaceManager.service.RoutesService;
import com.Ivan.Pomelnikov.TP.SpaceManager.service.ShipsService;
import org.springframework.context.ApplicationContext;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;
import java.util.List;

public class Index extends JFrame {
    static int buttonWidth = 195;
    static int buttonHeight = 30;
    static int tableWidth = 600;
    static int tableHeight = 140;

    private static Object[] shipsHeader = new String[] {"id", "model", "route", "time", "circulation"};
    private static Object[] routesHeader = new String[] {"id", "point A", "point B", "length", "ships", "circulation"};
    private static Object[] modelHeader = new String[] {"name", "payload", "max route length", "speed"};

    public Index(ApplicationContext context) {
        super("Space Manager");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(635, 330);

        final ModelFrame modelFrame = new ModelFrame(context);
        final RoutesFrame routesFrame = new RoutesFrame(context);
        final ShipsFrame shipsFrame = new ShipsFrame(context);

        JPanel panel = new JPanel();
        panel.setLayout(null);

        JLabel label = new JLabel("Space Manager", SwingConstants.CENTER);
        label.setFont(new Font(null, Font.BOLD, 76));
        label.setBounds(10, 10, tableWidth, tableHeight);

        JButton shipsViewButton = new JButton("View ships");
        shipsViewButton.setBounds(10, 160, buttonWidth, buttonHeight);
        shipsViewButton.addActionListener(e -> {
            ShipsService shipsService = context.getBean(ShipsService.class);
            List<ShipsEntity> shipsEntityList = shipsService.findAll();
            Object[][] array = new Object[shipsEntityList.size()][5];
            for (int i = 0; i < shipsEntityList.size(); i++) {
                array[i][0] =  shipsEntityList.get(i).getId();
                array[i][1] =  shipsEntityList.get(i).getModel();
                if (shipsEntityList.get(i).getRoute() != null) {
                    array[i][2] =  shipsEntityList.get(i).getRoute().getId();
                }
                array[i][3] =  shipsEntityList.get(i).getTimeOnRoute();
                array[i][4] =  shipsEntityList.get(i).getCirculation();
            }
            JTable table = new JTable(array, shipsHeader);
            table.setVisible(true);
            JScrollPane tableScrollPane = new JScrollPane(table);
            tableScrollPane.setBounds(10, 10, tableWidth, tableHeight);
            panel.add(tableScrollPane);
            label.setVisible(false);
        });

        JButton routesViewButton = new JButton("View routes");
        routesViewButton.setBounds(210, 160, buttonWidth, buttonHeight);
        routesViewButton.addActionListener(e -> {
            RoutesService routesService = context.getBean(RoutesService.class);
            List<RoutesEntity> routesEntityList = routesService.findAll();
            Object[][] array = new Object[routesEntityList.size()][6];
            for (int i = 0; i < routesEntityList.size(); i++) {
                array[i][0] =  routesEntityList.get(i).getId();
                array[i][1] =  routesEntityList.get(i).getAPoint();
                array[i][2] =  routesEntityList.get(i).getBPoint();
                array[i][3] =  routesEntityList.get(i).getRouteLength();
                if (routesEntityList.get(i).getShipsOnRoute() != null){
                    StringBuilder stringBuilder = new StringBuilder();
                    for (int j = 0; j < routesEntityList.get(i).getShipsOnRoute().size(); j++){
                        stringBuilder.append(routesEntityList.get(i).getShipsOnRoute().toArray()[j]);
                        stringBuilder.append(" ");
                    }
                    array[i][4] = stringBuilder.toString();
                }
                array[i][5] =  routesEntityList.get(i).getCirculation();
            }
            JTable table = new JTable(array, routesHeader);
            table.setVisible(true);
            JScrollPane tableScrollPane = new JScrollPane(table);
            tableScrollPane.setBounds(10, 10, tableWidth, tableHeight);
            panel.add(tableScrollPane);
            label.setVisible(false);
        });

        JButton modelViewButton = new JButton("View models");
        modelViewButton.setBounds(410, 160, buttonWidth, buttonHeight);
        modelViewButton.addActionListener(e -> {
            ModelService modelService = context.getBean(ModelService.class);
            List<ModelEntity> modelEntityList = modelService.findAll();
            Object[][] array = new Object[modelEntityList.size()][5];
            for (int i = 0; i < modelEntityList.size(); i++) {
                array[i][0] =  modelEntityList.get(i).getName();
                array[i][1] =  modelEntityList.get(i).getPayload();
                array[i][2] =  modelEntityList.get(i).getMaxRouteLength();
                array[i][3] =  modelEntityList.get(i).getSpeed();
            }
            JTable table = new JTable(array, modelHeader);
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