import java.util.Scanner;

public class GuessingApp {

    public static void main(String[] args) {

        System.out.println("Welcome to the Guessing App");

        GameConfig config = new GameConfig();
        config.showRules();

        Scanner scanner = new Scanner(System.in);
        int attempts = 0;

        while (attempts < config.getMaxAttempts()) {

            System.out.print("Enter your guess: ");

            if (!scanner.hasNextInt()) {
                System.out.println("Please enter a valid number");
                scanner.next();
                continue;
            }

            int guess = scanner.nextInt();
            attempts++;

            String result = GuessValidator.validateGuess(
                    guess,
                    config.getTargetNumber()
            );

            System.out.println(result);

            if ("CORRECT".equals(result)) {
                break;
            }
        }

        scanner.close();
    }
}
