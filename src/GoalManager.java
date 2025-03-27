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


   

