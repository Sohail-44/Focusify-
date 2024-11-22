import java.util.Date;

public class Goals implements Objectives { /* TODO: make get methods return immutable objects */
    private String title;
    private String description;
    private Date date;
    private boolean completed;
    @Override
    public String getTtitle() { return title; }

    @Override
    public void setTitle(String newTitle) { title = newTitle; }

    @Override
    public String getDescription() { return description; }

    @Override
    public void setDescrioption(String newDescription) { description = newDescription; }

    @Override
    public Date getDate() {
        return date; 
    }

    @SuppressWarnings("deprecation")
    @Override
    public void setDate(int newMonth, int newDay, int newYear) {
      date.setMonth(newMonth);
      date.setDate(newDay);
      date.setYear(newYear);
    }

    @Override
    public boolean isSoon() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'isSoon'");
    }

    @Override
    public boolean isCompleted() { return completed; }

    @Override
    public void setCompleted( boolean newStatus) {
     this.completed = newStatus;
    }
    
}
