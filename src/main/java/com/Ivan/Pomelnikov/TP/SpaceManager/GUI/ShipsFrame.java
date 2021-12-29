package com.Ivan.Pomelnikov.TP.SpaceManager.GUI;

import com.Ivan.Pomelnikov.TP.SpaceManager.Exception.ShipOnRouteException;
import com.Ivan.Pomelnikov.TP.SpaceManager.dto.RoutesDto;
import com.Ivan.Pomelnikov.TP.SpaceManager.dto.ShipsDto;
import com.Ivan.Pomelnikov.TP.SpaceManager.entity.RoutesEntity;
import com.Ivan.Pomelnikov.TP.SpaceManager.entity.ShipsEntity;
import com.Ivan.Pomelnikov.TP.SpaceManager.service.RoutesService;
import com.Ivan.Pomelnikov.TP.SpaceManager.service.ShipsService;
import org.springframework.context.ApplicationContext;

import javax.swing.*;
import java.awt.*;

public class ShipsFrame extends JFrame {

    private ShipsService shipsService;
    private RoutesService routesService;

    public ShipsFrame(ApplicationContext context) {
        super("Ships Manager");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(630, 250);
        this.shipsService = context.getBean(ShipsService.class);
        this.routesService = context.getBean(RoutesService.class);

        JPanel panel = new JPanel();
        panel.setLayout(null);

        JLabel label = new JLabel("", SwingConstants.CENTER);
        label.setFont(new Font(null, Font.BOLD, 16));
        label.setBounds(10, 130, 610, 30);

        JTextField idTextField = new JTextField("Id");
        idTextField.setBounds(10, 10, Index.buttonWidth, Index.buttonHeight);

        JTextField modelTextField = new JTextField("model");
        modelTextField.setBounds(10, 50, Index.buttonWidth, Index.buttonHeight);

        JButton addButton = new JButton("add new");
        addButton.setBounds(10, 90, Index.buttonWidth, Index.buttonHeight);
        addButton.addActionListener(e -> {
            ShipsDto shipsDto = new ShipsDto();
            shipsDto.setId(Long.valueOf(idTextField.getText()));
            shipsDto.setModel(modelTextField.getText());
            shipsService.addShip(shipsDto);
        });

        JTextField shipIdTextField = new JTextField("ship Id");
        shipIdTextField.setBounds(210, 10, Index.buttonWidth, Index.buttonHeight);

        JTextField routeIdTextField = new JTextField("route Id");
        routeIdTextField.setBounds(210, 50, Index.buttonWidth, Index.buttonHeight);

        JButton setButton = new JButton("set ship on route");
        setButton.setBounds(210, 90, Index.buttonWidth, Index.buttonHeight);
        setButton.addActionListener(e -> {
            ShipsEntity shipsEntity = shipsService.findById(Long.valueOf(shipIdTextField.getText()));
            RoutesEntity routesEntity = routesService.findById(Long.valueOf(routeIdTextField.getText()));

            ShipsDto shipsDto = new ShipsDto();
            shipsDto.setId(shipsEntity.getId());
            shipsDto.setModel(shipsEntity.getModel());
            shipsDto.setTimeOnRoute(shipsEntity.getTimeOnRoute());
            shipsDto.setCirculation(shipsEntity.getCirculation());

            RoutesDto routesDto = new RoutesDto();
            routesDto.setId(routesEntity.getId());
            routesDto.setAPoint(routesEntity.getAPoint());
            routesDto.setBPoint(routesEntity.getBPoint());
            routesDto.setRouteLength(routesEntity.getRouteLength());
            routesDto.setCirculation(routesEntity.getCirculation());

            try {
                shipsService.setShipOnRoute(shipsDto, routesDto);
            } catch (ShipOnRouteException shipOnRouteException) {
                label.setText(shipOnRouteException.getMessage());
            }
        });

        JTextField shipToRemoveTextField = new JTextField("ship Id");
        shipToRemoveTextField.setBounds(410, 10, Index.buttonWidth, Index.buttonHeight);

        JButton putFromRouteButton = new JButton("put out from route");
        putFromRouteButton.setBounds(410, 50, Index.buttonWidth, Index.buttonHeight);
        putFromRouteButton.addActionListener(e -> {
            ShipsEntity shipsEntity = shipsService.findById(Long.valueOf(shipIdTextField.getText()));

            ShipsDto shipsDto = new ShipsDto();
            shipsDto.setId(shipsEntity.getId());
            shipsDto.setModel(shipsEntity.getModel());
            shipsDto.setTimeOnRoute(shipsEntity.getTimeOnRoute());
            shipsDto.setCirculation(shipsEntity.getCirculation());

            shipsService.removeShipFromRoute(shipsDto);
        });

        JButton deleteButton = new JButton("delete ship");
        deleteButton.setBounds(410, 90, Index.buttonWidth, Index.buttonHeight);
        deleteButton.addActionListener(e -> {
            ShipsEntity shipsEntity = shipsService.findById(Long.valueOf(shipIdTextField.getText()));

            ShipsDto shipsDto = new ShipsDto();
            shipsDto.setId(shipsEntity.getId());
            shipsDto.setModel(shipsEntity.getModel());
            shipsDto.setTimeOnRoute(shipsEntity.getTimeOnRoute());
            shipsDto.setCirculation(shipsEntity.getCirculation());

            shipsService.deleteById(shipsDto);
        });

        JButton exitButton = new JButton("Exit");
        exitButton.setBounds(410, 170, Index.buttonWidth, Index.buttonHeight);
        exitButton.addActionListener(e -> this.setVisible(false));

        panel.add(idTextField);
        panel.add(modelTextField);
        panel.add(addButton);
        panel.add(shipIdTextField);
        panel.add(routeIdTextField);
        panel.add(setButton);
        panel.add(shipToRemoveTextField);
        panel.add(putFromRouteButton);
        panel.add(deleteButton);
        panel.add(label);
        panel.add(exitButton);
        this.getContentPane().add(panel);
        this.setVisible(false);
    }
}
