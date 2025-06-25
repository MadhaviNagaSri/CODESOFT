import java.util.Random;
import java.util.Scanner;

public class NumberGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int totalRounds = 0;
        int totalWins = 0;
        int bestScore = Integer.MAX_VALUE;
        boolean playAgain = true;

        System.out.println("Welcome to the Number Guessing Game!");
        System.out.println("I'm thinking of a number between 1 and 100.");

        while (playAgain) {
            totalRounds++;
            int number = random.nextInt(100) + 1;
            int maxAttempts = 10;
            int attempts = 0;
            boolean guessedCorrectly = false;

            System.out.println("\n--- Round " + totalRounds + " ---");
            System.out.println("You have " + maxAttempts + " attempts.");

            while (attempts < maxAttempts && !guessedCorrectly) {
                System.out.print("Enter your guess (" + (attempts + 1) + "/" + maxAttempts + "): ");
                int guess = scanner.nextInt();
                attempts++;

                if (guess == number) {
                    System.out.println("Correct! You guessed it in " + attempts + " attempts.");
                    guessedCorrectly = true;
                    totalWins++;
                    
                    if (attempts < bestScore) {
                        bestScore = attempts;
                    }
                } else if (guess < number) {
                    System.out.println("Too low! Try a higher number.");
                } else {
                    System.out.println("Too high! Try a lower number.");
                }
            }

            if (!guessedCorrectly) {
                System.out.println("Game over! The number was: " + number);
            }

            System.out.print("\nPlay again? (yes/no): ");
            String response = scanner.next();
            playAgain = response.equalsIgnoreCase("yes");
        }

        System.out.println("\nGame Summary:");
        System.out.println("Rounds played: " + totalRounds);
        System.out.println("Rounds won: " + totalWins);
        
        if (bestScore != Integer.MAX_VALUE) {
            System.out.println("Best score: " + bestScore + " guesses");
        } else {
            System.out.println("Best score: N/A");
        }
        
        System.out.println("Thanks for playing!");
        scanner.close();
    }
}