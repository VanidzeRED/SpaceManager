package com.Ivan.Pomelnikov.TP.SpaceManager.GUI;

import com.Ivan.Pomelnikov.TP.SpaceManager.dto.ModelDto;
import com.Ivan.Pomelnikov.TP.SpaceManager.service.ModelService;
import org.springframework.context.ApplicationContext;

import javax.swing.*;

public class ModelFrame extends JFrame {

    private ModelService modelService;

    public ModelFrame(ApplicationContext context) {
        super("Model Manager");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(430, 250);
        this.modelService = context.getBean(ModelService.class);

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
        addButton.addActionListener(e -> {
            ModelDto modelDto = new ModelDto();
            modelDto.setName(nameTextField.getText());
            modelDto.setPayload(Double.parseDouble(payloadTextField.getText()));
            modelDto.setMaxRouteLength(Double.parseDouble(maxRouteLengthTextField.getText()));
            modelDto.setSpeed(Double.parseDouble(speedTextField.getText()));
            modelService.addModel(modelDto);
        });

        JTextField modelToRemoveTextField = new JTextField("madel name");
        modelToRemoveTextField.setBounds(210, 10, Index.buttonWidth, Index.buttonHeight);

        JButton deleteButton = new JButton("delete model");
        deleteButton.setBounds(210, 50, Index.buttonWidth, Index.buttonHeight);
        deleteButton.addActionListener(e -> {
            ModelDto modelDto = new ModelDto();
            modelDto.setName(nameTextField.getText());
            modelDto.setPayload(Double.parseDouble(payloadTextField.getText()));
            modelDto.setMaxRouteLength(Double.parseDouble(maxRouteLengthTextField.getText()));
            modelDto.setSpeed(Double.parseDouble(speedTextField.getText()));
            modelService.deleteByName(modelDto);
        });

        JButton exitButton = new JButton("Exit");
        exitButton.setBounds(210, 170, Index.buttonWidth, Index.buttonHeight);
        exitButton.addActionListener(e -> this.setVisible(false));

        panel.add(nameTextField);
        panel.add(payloadTextField);
        panel.add(maxRouteLengthTextField);
        panel.add(speedTextField);
        panel.add(addButton);
        panel.add(modelToRemoveTextField);
        panel.add(deleteButton);
        panel.add(exitButton);
        this.getContentPane().add(panel);
        this.setVisible(false);
    }
}
