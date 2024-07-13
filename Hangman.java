import java.util.Scanner;
import java.util.Random;

public class Hangman {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        String[] words = {"apple", "banana", "cherry", "date", "elderberry"};
        boolean playAgain = true;

        while (playAgain) {
            String wordToGuess = words[random.nextInt(words.length)];
            char[] guessedWord = new char[wordToGuess.length()];
            for (int i = 0; i < guessedWord.length; i++) {
                guessedWord[i] = '_';
            }

            int attempts = 6;

            System.out.println("Welcome to Hangman!");
            System.out.println("Created by:- Shashank Karan");
            System.out.println("I'm thinking of a word with " + wordToGuess.length() + " letters.");

            while (attempts > 0) {
                System.out.print("Enter your guess: ");
                char userGuess = scanner.next().charAt(0);

                boolean correctGuess = false;
                for (int i = 0; i < wordToGuess.length(); i++) {
                    if (wordToGuess.charAt(i) == userGuess) {
                        guessedWord[i] = userGuess;
                        correctGuess = true;
                    }
                }

                if (!correctGuess) {
                    attempts--;
                    System.out.println("Incorrect guess. You have " + attempts + " attempts left.");
                }

                System.out.print("Guessed word: ");
                for (char c : guessedWord) {
                    System.out.print(c + " ");
                }
                System.out.println();

                boolean won = true;
                for (char c : guessedWord) {
                    if (c == '_') {
                        won = false;
                        break;
                    }
                }

                if (won) {
                    System.out.println(" Congratulations! You won!");
                    break;
                }
            }

            if (attempts == 0) {
                System.out.println("Game over! The word was " + wordToGuess);
            }

            System.out.println("Do you want to play again? (yes/no)");
            String playAgainInput = scanner.next().toLowerCase();
            if (!playAgainInput.equals("yes")) {
                playAgain = false;
            }
        }

        System.out.println("Thanks for playing!");
    }
}