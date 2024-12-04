import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

public class PomodoroTimer extends JFrame {
    private JLabel timeLabel;
    private JButton startButton;
    private Timer timer;
    private int timeLeft = 25 * 60; // 25 minutes in seconds counting 

    public PomodoroTimer() {
        setTitle("Pomodoro");
        setSize(300, 150); // Just a small one to check
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        timeLabel = new JLabel(String.format("%02d:%02d", timeLeft / 60, timeLeft % 60));
        timeLabel.setFont(new Font("Arial", Font.BOLD, 40));
        add(timeLabel);

        startButton = new JButton("Start");
        startButton.addActionListener((ActionListener) new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (timer == null) {
                    startTimer();
                    startButton.setText("Stop");
                } else {
                    stopTimer();
                    startButton.setText("Start");
                }
            }
        });
        add(startButton);
    }

    private void startTimer() {
        timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            public void run() {
                if (timeLeft > 0) {
                    timeLeft--;
                    SwingUtilities.invokeLater(() -> {
                        timeLabel.setText(String.format("%02d:%02d", timeLeft / 60, timeLeft % 60));
                    });
                } else {
                    stopTimer();
                    JOptionPane.showMessageDialog(PomodoroTimer.this, "Time's up!");
                }
            }
        }, 0, 1000);
    }

    private void stopTimer() {
        if (timer != null) {
            timer.cancel();
            timer = null;
        }
        timeLeft = 25 * 60;
        timeLabel.setText(String.format("%02d:%02d", timeLeft / 60, timeLeft % 60));
    }
    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {
            PomodoroTimer pomodoroTimer = new PomodoroTimer();
            pomodoroTimer.setVisible(true);
        });
    }

   
} 
    


