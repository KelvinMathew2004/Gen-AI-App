package ui.tabs;

import javax.swing.*;
import utilities.TextAreaMaker;

public class DrawTabComponents {
    private JComboBox<String> modelDropdown;
    private JTextArea userPromptArea;
    private JTextField sizeField;
    private JTextField netIdField;

    public DrawTabComponents() {
        // Initialize shared components
        String[] modelOptions = {"dall-e-3", "dall-e-2"};
        modelDropdown = new JComboBox<>(modelOptions);
        modelDropdown.setSelectedItem("dall-e-3");

        userPromptArea = TextAreaMaker.createWrappedTextArea(
                "Create a stunning mystical mountain landscape with tall snowy peaks and dense forests in the epic style of Bob Ross.",
                3, 30);
        sizeField = new JTextField("1024x1024", 20);
        netIdField = new JTextField("dha25", 20);
        sizeField.setEditable(false);
        netIdField.setEditable(false);
    }

    public JComboBox<String> getModelDropdown() {
        return modelDropdown;
    }

    public JTextArea getUserPromptArea() {
        return userPromptArea;
    }

    public JTextField getSizeField() {
        return sizeField;
    }

    public JTextField getNetIdField() {
        return netIdField;
    }

}