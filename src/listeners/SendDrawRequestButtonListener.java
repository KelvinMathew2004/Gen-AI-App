package listeners;
import ui.panels.ImagePanel;

import apiOperations.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.net.URL;

public class SendDrawRequestButtonListener implements ActionListener {
    private JTextField modelField;
    private JTextArea userPromptArea;
    private String apiKey;

    public SendDrawButtonListener(JTextField modelField, JTextArea userPromptArea, String apiKey) {
        this.modelField = modelField;
        this.userPromptArea = userPromptArea;
        this.apiKey = apiKey;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String gptModel = modelField.getText();
        String userPrompt = userPromptArea.getText();

        DrawCompletions drawCompletions = new DrawCompletions(apiKey, gptModel, userPrompt);
        try {
            String imageURL = drawCompletions.execute("https://api.openai.com/v1/chat/completions");
            ImagePanel.setImage(imageURL);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}