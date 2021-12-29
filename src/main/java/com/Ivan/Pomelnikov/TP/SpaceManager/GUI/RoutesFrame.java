package com.Ivan.Pomelnikov.TP.SpaceManager.GUI;

import com.Ivan.Pomelnikov.TP.SpaceManager.dto.RoutesDto;
import com.Ivan.Pomelnikov.TP.SpaceManager.service.RoutesService;
import org.springframework.context.ApplicationContext;

import javax.swing.*;

public class RoutesFrame extends JFrame {

    private RoutesService routesService;

    public RoutesFrame(ApplicationContext context) {
        super("Routes Manager");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(430, 250);
        this.routesService = context.getBean(RoutesService.class);

        JPanel panel = new JPanel();
        panel.setLayout(null);

        JTextField idTextField = new JTextField("id");
        idTextField.setBounds(10, 10, Index.buttonWidth, Index.buttonHeight);

        JTextField pointATextField = new JTextField("route point A");
        pointATextField.setBounds(10, 50, Index.buttonWidth, Index.buttonHeight);

        JTextField pointBTextField = new JTextField("route point B");
        pointBTextField.setBounds(10, 90, Index.buttonWidth, Index.buttonHeight);

        JTextField lengthTextField = new JTextField("route length");
        lengthTextField.setBounds(10, 130, Index.buttonWidth, Index.buttonHeight);

        JButton addButton = new JButton("add new");
        addButton.setBounds(10, 170, Index.buttonWidth, Index.buttonHeight);
        addButton.addActionListener(e -> {
            RoutesDto routesDto = new RoutesDto();
            routesDto.setId(Long.valueOf(idTextField.getText()));
            routesDto.setAPoint(pointATextField.getText());
            routesDto.setBPoint(pointBTextField.getText());
            routesDto.setRouteLength(Double.parseDouble(lengthTextField.getText()));
            routesService.addRoute(routesDto);
        });

        JTextField removeTextField = new JTextField("route id");
        removeTextField.setBounds(210, 10, Index.buttonWidth, Index.buttonHeight);

        JButton deleteButton = new JButton("delete route");
        deleteButton.setBounds(210, 50, Index.buttonWidth, Index.buttonHeight);
        deleteButton.addActionListener(e -> {
            RoutesDto routesDto = new RoutesDto();
            routesDto.setId(Long.valueOf(idTextField.getText()));
            routesDto.setAPoint(pointATextField.getText());
            routesDto.setBPoint(pointBTextField.getText());
            routesDto.setRouteLength(Double.parseDouble(lengthTextField.getText()));
            routesService.deleteById(routesDto);
        });

        JButton exitButton = new JButton("Exit");
        exitButton.setBounds(210, 170, Index.buttonWidth, Index.buttonHeight);
        exitButton.addActionListener(e -> this.setVisible(false));

        panel.add(idTextField);
        panel.add(pointATextField);
        panel.add(pointBTextField);
        panel.add(lengthTextField);
        panel.add(addButton);
        panel.add(removeTextField);
        panel.add(deleteButton);
        panel.add(exitButton);
        this.getContentPane().add(panel);
        this.setVisible(false);
    }
}
