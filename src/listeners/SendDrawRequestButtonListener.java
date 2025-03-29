package listeners;

import apiOperations.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class SendDrawRequestButtonListener implements ActionListener {
    private JTextField modelField;
    private JTextArea userPromptArea, responseArea;
    private String apiKey;

    public SendChatButtonListener(JTextField modelField, JTextArea userPromptArea, String apiKey) {
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
            String responseContent = drawCompletions.execute("https://api.openai.com/v1/chat/completions");
            responseArea.setText(responseContent);
        } catch (Exception ex) {
            responseArea.setText("OpenAI chat response error: " + ex.getMessage());
            ex.printStackTrace();
        }
    }
}