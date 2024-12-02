import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class UserInteraction {
    private String mostProductiveTime;
    private String mediumProductiveTime;
    private String leastProductiveTime;

    public static void userinteraction(JFrame frame) {
        // Frame
        frame.getContentPane().setBackground(new Color(255, 253, 208));
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBackground(new Color(255, 230, 208));

        // label
        JLabel instructionLabel = new JLabel("Enter your top 6 goals for tomorrow:");
        instructionLabel.setFont(new Font("Segoe UI", Font.BOLD, 24));
        instructionLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        instructionLabel.setForeground(new Color(102, 0, 153));
        panel.add(instructionLabel);
        panel.add(Box.createRigidArea(new Dimension(0, 30)));

        // JTextField
        JTextField[] goalFields = new JTextField[6];
        for (int i = 0; i < 6; i++) {
            JTextField goalField = new JTextField();
            goalField.setFont(new Font("Segoe UI", Font.PLAIN, 18));
            goalField.setBackground(new Color(255, 255, 255));
            goalField.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(255, 102, 0)),
                BorderFactory.createEmptyBorder(5, 10, 5, 10)
            ));
            goalField.setPreferredSize(new Dimension(400, 40));
            goalField.setMaximumSize(goalField.getPreferredSize());
            panel.add(createGoalLabel("Goal " + (i + 1)));
            panel.add(goalField);
            goalFields[i] = goalField;
            panel.add(Box.createRigidArea(new Dimension(0, 20)));
        }

        // Submit Button
        JButton submitButton = createStyledButton("Submit Goals");
        submitButton.setBackground(new Color(255, 02, 102));
        submitButton.setForeground(new Color(255, 02, 102));
        submitButton.addActionListener(e -> {
            List<String> sixGoals = List.of(
                goalFields[0].getText(), goalFields[1].getText(), goalFields[2].getText(),
                goalFields[3].getText(), goalFields[4].getText(), goalFields[5].getText()
            );

            JPanel priorityPanel = new JPanel();
            priorityPanel.setLayout(new BoxLayout(priorityPanel, BoxLayout.Y_AXIS));
            priorityPanel.setBackground(new Color(255, 230, 208));

            JLabel priorityLabel = new JLabel("Select priorities for your goals:");
            priorityLabel.setFont(new Font("Segoe UI", Font.BOLD, 24));
            priorityLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
            priorityLabel.setForeground(new Color(102, 0, 153));
            priorityPanel.add(priorityLabel);
            priorityPanel.add(Box.createRigidArea(new Dimension(0, 30)));

            String[] priorities = {"High Priority A", "High Priority B", "Nice to Do"};
            JComboBox<String>[] priorityCombos = new JComboBox[6];
            for (int i = 0; i < 6; i++) {
                priorityCombos[i] = new JComboBox<>(priorities);
                priorityCombos[i].setFont(new Font("Segoe UI", Font.PLAIN, 16));
                priorityCombos[i].setPreferredSize(new Dimension(400, 40));
                priorityCombos[i].setMaximumSize(priorityCombos[i].getPreferredSize());
                priorityPanel.add(createGoalLabel("Priority for: " + sixGoals.get(i)));
                priorityPanel.add(priorityCombos[i]);
                priorityPanel.add(Box.createRigidArea(new Dimension(0, 20)));
            }

            JButton taskButton = createStyledButton("Add Tasks");
            taskButton.addActionListener(e2 -> {
                UserInteraction ui = new UserInteraction();
                ui.mostProductiveTime = customInputDialog(frame, "Enter your most productive time (e.g., 9:00 AM - 11:00 AM):");
                ui.mediumProductiveTime = customInputDialog(frame, "Enter your medium productive time (e.g., 1:00 PM - 3:00 PM):");
                ui.leastProductiveTime = customInputDialog(frame, "Enter your least productive time (e.g., 4:00 PM - 6:00 PM):");
                Map<String, Map<String, Integer>> taskDetails = ui.collectTasksWithTime(frame, sixGoals, priorityCombos);
                ui.displaySchedule(frame, taskDetails);
            });

            priorityPanel.add(taskButton);
            frame.getContentPane().removeAll();
            frame.getContentPane().add(priorityPanel);
            frame.revalidate();
            frame.repaint();
        });

        panel.add(submitButton);
        frame.getContentPane().removeAll();
        frame.getContentPane().add(panel);
        frame.revalidate();
        frame.repaint();
    }

    private Map<String, Map<String, Integer>> collectTasksWithTime(JFrame frame, List<String> goals, JComboBox<String>[] priorityCombos) {
        Map<String, Map<String, Integer>> taskDetails = new HashMap<>();
        for (int i = 0; i < goals.size(); i++) {
            String goal = goals.get(i);
            String priority = (String) priorityCombos[i].getSelectedItem();
            Map<String, Integer> taskTimes = new HashMap<>();
            
            for (int j = 0; j < 2; j++) {
                String taskInput = customInputDialog(frame, "Enter task " + (j + 1) + " for the goal: " + goal);
                if (taskInput != null && !taskInput.isEmpty()) {
                    String timeInput = customInputDialog(frame, "Enter time estimate (in minutes) for task: " + taskInput);
                    int taskTime = 0;
                    try {
                        taskTime = Integer.parseInt(timeInput);
                    } catch (NumberFormatException e) {
                        JOptionPane.showMessageDialog(frame, "Invalid time input. Setting to default (0 minutes).");
                    }
                    taskTimes.put(taskInput, taskTime);
                }
            }
            
            if (!taskTimes.isEmpty()) {
                taskDetails.put(goal + " (" + priority + ")", taskTimes);
            }
        }
        return taskDetails;
    }

    private void displaySchedule(JFrame frame, Map<String, Map<String, Integer>> taskDetails) {
        StringBuilder schedule = new StringBuilder("<html><body style='width: 300px'>");
        schedule.append("<h2 style='color: #333333;'>Your Schedule:</h2>");
        
        schedule.append("<h3 style='color: #4CAF50;'>Most Productive Time: ").append(mostProductiveTime).append("</h3>");
        appendTasksToSchedule(schedule, taskDetails, "High Priority A");
        
        schedule.append("<h3 style='color: #FFA500;'>Medium Productive Time: ").append(mediumProductiveTime).append("</h3>");
        appendTasksToSchedule(schedule, taskDetails, "High Priority B");
        
        schedule.append("<h3 style='color: #3F51B5;'>Least Productive Time: ").append(leastProductiveTime).append("</h3>");
        appendTasksToSchedule(schedule, taskDetails, "Nice to Do");
        
        schedule.append("</body></html>");
        
        JOptionPane.showMessageDialog(frame, new JLabel(schedule.toString()), "Your Schedule", JOptionPane.PLAIN_MESSAGE);
    }

    private void appendTasksToSchedule(StringBuilder schedule, Map<String, Map<String, Integer>> taskDetails, String priority) {
        taskDetails.forEach((goal, tasks) -> {
            if (goal.contains(priority)) {
                schedule.append("<p><b>").append(goal).append("</b></p>");
                tasks.forEach((task, time) -> {
                    schedule.append("<p>• ").append(task).append(" - ").append(time).append(" minutes</p>");
                });
            }
        });
    }

    public static String customInputDialog(JFrame frame, String message) {
        return JOptionPane.showInputDialog(frame, message);
    }

    private static JLabel createGoalLabel(String text) {
        JLabel label = new JLabel(text);
        label.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        label.setForeground(new Color(100, 100, 100));
        return label;
    }

    private static JButton createStyledButton(String text) {
        JButton button = new JButton(text);
        button.setFont(new Font("Segoe UI", Font.BOLD, 18));
        button.setForeground(Color.WHITE);
        button.setBackground(new Color(0, 123, 255));
        button.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        button.setFocusPainted(false);
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
        return button;
    }
}