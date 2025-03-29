package ui.tabs;

import javax.swing.*;
import utilities.TextAreaMaker;

public class DrawTabComponents {
    private JTextField modelField;
    private JTextArea userPromptArea;

    public DrawTabComponents() {
        // Initialize shared components
        modelField = new JTextField("dall-e-3", 20);
        userPromptArea = TextAreaMaker.createWrappedTextArea(
                "Create a stunning mystical mountain landscape with tall snowy peaks and dense forests in the epic style of Bob Ross.",
                3, 30);
        // responseArea = TextAreaMaker.createWrappedTextArea("", 8, 40);
        // responseArea.setEditable(false);
    }

    public JTextField getModelField() {
        return modelField;
    }

    public JTextArea getUserPromptArea() {
        return userPromptArea;
    }

}