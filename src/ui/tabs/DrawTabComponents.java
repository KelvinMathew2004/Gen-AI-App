package ui.tabs;

import javax.swing.*;
import utilities.TextAreaMaker;

public class DrawTabComponents {
    private JTextField modelField;
    private JTextArea userPromptArea;
    private JTextField sizeField;
    private JTextField netIdField;

    public DrawTabComponents() {
        // Initialize shared components
        modelField = new JTextField("dall-e-3", 20);
        userPromptArea = TextAreaMaker.createWrappedTextArea(
                "Create a stunning mystical mountain landscape with tall snowy peaks and dense forests in the epic style of Bob Ross.",
                3, 30);
        sizeField = new JTextField("1024x1024", 20);
        netIdField = new JTextField("dha25", 20);
        sizeField.setEditable(false);
        netIdField.setEditable(false);
    }

    public JTextField getModelField() {
        return modelField;
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