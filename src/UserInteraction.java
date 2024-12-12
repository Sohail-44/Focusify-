import javax.swing.*;
import javax.swing.border.Border;

import java.awt.*;
import java.util.Map;
import java.util.HashMap;

public class UserInteraction {
    private String mostProductiveTime;
    private String mediumProductiveTime;
    private String leastProductiveTime;

    public static void userinteraction(JFrame frame) {
        frame.getContentPane().setBackground(new Color(255, 253, 208));
        JPanel mainPanel = new JPanel(new GridLayout(1, 2, 20, 0));
        mainPanel.setBackground(new Color(255, 230, 208));

        JPanel leftPanel = new JPanel();
        leftPanel.setLayout(new BoxLayout(leftPanel, BoxLayout.Y_AXIS));
        leftPanel.setBackground(new Color(255, 230, 208));

        JLabel instructionLabel = new JLabel("Enter your top 6 goals and tasks for tommorow:");
        instructionLabel.setFont(new Font("Segoe UI", Font.BOLD, 25));
        instructionLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        instructionLabel.setForeground(new Color(102, 0, 153));
        instructionLabel.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(new Color(255, 102, 0), 2),
        BorderFactory.createEmptyBorder(5, 10, 5, 10)));
        instructionLabel.setOpaque(true);
        leftPanel.add(Box.createRigidArea(new Dimension(0, 50)));
        leftPanel.add(instructionLabel);
        leftPanel.add(Box.createRigidArea(new Dimension(50, 100)));

        JPanel goalTaskPanel = new JPanel(new GridBagLayout());
        goalTaskPanel.setBackground(new Color(255, 230, 208));
        GridBagConstraints gbc = new GridBagConstraints();

        JLabel goalsLabel = new JLabel("Goals");
        goalsLabel.setFont(new Font("Segoe UI", Font.BOLD, 16));
        goalsLabel.setForeground(new Color(0, 102, 204));

        JLabel priorityLabel = new JLabel("Priority");
        priorityLabel.setFont(new Font("Segoe UI", Font.BOLD, 16));
        priorityLabel.setForeground(new Color(0, 102, 204));

        JLabel tasksLabel = new JLabel("Tasks");
        tasksLabel.setFont(new Font("Segoe UI", Font.BOLD, 16));
        tasksLabel.setForeground(new Color(0, 102, 204));

        JLabel durationLabel = new JLabel("Duration");
        durationLabel.setFont(new Font("Segoe UI", Font.BOLD, 16));
        durationLabel.setForeground(new Color(0, 102, 204));

        gbc.insets = new Insets(10, 20, 10, 20);
        gbc.gridx = 0; gbc.gridy = 0;
        goalTaskPanel.add(goalsLabel, gbc);

        gbc.gridx = 1;
        goalTaskPanel.add(priorityLabel, gbc);

        gbc.gridx = 4;
        goalTaskPanel.add(tasksLabel, gbc);

        gbc.gridx = 5;
        goalTaskPanel.add(durationLabel, gbc);

        JTextField[] goalFields = new JTextField[6];
        JTextField[][] taskFields = new JTextField[6][2];
        JComboBox<String>[] priorityCombos = new JComboBox[6];
        JComboBox<String>[][] durationCombos = new JComboBox[6][2];

        String[] priorities = {"Highest Priority", "High Priority", "Nice to Do"};
        String[] durations = {"15 mins", "30 mins", "45 mins", "60 mins", "75 mins", "90 mins", "105 mins", "120 mins"};

        for (int i = 0; i < 6; i++) {
            gbc.gridy = i * 4 + 1;
            gbc.gridx = 0;
            gbc.anchor = GridBagConstraints.EAST;
            goalTaskPanel.add(new JLabel("Goal " + (i + 1) + ":"), gbc);

            gbc.gridy++;
            gbc.anchor = GridBagConstraints.CENTER;
            goalFields[i] = createStyledTextField(210, 60);
            goalTaskPanel.add(goalFields[i], gbc);

            gbc.gridx = 1;
            gbc.gridy--;
            priorityCombos[i] = new JComboBox<>(priorities);
            priorityCombos[i].setFont(new Font("Segoe UI", Font.PLAIN, 14));
            goalTaskPanel.add(priorityCombos[i], gbc);

            gbc.gridx = 2;
            gbc.gridwidth = 4;
            gbc.gridheight = 4;
            JPanel tasksPanel = new JPanel(new GridLayout(2, 2, 10, 10));
            for (int j = 0; j < 2; j++) {
                taskFields[i][j] = createStyledTextField(150, 50);
                tasksPanel.add(taskFields[i][j]);

                durationCombos[i][j] = new JComboBox<>(durations);
                durationCombos[i][j].setFont(new Font("Segoe UI", Font.PLAIN, 14));
                tasksPanel.add(durationCombos[i][j]);
            }
            goalTaskPanel.add(tasksPanel, gbc);
            gbc.gridwidth = 1;
            gbc.gridheight = 1;
        }

        leftPanel.add(goalTaskPanel);

        JPanel rightPanel = new JPanel();
        rightPanel.setLayout(new BoxLayout(rightPanel, BoxLayout.Y_AXIS));
        rightPanel.setBackground(new Color(255, 230, 208));

        JLabel productiveTimeLabel = new JLabel("Productive Times:");
        productiveTimeLabel.setFont(new Font("Segoe UI", Font.BOLD, 18));
        productiveTimeLabel.setForeground(new Color(0, 102, 204));
        productiveTimeLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        rightPanel.add(productiveTimeLabel);
        rightPanel.add(Box.createRigidArea(new Dimension(0, 10)));

        String[] timeLabels = {"Most Productive Time:", "Medium Productive Time:", "Least Productive Time:"};
        JTextField[] timeFields = new JTextField[3];

        for (int i = 0; i < timeLabels.length; i++) {
            JLabel label = new JLabel(timeLabels[i]);
            label.setFont(new Font("Segoe UI", Font.PLAIN, 14));
            label.setAlignmentX(Component.CENTER_ALIGNMENT);
            rightPanel.add(label);

            timeFields[i] = createStyledTextField(200, 50);
            timeFields[i].setAlignmentX(Component.CENTER_ALIGNMENT);
            rightPanel.add(timeFields[i]);
            rightPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        }

        ImageIcon brianplan = new ImageIcon("src/Brianonplanning.jpg");
        Image scaledImage = brianplan.getImage().getScaledInstance(800, -1, Image.SCALE_SMOOTH);
        JLabel imageLabel = new JLabel(new ImageIcon(scaledImage));
        imageLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        rightPanel.add(Box.createRigidArea(new Dimension(0, 20)));
        rightPanel.add(imageLabel);

        JButton submitButton = createStyledButton("Submit");
        submitButton.setFont(new Font("Segoe UI", Font.BOLD, 28));
        submitButton.setPreferredSize(new Dimension(300, 70));
        submitButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        submitButton.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseEntered(java.awt.event.MouseEvent evt) {
        submitButton.setBackground(new Color(0, 150, 255));
        submitButton.setForeground(Color.WHITE);
    }

    public void mouseExited(java.awt.event.MouseEvent evt) {
        submitButton.setBackground(new Color(0, 123, 255));
        submitButton.setForeground(new Color(255, 153, 0));
    }
});
    submitButton.addActionListener(e -> {
    UserInteraction ui = new UserInteraction();
    ui.mostProductiveTime = timeFields[0].getText();
    ui.mediumProductiveTime = timeFields[1].getText();
    ui.leastProductiveTime = timeFields[2].getText();

    Map<String, Map<String, Integer>> taskDetails = new HashMap<>();
    for (int i = 0; i < goalFields.length; i++) {
        String goal = goalFields[i].getText();
        String priority = (String) priorityCombos[i].getSelectedItem();
        if (!goal.isEmpty()) {
            Map<String, Integer> taskTime = new HashMap<>();
            for (int j = 0; j < taskFields[i].length; j++) {
                String task = taskFields[i][j].getText();
                if (!task.isEmpty()) {
                    String duration = (String) durationCombos[i][j].getSelectedItem();
                    int minutes = Integer.parseInt(duration.split(" ")[0]);
                    taskTime.put(task, minutes);
                }
            }
            if (!taskTime.isEmpty()) {
                taskDetails.put(goal + " (" + priority + ")", taskTime);
            }
        }
    }
    ui.displaySchedule(frame, taskDetails);
});


        rightPanel.add(Box.createVerticalGlue());
        rightPanel.add(submitButton);
        rightPanel.add(Box.createRigidArea(new Dimension(0, 100)));

        mainPanel.add(leftPanel);
        mainPanel.add(rightPanel);

        frame.getContentPane().removeAll();
        frame.getContentPane().add(mainPanel);
        frame.revalidate();
        frame.repaint();
    }

    

    public void  displaySchedule(JFrame frame, Map<String, Map<String, Integer>> taskDetails) {
        
      StringBuilder schedule = new StringBuilder("<html><body style='width:300px'>");
      schedule.append("<h2 style='color:#333333;'>My Tomorrow's Schedule:</h2>");
      schedule.append("<h3 style='color:#4CAF50;'>Most Productive Time: ").append(mostProductiveTime).append("</h3>");
      appendTasksToSchedule(schedule, taskDetails,"Highest Priority");
      schedule.append("<h3 style='color:#FFA500;'>Medium Productive Time: ").append(mediumProductiveTime).append("</h3>");
      appendTasksToSchedule(schedule ,taskDetails,"High Priority");
      schedule.append("<h3 style='color:#3F51B5;'>Least Productive Time: ").append(leastProductiveTime).append("</h3>");
      appendTasksToSchedule(schedule ,taskDetails,"Nice to Do");
      schedule.append("</body></html>");

      JPanel schedulePanel= new JPanel();
      schedulePanel.setLayout(new BoxLayout(schedulePanel ,BoxLayout.Y_AXIS));
      JLabel scheduleLabel= new JLabel(schedule.toString());
      schedulePanel.add(scheduleLabel);

      JButton startWorkingButton= createStyledButton("Let's Start Working");
      startWorkingButton.setAlignmentX(Component.CENTER_ALIGNMENT);
      startWorkingButton.addActionListener(e -> {
        PomodoroTimer pomodoroTimer = new PomodoroTimer();
        pomodoroTimer.setVisible(true);
    });
      schedulePanel.add(Box.createRigidArea(new Dimension(0 ,20)));
      schedulePanel.add(startWorkingButton);

      JOptionPane.showMessageDialog(frame ,schedulePanel ,"My Personalized Schedule" ,JOptionPane.PLAIN_MESSAGE);
      
      
    }

    private void appendTasksToSchedule(StringBuilder schedule ,Map<String ,Map<String ,Integer>> taskDetails ,String priority) {
      taskDetails.forEach((goal ,tasks) -> {
          if (goal.contains(priority)) {
              schedule.append("<p><b>").append(goal).append("</b></p>");
              tasks.forEach((task ,time) -> {
                  schedule.append("<p>• ").append(task).append(" - ").append(time).append(" minutes</p>");
              });
          }
      });
    }

    private static JTextField createStyledTextField(int width ,int height) {
      JTextField field= new JTextField();
      field.setFont(new Font("Segoe UI" ,Font.PLAIN ,14));
      field.setBackground(Color.WHITE);
      field.setBorder(BorderFactory.createCompoundBorder(
          BorderFactory.createLineBorder(new Color(255 ,102 ,0)),
          BorderFactory.createEmptyBorder(2 ,5 ,2 ,5)
      ));
      
      field.setPreferredSize(new Dimension(width ,height));
      field.setMaximumSize(field.getPreferredSize());
      
      return field;
    }

    private static JButton createStyledButton(String text) {
        JButton button = new JButton(text);
        button.setFont(new Font("Segoe UI", Font.BOLD, 18));
        button.setForeground(new Color(255, 153, 0));
        button.setBackground(new Color(0, 123, 255));
        button.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createRaisedBevelBorder(),
            BorderFactory.createEmptyBorder(10, 20, 10, 20)
        ));
        button.setFocusPainted(false);
        button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        return button;
    }

    // Image of Brian Tracy as an Icon
    ImageIcon brianplan = new ImageIcon("src/Brianonplanning.jpg");

    
}