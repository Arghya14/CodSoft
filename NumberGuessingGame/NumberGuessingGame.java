import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int minNum = 1;
        int maxNum = 100;
        int maxAttempts = 10;
        int roundsWon = 0;

        System.out.println("Welcome to the Number Guessing Game!");

        while (true) {
            int randomNumber = random.nextInt(maxNum - minNum + 1) + minNum;
            int numGuesses = 0;

            System.out.println("\nNew round! Guess the number between " + minNum + " and " + maxNum + ".");
            boolean hasGuessedCorrectly = false;

            while (numGuesses < maxAttempts) {
                System.out.print("Guess #" + (numGuesses + 1) + ": ");
                int userGuess = scanner.nextInt();
                numGuesses++;

                if (userGuess == randomNumber) {
                    System.out.println("Congratulations! You've guessed the correct number " + randomNumber +
                            " in " + numGuesses + " guesses.");
                    hasGuessedCorrectly = true;
                    break;
                } else if (userGuess < randomNumber) {
                    System.out.println("Too low! Try again.");
                } else {
                    System.out.println("Too high! Try again.");
                }
            }

            if (hasGuessedCorrectly) {
                roundsWon++;
            } else {
                System.out.println("Sorry, you've reached the maximum number of attempts for this round.");
            }

            System.out.print("Play another round? (yes/no): ");
            String playAgain = scanner.next().toLowerCase();
            if (!playAgain.equals("yes")) {
                break;
            }
        }

        System.out.println("Game over! You won " + roundsWon + " round(s).");

        scanner.close();
    }
}
