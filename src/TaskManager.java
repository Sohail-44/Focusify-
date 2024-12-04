import java.util.*;
import javax.swing.*;

public class TaskManager {
    private GoalManager goalManager;
    private UserInteraction userInteraction;

    public TaskManager(GoalManager goalManager, UserInteraction userInteraction) {
        this.goalManager = goalManager;
        this.userInteraction = userInteraction;
    }

    public void manageTasks(JFrame frame) {
        // Step 1: Display Goals (filtered by their categories)
        displayGoals();

        // Step 2: Collect tasks for each goal (excluding eliminate goals)
        Map<String, List<String>> tasks = collectTasks(frame);

        // Step 3: Display all tasks entered for each goal
        displayTasks(tasks);
    }

    private void displayGoals() {
        // Retrieve all categories of goals from GoalManager
        List<String> topGoals = goalManager.getUsersTenGoals();
        List<String> highPriorityA = goalManager.HighPriorityA("A1", "A2");
        List<String> highPriorityB = goalManager.HighPriorityB("B1", "B2");
        List<String> niceToDoGoals = goalManager.NiceToDo("C1", "C2");
    

        // Display goals, excluding eliminate goals
        System.out.println("Top 10 Goals:");
        topGoals.forEach(System.out::println);

        System.out.println("\nHigh Priority A Goals:");
        highPriorityA.forEach(System.out::println);

        System.out.println("\nHigh Priority B Goals:");
        highPriorityB.forEach(System.out::println);

        System.out.println("\nNice to Do Goals:");
        niceToDoGoals.forEach(System.out::println);

        
    }

    private  Map<String, List<String>> collectTasks(JFrame frame) {
        Map<String, List<String>> tasks = new HashMap<>();

        // Combine all categories of goals into one list for easy iteration, excluding eliminate goals
        List<String> allGoals = new ArrayList<>();
        allGoals.addAll(goalManager.getUsersTenGoals());
        allGoals.addAll(goalManager.HighPriorityA("A1", "A2"));
        allGoals.addAll(goalManager.HighPriorityB("B1", "B2"));
        allGoals.addAll(goalManager.NiceToDo("C1", "C2"));

        return (Map<String, List<String>>) frame;

    }
          
   
    private void displayTasks(Map<String, List<String>> tasks) {
        System.out.println("\nTasks for each goal:");
        tasks.forEach((goal, taskList) -> {
            System.out.println("Goal: " + goal);
            taskList.forEach(task -> System.out.println("- " + task));
        });
    }
}