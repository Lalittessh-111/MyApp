package RandomGame;

import java.util.Scanner;
import java.util.Random;

public class NumberGuessingGame {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Creates a Scanner object to read user input.
        Random random = new Random(); // Creates a Random object to generate random numbers.
        int score = 0; // Tracks the player's score (number of correct guesses).
        char playAgain = 'y'; // Controls the game loop (play again prompt).

        System.out.println("Welcome to the Number Guessing Game!");

        while (playAgain == 'y' || playAgain == 'Y') {
            int number = random.nextInt(100) + 1; // Generates a random number between 1 and 100 (inclusive).
            int attempts = 0; // Tracks the number of guesses made in the current round.
            int maxAttempts = 10; // Sets the maximum number of allowed guesses.

            System.out.println("\nI have generated a number between 1 and 100.");
            System.out.println("You have " + maxAttempts + " attempts to guess it correctly.");

            while (attempts < maxAttempts) {
                System.out.print("Enter your guess: ");
                while (!scanner.hasNextInt()) { // Ensures valid integer input.
                    System.out.print("Please enter a valid number: ");
                    scanner.next(); // Clears buffer to prevent infinite loop.
                }
                int guess = scanner.nextInt(); // Reads the user's guess.
                attempts++; // Increments the attempts counter.

                if (guess == number) {
                    System.out.println("Congratulations! You guessed the correct number " + number + " in " + attempts + " attempts.");
                    score++; // Increments score for a correct guess.
                    break; // Exits the inner loop if the guess is correct.
                } else if (guess < number) {
                    System.out.println("Too low!"); // Feedback for a guess lower than the number.
                } else {
                    System.out.println("Too high!"); // Feedback for a guess higher than the number.
                }
            }

            if (attempts == maxAttempts) { // Informs the user if they used all attempts.
                System.out.println("Sorry, you've used all " + maxAttempts + " attempts. The correct number was " + number + ".");
            }

            System.out.print("Do you want to play again? (y/n): ");
            playAgain = scanner.next().charAt(0); // Reads user input (y/n) for another round.
        }

        System.out.println("Thank you for playing! Your score is " + score + ".");
        scanner.close(); // Closes the Scanner object to release resources (important).
    }
}