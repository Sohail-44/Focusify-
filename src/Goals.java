public class Goals implements Objectives { /* TODO: make get methods return immutable objects */
    private String title;
    private String description;
    private int month, day, year;
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
    public int getDate() {
        return month, day, year; // what is issue?
    }

    @Override
    public void setDate(int newMonth, int newDay, int newYear) {
       this.month = newMonth;
       this.day = newDay;
       this.year = newYear;
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
