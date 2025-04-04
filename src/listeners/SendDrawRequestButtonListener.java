package listeners;
import ui.panels.ImagePanel;

import apiOperations.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JTextArea;

public class SendDrawRequestButtonListener implements ActionListener {
    private ImagePanel imagePanel;
    private JComboBox<String> modelDropdown;
    private JTextArea userPromptArea;
    private String apiKey;

    public SendDrawRequestButtonListener(ImagePanel imagePanel, JComboBox<String> modelDropdown, JTextArea userPromptArea, String apiKey) {
        this.imagePanel = imagePanel;
        this.modelDropdown = modelDropdown;
        this.userPromptArea = userPromptArea;
        this.apiKey = apiKey;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String gptModel = (String) modelDropdown.getSelectedItem();
        String userPrompt = userPromptArea.getText();

        DrawCompletions drawCompletions = new DrawCompletions(apiKey, gptModel, userPrompt);
        try {
            String imageURL = drawCompletions.execute("https://api.openai.com/v1/images/generations");
            imagePanel.setImage(imageURL);
            imagePanel.setPreferredSize(new Dimension(1024, 1024));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}