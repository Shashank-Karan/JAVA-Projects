import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean continueCalculating = true;

        while (continueCalculating) {
            System.out.println("Welcome to the Calculator!");
            System.out.println("Created by:- Shashank Karan");
            System.out.println("Enter an operation (+, -, *, /, %) or 'exit' to quit:");

            String operation = scanner.next();

            if (operation.equalsIgnoreCase("exit")) {
                continueCalculating = false;
            } else {
                System.out.println("Enter the first number:");
                double num1 = scanner.nextDouble();

                System.out.println("Enter the second number:");
                double num2 = scanner.nextDouble();

                double result = 0;

                switch (operation) {
                    case "+":
                        result = num1 + num2;
                        break;
                    case "-":
                        result = num1 - num2;
                        break;
                    case "*":
                        result = num1 * num2;
                        break;
                    case "/":
                        if (num2 != 0) {
                            result = num1 / num2;
                        } else {
                            System.out.println("Error: Division by zero!");
                            continue;
                        }
                        break;
                    case "%":
                        if (num2 != 0) {
                            result = num1 % num2;
                        } else {
                            System.out.println("Error: Division by zero!");
                            continue;
                        }
                        break;
                    default:
                        System.out.println("Error: Invalid operation!");
                        continue;
                }

                System.out.println("Result: " + result);
            }
        }

        System.out.println("Goodbye!");
    }
}
