import java.util.Scanner;
import java.util.Random;

public class NumberGuessingGame19 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int min = 1;
        int max = 100;
        int attemptsLimit = 7; 
        int rounds = 0; 
        int score = 0; 
        
        System.out.println("Welcome to the Number Guessing Game!");
        System.out.println("I've selected a number between 1 and 100. Try to guess it!");

        boolean playAgain = true;

        while (playAgain) {
            int randomNumber = random.nextInt(max - min + 1) + min;
            int attempts = 0;
            boolean hasGuessedCorrectly = false;

            while (!hasGuessedCorrectly && attempts < attemptsLimit) {
                System.out.print("Enter your guess: ");
                int userGuess = scanner.nextInt();

                if (userGuess < min || userGuess > max) {
                    System.out.println("Please enter a number between 1 and 100.");
                } else if (userGuess < randomNumber) {
                    System.out.println("Too low! Try a higher number.");
                    attempts++;
                } else if (userGuess > randomNumber) {
                    System.out.println("Too high! Try a lower number.");
                    attempts++;
                } else {
                    System.out.println("Congratulations! You've guessed the number correctly: " + randomNumber);
                    hasGuessedCorrectly = true;
                    score++;
                }
            }

            if (!hasGuessedCorrectly) {
                System.out.println("Sorry, you've reached the maximum number of attempts. The number was: " + randomNumber);
            }

            rounds++;
            System.out.println("Rounds played: " + rounds + " | Score: " + score);
            System.out.print("Do you want to play again? (yes/no): ");
            String playChoice = scanner.next().toLowerCase();
            playAgain = playChoice.equals("yes") || playChoice.equals("y");
        }

        System.out.println("Thanks for playing!");
        scanner.close();
    }
}
