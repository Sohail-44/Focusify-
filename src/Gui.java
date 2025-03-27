import java.awt.*;
import javax.swing.*;

public class Gui {


   public static void launchapp(){
        // JFrame
        JFrame frame = new JFrame("VisionVault");
        frame.setFont(new Font("Helvetica", Font.BOLD, 40));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.setBackground(Color.ORANGE);

        // Jpanel
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(Color.white);
        frame.add(panel);

        // Cvertical panel for Welcome Label, SubText, and Image
        JPanel verticalPanel = new JPanel();
        verticalPanel.setLayout(new BoxLayout(verticalPanel, BoxLayout.Y_AXIS));
        verticalPanel.setBackground(Color.WHITE);
        panel.add(verticalPanel, BorderLayout.CENTER);

        // Welcome Label (Centered)
        JLabel welcomelabel = new JLabel("Welcome!", SwingConstants.CENTER);
        welcomelabel.setFont(new Font("Ariel", Font.BOLD, 20));

        // Add some space above the Welcome label
        welcomelabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        verticalPanel.add(Box.createVerticalStrut(10)); // Vertical Strut creates an invisible height component.
        verticalPanel.add(welcomelabel);

        // Subtext Label (Centered)
        JLabel subText = new JLabel("Get the most out of everyday with VisionVault!", SwingConstants.CENTER);
        subText.setFont(new Font("Ariel", Font.ITALIC, 18));
        subText.setForeground(Color.BLACK);

        // Add some space above the subtext
        subText.setAlignmentX(Component.CENTER_ALIGNMENT);
        verticalPanel.add(Box.createVerticalStrut(12));  // Space above the subtext
        verticalPanel.add(subText);

        // Image of Brian Tracy as an Icon
        ImageIcon BrianTracy = new ImageIcon("src/BrianT.jpg");

        // Resizing the image
        Image image = BrianTracy.getImage();
        Image scaledImage = image.getScaledInstance(1200, 800, Image.SCALE_SMOOTH);
        ImageIcon resizedImage = new ImageIcon(scaledImage);

        // Adding the image below the subtext (Centered)
        JLabel BrianTsImage = new JLabel(resizedImage, SwingConstants.CENTER);
        BrianTsImage.setAlignmentX(Component.CENTER_ALIGNMENT);
        verticalPanel.add(Box.createVerticalStrut(14));  // Space between the image and subtext
        verticalPanel.add(BrianTsImage);

        // Adding spacing between the image and the button
        verticalPanel.add(Box.createVerticalStrut(20)); // Adds 20px space above the button

        // Button
        JButton getStartedButton = new JButton("Let's Get Started");
        getStartedButton.setFont(new Font("Georgia", Font.PLAIN, 18));
        getStartedButton.setForeground(Color.WHITE); // White text
        getStartedButton.setBackground(new Color(255, 165, 0)); // Modern orange background
        getStartedButton.setFocusPainted(false); // Remove focus outline
        getStartedButton.setBorder(BorderFactory.createLineBorder(new Color(255, 140, 0), 2)); // Optional thin border

        // Rounded corners
        getStartedButton.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20)); // Padding inside button
        getStartedButton.setContentAreaFilled(false);
        getStartedButton.setOpaque(true);

        // Add hover effect using a MouseListener
        getStartedButton.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent e) {
                getStartedButton.setBackground(new Color(255, 140, 0)); // Darker orange on hover
            }

            @Override
            public void mouseExited(java.awt.event.MouseEvent e) {
                getStartedButton.setBackground(new Color(255, 165, 0)); // Original orange
            }
        });

        // Center the button and add spacing
        verticalPanel.add(Box.createVerticalStrut(20)); // Space above the button
        getStartedButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        verticalPanel.add(getStartedButton);

        // Add action listener for the button to trigger user interaction
        getStartedButton.addActionListener(e -> UserInteraction.userinteraction(frame));

        // Animating the welcome label through timer
        Timer animationTimer = new Timer(500, e -> {
            if (welcomelabel.getForeground().equals(Color.orange)) {
                welcomelabel.setForeground(Color.cyan);
            } else {
                welcomelabel.setForeground(Color.orange);
            }
        });
        animationTimer.start();

        // Set the frame visibility to true after adding components
        frame.setVisible(true);
    }
}

