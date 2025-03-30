package ui.panels;

import java.awt.*;
import javax.swing.*;
import java.net.URL;

public class ImagePanel extends JPanel {
    private static URL imageUrl;

    static {
        // Load image from resources directory
        imageUrl = ImagePanel.class.getClassLoader().getResource("resources/TeslaBugsInClassRoom.png");
        if (imageUrl == null) {
            throw new IllegalArgumentException("Image not found in resources");
        }
    }

    public static void setImage(String newImageUrl) {
        try {
            imageUrl = new URL(newImageUrl);
            SwingUtilities.invokeLater(() -> {
                // Repaint all instances of ImagePanel and its parent container
                for (Window window : Window.getWindows()) {
                    for (Component comp : window.getComponents()) {
                        if (comp instanceof ImagePanel) {
                            comp.revalidate(); // Revalidate to ensure layout is updated
                            comp.repaint();    // Repaint to update the image
                            if (comp.getParent() != null) {
                                comp.getParent().revalidate(); // Ensure the parent container is updated
                                comp.getParent().repaint();    // Repaint the parent as well
                            }
                        }
                    }
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        try {
            if (imageUrl == null) {
                return;
            }
            Image image = new ImageIcon(imageUrl).getImage();

            // Scale image to be 2/3 the size of the width and centered.
            double scaleFactor = (2.0 / 3) * getWidth() / image.getWidth(null);
            int imageWidth = (int) (scaleFactor * image.getWidth(null));
            int imageHeight = (int) (scaleFactor * image.getHeight(null));
            // Compute the left edge to center the image
            int imageLeftEdge = (getWidth() - imageWidth) / 2;
            g.drawImage(image, imageLeftEdge, 0, imageWidth, imageHeight, this);

            // Adjust panel size to match the image height
            setPreferredSize(new Dimension(imageWidth, imageHeight));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
