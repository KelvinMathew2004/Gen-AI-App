package ui.tabs;

import java.awt.*;
import javax.swing.*;

import ui.panels.ImagePanel;
import ui.panels.DrawContentPanel;

public class DrawTab extends AbstractCreateTab {
    private final JTextField modelField;
    private final JTextArea userPromptArea;
    private final String apiKey;

    public DrawTab(JTextField modelField, JTextArea userPromptArea, String apiKey) {
        this.modelField = modelField;
        this.userPromptArea = userPromptArea;
        this.apiKey = apiKey;
    }

    @Override
    public JPanel createTab() {
        JPanel drawPanel = new JPanel(new BorderLayout());

        // Add image panel at the top
        JPanel imagePanel = new ImagePanel();

        imagePanel.setPreferredSize(new Dimension(400, 380));
        drawPanel.add(imagePanel, BorderLayout.NORTH);

        // Add main content panel
        drawPanel.add(new DrawContentPanel(modelField, userPromptArea, apiKey), BorderLayout.CENTER);

        return drawPanel;
    }
}
