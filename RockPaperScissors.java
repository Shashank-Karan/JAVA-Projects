import java.util.Scanner;
import java.util.Random;

public class RockPaperScissors {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int userWins = 0;
        int computerWins = 0;

        boolean playAgain = true;
        while (playAgain) {
            System.out.println("Welcome : Rock, Paper, and Scissors game");
            System.out.println("Created by:- Shashank Karan");
            System.out.println("Enter your choice (rock, paper, scissors, or quit):");
            String userChoice = scanner.next().toLowerCase();

            if (userChoice.equals("quit")) {
                playAgain = false;
            } else {
                String computerChoice = getComputerChoice(random);

                System.out.println("Computer chose: " + computerChoice);

                if (userChoice.equals(computerChoice)) {
                    System.out.println("It's a tie!");
                } else if (isUserWin(userChoice, computerChoice)) {
                    System.out.println("You win!");
                    userWins++;
                } else {
                    System.out.println("Computer wins!");
                    computerWins++;
                }

                System.out.println("Score: You - " + userWins + ", Computer - " + computerWins);
            }
        }

        System.out.println("Thanks for playing!");
    }

    private static String getComputerChoice(Random random) {
        int choice = random.nextInt(3);
        switch (choice) {
            case 0:
                return "rock";
            case 1:
                return "paper";
            default:
                return "scissors";
        }
    }

    private static boolean isUserWin(String userChoice, String computerChoice) {
        if (userChoice.equals("rock")) {
            return computerChoice.equals("scissors");
        } else if (userChoice.equals("paper")) {
            return computerChoice.equals("rock");
        } else {
            return computerChoice.equals("paper");
        }
    }
}