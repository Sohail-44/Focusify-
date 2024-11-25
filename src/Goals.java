
import java.time.LocalTime;
import java.util.ArrayList;

public class Goals { 
    private String title;
    private String description;
    private LocalTime time;
    private boolean completed;
    private ArrayList<String> steps;
    
    public String getTtitle() { return title; }
    
    public void setTitle(String newTitle) { title = newTitle; }

   
    public String getDescription() { return description; }

    public void setDescrioption(String newDescription) { description = newDescription; }

    
    public LocalTime getTime() { return time; }
    
    public void setTime(int hour, int minute) {
      time = LocalTime.of(hour, minute);
    }
    
    public boolean isSoon() {
       return time.getHour() < LocalTime.now().plusHours(10).getHour();
    }

    
    public boolean isCompleted() { return completed; }

    public void setCompleted(boolean newStatus) { this.completed = newStatus; }

    
    public void addStep(String newStep){ steps.add(newStep); }

    public ArrayList<String> getSteps(){ return steps; }

    public String getStep(int stepNum){ return steps.get(stepNum - 1); }
    
}
