package ui.panels;

import java.awt.*;
import javax.swing.*;
import listeners.SendChatButtonListener;

public class DrawContentPanel extends AbstractContentPanel {
    public DrawContentPanel(
            JTextField modelField,
            JTextArea userPromptArea,
            String apiKey) {

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5); // Add padding around components
        gbc.fill = GridBagConstraints.HORIZONTAL;

        int row = 0;

        addLabelAndTextComponent("Model:", modelField, gbc, row++);
        addLabelAndTextComponent("User Prompt:", userPromptArea, gbc, row++);

        // Create a send-chat listener
        SendDrawButtonListener listener = new SendDrawButtonListener(
                modelField, userPromptArea, apiKey);

        addButton("Send to OpenAI", listener, gbc, row++);
    }

}