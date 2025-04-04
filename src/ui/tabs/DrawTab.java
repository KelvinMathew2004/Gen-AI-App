package ui.tabs;

import java.awt.*;
import javax.swing.*;

import ui.panels.ImagePanel;
import ui.panels.DrawContentPanel;

public class DrawTab extends AbstractCreateTab {
    private final JComboBox<String> modelDropdown;
    private final JTextArea userPromptArea;
    private final JTextField sizeField;
    private final JTextField netIdField;
    private final String apiKey;

    public DrawTab(JComboBox<String> modelDropdown, JTextArea userPromptArea, JTextField sizeField, JTextField netIdField, String apiKey) {
        this.modelDropdown = modelDropdown;
        this.userPromptArea = userPromptArea;
        this.apiKey = apiKey;
        this.sizeField = sizeField;
        this.netIdField = netIdField;
    }

    @Override
    public JPanel createTab() {
        JPanel drawPanel = new JPanel(new BorderLayout());

        // Add image panel at the top
        ImagePanel imagePanel = new ImagePanel();

        imagePanel.setPreferredSize(new Dimension(400, 380));
        drawPanel.add(imagePanel, BorderLayout.NORTH);

        // Add main content panel
        drawPanel.add(new DrawContentPanel(imagePanel, modelDropdown, userPromptArea, sizeField, 
            netIdField, apiKey), BorderLayout.CENTER);

        // Revalidate and repaint the parent panel to ensure layout is updated when components change
        drawPanel.revalidate();
        drawPanel.repaint();

        return drawPanel;
    }

}
