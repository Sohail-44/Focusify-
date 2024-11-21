import java.util.Date;

public interface Objectives {

    /* Title Methods */
    String getTtitle();
    void setTitle(String newTitle);

    /* Description Methods */
    String getDescription();
    void setDescrioption(String newDescription);

    /* Date Methods */
    //do we need to account for leap years?
    Date getDate();
    void setDate(int newMonth, int newDay, int newYear); //format of dates could be different?

    /* Other methods */
    boolean isSoon();
    boolean isCompleted();
    void setCompleted( boolean newStatus);
    // look into priority cue and comparison
    
    
}
