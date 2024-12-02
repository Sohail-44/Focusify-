
import java.time.LocalTime;
import java.util.ArrayList;

public class Goals { 
    private String title;
    private int timeframe;
    private String description;
    private LocalTime time;
    private boolean completed;
    private ArrayList<String> steps;
    
    public String getTitle() { return title; }
    
    public void setTitle(String newTitle) { this.title = newTitle; }

   
    public String getDescription() { return description; }

    public void setDescrioption(String newDescription) { this.description = newDescription; }

    
     /* Time  Methods */
    
    public LocalTime getTime() { return time; }
    
    public void setTime(int hour, int minute) {
      this.time = LocalTime.of(hour, minute);
    }

    public int getTimeframe(){ return timeframe; }

    public void setTimeframe(int newTimeframe){ this.timeframe = newTimeframe; }
    
    public boolean inTimeframe(int timeRange, int timeframe){
        return timeframe <= timeRange;
    }

    /*
     * gives vaule for how closely the timeframe aligns with the available time range 
     * lower value means it is closer to fitting into the time range
     */
    public int timeframeAlignment(int timeRange, int timeframe){ // make double?
        return timeRange - timeframe;
    }
    

    public boolean isSoon() {
       return time.getHour() < LocalTime.now().plusHours(10).getHour();
    }
    public boolean inGoalTime(int timeRange){
        if(LocalTime.now().getHour() >= time.getHour() && LocalTime.now().getHour() < (time.getHour() + timeRange)){
            return true;
        }
        else{ return false; }
    }
    
    /* Completed Methods */

    public boolean isCompleted() { return completed; }

    public void setCompleted(boolean newStatus) { this.completed = newStatus; }

    
    /* Step Methods */

    public void addStep(String newStep){ steps.add(newStep); }

    public void removeStep(int stepNum){ steps.remove(stepNum - 1); }

    public ArrayList<String> getSteps(){ return steps; }

    public String getStep(int stepNum){ return steps.get(stepNum - 1); }
    
}
