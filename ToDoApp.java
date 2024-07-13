import java.util.ArrayList;
import java.util.Scanner;

public class ToDoApp {
    private ArrayList<String> tasks;
    private Scanner scanner;

    public ToDoApp() {
        tasks = new ArrayList<>();
        scanner = new Scanner(System.in);
    }

    public void run() {
        while (true) {
            System.out.println("ToDo App");
            System.out.println("Created by:- Shashank Karan");
            System.out.println("---------");
            System.out.println("1. Add Task");
            System.out.println("2. View Tasks");
            System.out.println("3. Delete Task");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");

            int option = scanner.nextInt();

            switch (option) {
                case 1:
                    addTask();
                    break;
                case 2:
                    viewTasks();
                    break;
                case 3:
                    deleteTask();
                    break;
                case 4:
                    System.out.println("Goodbye!");
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }

            // Add a loop to ask the user if they want to continue
            System.out.print("Do you want to continue? (y/n): ");
            char response = scanner.next().charAt(0);
            if (response == 'n' || response == 'N') {
                System.out.println("Goodbye!");
                return;
            }
        }
    }

    private void addTask() {
        System.out.print("Enter a new task: ");
        String task = scanner.next();
        tasks.add(task);
        System.out.println("Task added!");
    }

    private void viewTasks() {
        System.out.println("Tasks:");
        for (int i = 0; i < tasks.size(); i++) {
            System.out.println((i + 1) + ". " + tasks.get(i));
        }
    }

    private void deleteTask() {
        System.out.print("Enter the task number to delete: ");
        int taskNumber = scanner.nextInt();
        if (taskNumber > 0 && taskNumber <= tasks.size()) {
            tasks.remove(taskNumber - 1);
            System.out.println("Task deleted!");
        } else {
            System.out.println("Invalid task number. Please try again.");
        }
    }

    public static void main(String[] args) {
        ToDoApp app = new ToDoApp();
        app.run();
    }
}