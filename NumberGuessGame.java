import java.util.Random;
import java.util.Scanner;

public class NumberGuessGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Random random = new Random();

        int score = 0;

        final int MAX_ATTEMPTS = 5; 
        final int RANGE = 100;      

        System.out.println("Welcome to the Number Guessing Game!");

        boolean playAgain;

        do {
            int secret = random.nextInt(RANGE) + 1;
            boolean guessed = false; 

            System.out.println("\nGuess the number between 1 and " + RANGE + ". You have " + MAX_ATTEMPTS + " attempts.");

            for (int i = 1; i <= MAX_ATTEMPTS; i++) {
                System.out.print("Attempt " + i + ": ");
                int guess = scanner.nextInt();

                if (guess == secret) {
                    System.out.println("Correct! You guessed it.");
                    score++;        
                    guessed = true;
                    break;          
                }

                System.out.println(guess < secret ? "Too low!" : "Too high!");
            }

            if (!guessed) {
                System.out.println("Out of attempts! The number was: " + secret);
            }

            System.out.println("Score: " + score);

            System.out.print("Play again? (yes/no): ");
            playAgain = scanner.next().equalsIgnoreCase("yes");

        } while (playAgain); 

        System.out.println("Thanks for playing! Final score: " + score);

        scanner.close();
    }
}