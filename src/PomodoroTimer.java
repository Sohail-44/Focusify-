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
import java.lang.Math;

public class PomodoroTimer extends JFrame {
    private JLabel timeLabel;
    private JButton startButton;
    private JButton resetButton;
    private long startTimeMili;
    private long difference;
    private long beginningDelay = 0;
    private long remainingPeriod;
    private Timer timer;
    private boolean paused;
    private int timeLeft = 25 * 60; // 25 minutes in seconds counting 

    public PomodoroTimer() {
        setTitle("Pomodoro");
        setSize(300, 150); // Just a small one to check
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        timeLabel = new JLabel(String.format("%02d:%02d", timeLeft / 60, timeLeft % 60));
        timeLabel.setFont(new Font("Arial", Font.BOLD, 40));
        add(timeLabel);

        timer = new Timer();
        paused = true; // timer starts out technically paused

        startButton = new JButton("Start");
        startButton.addActionListener((ActionListener) new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (paused == true) {
                    startTimer();
                    startButton.setText("Pause");
                } else {
                    pauseTimer();
                    startButton.setText("Start");
                }
            }
        });
        add(startButton);
        //TODO: inmplement reset and break button
        resetButton = new JButton("reset");
        resetButton.addActionListener((ActionListener) new ActionListener(){
            public void actionPerformed(ActionEvent e){
               stopTimer();
            }
        });
        
    }

    private void startTimer() {
        paused = false;
        startTimeMili = System.currentTimeMillis();
        timer.scheduleAtFixedRate(new TimerTask() {   
            
            public void run() {
                setRemainingPeriod(1000);
                setPeriodStart();
                if (timeLeft > 0) {
                timeLeft--;
                SwingUtilities.invokeLater(() -> {
                    timeLabel.setText(String.format("%02d:%02d", timeLeft / 60, timeLeft % 60));
                });
            } else {
                stopTimer();
                JOptionPane.showMessageDialog(PomodoroTimer.this, "Time's up!");
            }
            beginningDelay = 0; //after unpaused, only delayed the first timer
            }
            
        }, beginningDelay, 1000);
    }

    private void setPeriodStart(){
        startTimeMili = System.currentTimeMillis();
    }
    private void setDifference(){
        System.out.println(startTimeMili);
        System.out.println(System.currentTimeMillis());
        difference = startTimeMili - System.currentTimeMillis();
    }
    public void setRemainingPeriod(long num) {
        this.remainingPeriod = num;
    }
    
    private void pauseTimer(){
        timer.cancel();
        setDifference();
        remainingPeriod = remainingPeriod + difference;
        beginningDelay = Math.abs(remainingPeriod); // finds ammount of time in the 1000 milliseconds since task is delayed, abs() is done to prevent negatives
        System.out.println(beginningDelay);
        paused = true;
        timer = new Timer(); // creates new timer to task
    }

    private void stopTimer() {
        timer.cancel();
        paused = true;
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
    
/*copy of origninal */
// setTitle("Pomodoro");
// setSize(300, 150); // Just a small one to check
// setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
// setLayout(new FlowLayout());

// timeLabel = new JLabel(String.format("%02d:%02d", timeLeft / 60, timeLeft % 60));
// timeLabel.setFont(new Font("Arial", Font.BOLD, 40));
// add(timeLabel);

// startButton = new JButton("Start");
// startButton.addActionListener((ActionListener) new ActionListener() {
//     public void actionPerformed(ActionEvent e) {
//         if (timer == null) {
//             startTimer();
//             paused = false;
//             startButton.setText("Stop");
//         } else {
//             stopTimer();
//             startButton.setText("Start");
//         }
//     }
// });
// add(startButton);
// }

// private void startTimer() {
// timer = new Timer();
// paused = false;
// timer.scheduleAtFixedRate(new TimerTask() {
//     public void run() {
//         if (timeLeft > 0) {
//             timeLeft--;
//             SwingUtilities.invokeLater(() -> {
//                 timeLabel.setText(String.format("%02d:%02d", timeLeft / 60, timeLeft % 60));
//             });
//         } else if (paused == false){
//             stopTimer();
//             JOptionPane.showMessageDialog(PomodoroTimer.this, "Time's up!");
//         }
//         else {
//             stopTimer();
//             JOptionPane.showMessageDialog(PomodoroTimer.this, "Time's up!");
//         }
//     }
// }, 0, 1000);
// }

// private void stopTimer() {
// if (timer != null) {
//     timer.cancel();
//     timer = null;
//     paused = false;
// }
// timeLeft = 25 * 60;
// timeLabel.setText(String.format("%02d:%02d", timeLeft / 60, timeLeft % 60));
// }
// public static void main(String[] args) {

// SwingUtilities.invokeLater(() -> {
//     PomodoroTimer pomodoroTimer = new PomodoroTimer();
//     pomodoroTimer.setVisible(true);
// });
// }
