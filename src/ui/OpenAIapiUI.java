package ui;

import javax.swing.*;

import apiOperations.ApiKeyLoader;
import ui.tabs.ChatTab;
import ui.tabs.ChatTabComponents;
import ui.tabs.DrawTab;
import ui.tabs.DrawTabComponents;

public class OpenAIapiUI extends JFrame {
    private String apiKey;

    public OpenAIapiUI() {
        // Load API key from .env file
        apiKey = ApiKeyLoader.loadApiKey();

        // Set up UI
        setTitle("OpenAI Chat Example");
        setSize(800, 1200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create tabbed pane
        JTabbedPane tabbedPane = new JTabbedPane();

        // Create ChatTab components
        ChatTabComponents chatComponents = new ChatTabComponents();

        // Create DrawTab components
        DrawTabComponents drawComponents = new DrawTabComponents();

        // Add "Chat" tab
        ChatTab chatTab = new ChatTab(
                chatComponents.getModelField(),
                chatComponents.getMaxTokensField(),
                chatComponents.getSystemPersonalityArea(),
                chatComponents.getUserPromptArea(),
                chatComponents.getResponseArea(),
                apiKey);
        JScrollPane chatScrollPane = new JScrollPane(chatTab.createTab());
        tabbedPane.addTab("Chat", chatScrollPane);

        // Add "Draw" tab
        DrawTab drawTab = new DrawTab(
            drawComponents.getModelDropdown(),
            drawComponents.getUserPromptArea(),
            drawComponents.getSizeField(),
            drawComponents.getNetIdField(),
            apiKey);
        JScrollPane drawScrollPane = new JScrollPane(drawTab.createTab());
        tabbedPane.addTab("Draw", drawScrollPane);

        // Add the tabbed pane to the frame
        add(tabbedPane);

        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(OpenAIapiUI::new);
    }
}
