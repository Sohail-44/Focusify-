import java.util.Date;

public class Tasks implements Objectives {
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
        return date; // what is issue?
    }

    @Override
    public void setDate(int newMonth, int newDay, int newYear) {

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
