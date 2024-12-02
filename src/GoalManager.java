import java.util.ArrayList;
import java.util.List;

/**   
 * The Goals class will basically manage goals. This is I am iamgining it will do it.
 *  - So as per the users response;
 *      - It will store their TenGoals for the next day, from that TenGoals prioritize keep prioritizing goals.
 *      
 */

 // Creating instance variables for Goals
 public class GoalManager {
     private static List<String> usersSixGoals = new ArrayList<>();
     private static List<String> highPriorityA = new ArrayList<>();
     private static List<String> highPriorityB = new ArrayList<>();
     private static List<String> niceToDo = new ArrayList<>();
    
 
     // Method to set the user's 10 goals
     public static void setUsersTenGoals(List<String> goals) {
         usersSixGoals = goals;
     }
 
     // Method to return user's 10 goals
     public static List<String> getUsersTenGoals() {
         return usersSixGoals;
     }
 
     // Method to store high-priority A goals
     public static List<String> HighPriorityA(String a1, String a2) {
         highPriorityA.clear();
         highPriorityA.add(a1);
         highPriorityA.add(a2);
         return highPriorityA;
     }
 
     // Method to store high-priority B goals
     public static List<String> HighPriorityB(String b1, String b2) {
         highPriorityB.clear();
         highPriorityB.add(b1);
         highPriorityB.add(b2);
         return highPriorityB;
     }
 
     // Method to store nice-to-do goals
     public static List<String> NiceToDo(String c1, String c2) {
         niceToDo.clear();
         niceToDo.add(c1);
         niceToDo.add(c2);
         return niceToDo;
     }
 
    }


    // import java.time.LocalTime;
    // import java.util.ArrayList;
    
    // public class Goals { 
    //     private String title;
    //     private int timeframe;
    //     private String description;
    //     private LocalTime time;
    //     private boolean completed;
    //     private ArrayList<String> steps;
        
    //     public String getTitle() { return title; }
        
    //     public void setTitle(String newTitle) { this.title = newTitle; }
    
       
    //     public String getDescription() { return description; }
    
    //     public void setDescrioption(String newDescription) { this.description = newDescription; }
    
        
    //      /* Time  Methods */
        
    //     public LocalTime getTime() { return time; }
        
    //     public void setTime(int hour, int minute) {
    //       this.time = LocalTime.of(hour, minute);
    //     }
    
    //     public int getTimeframe(){ return timeframe; }
    
    //     public void setTimeframe(int newTimeframe){ this.timeframe = newTimeframe; }
        
    //     public boolean inTimeframe(int timeRange, int timeframe){
    //         return timeframe <= timeRange;
    //     }
    
    //     /*
    //      * gives vaule for how closely the timeframe aligns with the available time range 
    //      * lower value means it is closer to fitting into the time range
    //      */
    //     public int timeframeAlignment(int timeRange, int timeframe){ // make double?
    //         return timeRange - timeframe;
    //     }
        
    
    //     public boolean isSoon() {
    //        return time.getHour() < LocalTime.now().plusHours(10).getHour();
    //     }
    //     public boolean inGoalTime(int timeRange){
    //         if(LocalTime.now().getHour() >= time.getHour() && LocalTime.now().getHour() < (time.getHour() + timeRange)){
    //             return true;
    //         }
    //         else{ return false; }
    //     }
        
    //     /* Completed Methods */
    
    //     public boolean isCompleted() { return completed; }
    
    //     public void setCompleted(boolean newStatus) { this.completed = newStatus; }
    
        
    //     /* Step Methods */
    
    //     public void addStep(String newStep){ steps.add(newStep); }
    
    //     public void removeStep(int stepNum){ steps.remove(stepNum - 1); }
    
    //     public ArrayList<String> getSteps(){ return steps; }
    
    //     public String getStep(int stepNum){ return steps.get(stepNum - 1); }
        
    // }
    


