import java.util.Scanner;

public class GuessingApp {

    public static void main(String[] args) {

        System.out.println("Welcome to the Guessing App");

        GameConfig config = new GameConfig();
        config.showRules();

        Scanner scanner = new Scanner(System.in);

        int attempts = 0;
        int hintCount = 0;

        while (attempts < config.getMaxAttempts()) {

            System.out.print("Enter your guess: ");
            int guess = scanner.nextInt();
            attempts++;

            String result = GuessValidator.validateGuess(
                    guess, config.getTargetNumber());

            System.out.println(result);

            if ("CORRECT".equals(result)) {
                System.out.println("🎉 You won in " + attempts + " attempts!");
                break;
            }

            if (hintCount < config.getMaxHints()) {
                hintCount++;
                System.out.println(
                        HintService.generateHint(
                                config.getTargetNumber(), hintCount));
            }
        }

        scanner.close();
    }
}
