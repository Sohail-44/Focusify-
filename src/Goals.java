
import java.time.LocalTime;

public class Goals { /* TODO: make get methods return immutable objects */
    private String title;
    private String description;
    private LocalTime time = LocalTime.now().plusHours(1);
    int compared = LocalTime.now().compareTo(time);
    private boolean completed;
    
    public String getTtitle() { return title; }

    
    public void setTitle(String newTitle) { title = newTitle; }

   
    public String getDescription() { return description; }

   
    public void setDescrioption(String newDescription) { description = newDescription; }

    
    public LocalTime getTime() {
        return time; 
    }
    
    public void setTime(int hour, int minute) {
      time.of(hour, minute);
    }

    

    
    
    public boolean isSoon() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'isSoon'");
    }

    
    public boolean isCompleted() { return completed; }

    
    public void setCompleted( boolean newStatus) {
     this.completed = newStatus;
    }
    
}
