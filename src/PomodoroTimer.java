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
import javax.swing.JPanel;
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
    private int timeLeft = 20; // 25 minutes in seconds counting 
    private int breakTimeLeft = 5 * 60; // 5 minute break
    private Timer breakTimer;
    private JButton breakStartButton;
    private boolean breakPaused;
    private JLabel breakTimeLabel;
    private JLabel breakTimerLabel;

    public PomodoroTimer() {
        setTitle("Pomodoro");
        setSize(300, 150); // Just a small one to check
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());
        setResizable(false);
        

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
                    resetButton.setVisible(true);
                } else {
                    pauseTimer();
                    startButton.setText("Start");
                }
            }
        });
        add(startButton);
        //TODO: inmplement reset and break button
        resetButton = new JButton("Reset");
        resetButton.addActionListener((ActionListener) new ActionListener(){
            public void actionPerformed(ActionEvent e){
               stopTimer();
            }
        });
        add(resetButton);
        resetButton.setVisible(false);
        

        
        breakTimerLabel = new JLabel("Break Time:");
        breakTimerLabel.setFont(new Font("Arial", Font.BOLD, 25));
        

        breakTimer = new Timer();
        breakTimeLabel = new JLabel();
        breakTimeLabel = new JLabel(String.format("%02d:%02d", breakTimeLeft / 60, breakTimeLeft % 60));
        breakTimeLabel.setFont(new Font("Arial", Font.BOLD, 25));
        breakStartButton = new JButton("Start");
        JPanel breakPannel = new JPanel();
        breakPannel.setAlignmentY(BOTTOM_ALIGNMENT);
        breakPaused = true;
        breakStartButton.addActionListener((ActionListener) new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (breakPaused == true){
                    startBreakTimer();
                    breakPaused = false;
                    breakStartButton.setText("Reset");
                    
                } else{
                    stopBreakTimer();
                }
            } });
        add(breakTimerLabel);
        add(breakTimeLabel);
        add(breakStartButton);

    }

    /* Pomodoro Timer */
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
                startBreakTimer();
                JOptionPane.showMessageDialog(PomodoroTimer.this, "Time's up!");
            }
            beginningDelay = 0; //after unpaused, only delayed the first time
            }
            
        }, beginningDelay, 1000);
    }

    private void setPeriodStart(){
        startTimeMili = System.currentTimeMillis();
    }
    private void setDifference(){
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
        paused = true;
        timer = new Timer(); // creates new timer to task
    }

    private void stopTimer() {
        timer.cancel();
        startButton.setText("Start");
        paused = true;
        timeLeft = 25 * 60;
        timeLabel.setText(String.format("%02d:%02d", timeLeft / 60, timeLeft % 60));
        timer = new Timer();
        resetButton.setVisible(false);
    }

    /* Break Timer */

    private void startBreakTimer(){
        breakTimer.scheduleAtFixedRate(new TimerTask() {   
            
            public void run() {
                if (breakTimeLeft > 0) {
                breakTimeLeft--;
                SwingUtilities.invokeLater(() -> {
                    breakTimeLabel.setText(String.format("%02d:%02d", breakTimeLeft / 60, breakTimeLeft % 60));
                });
            } else {
                breakTimer.cancel();
                JOptionPane.showMessageDialog(PomodoroTimer.this, "Break Time's up!");
            }
            }
            
        }, 0, 1000);
    }

    private void stopBreakTimer(){
        breakTimer.cancel();
        breakPaused = true;
        breakTimeLeft = 5 * 60;
        breakTimeLabel.setText(String.format("%02d:%02d", breakTimeLeft / 60, breakTimeLeft % 60));
        breakTimer = new Timer();
        breakStartButton.setText("Start");
    }

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {
            PomodoroTimer pomodoroTimer = new PomodoroTimer();
            pomodoroTimer.setVisible(true);
        });
    }

   
} 
    
