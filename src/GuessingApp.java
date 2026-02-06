import java.util.Scanner;

public class GuessingApp {

    public static void main(String[] args) {

        System.out.println("Welcome to the Guessing App");

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter player name: ");
        String playerName = scanner.nextLine();

        GameConfig config = new GameConfig();
        config.showRules();

        int attempts = 0;
        int hintCount = 0;
        boolean isWin = false;

            while (attempts < config.getMaxAttempts()) {
                try {
                    System.out.print("Enter your guess: ");
                    String input = scanner.nextLine();

                    int guess = ValidationService.validateInput(input);
                    attempts++;

                    String result = GuessValidator.validateGuess(
                            guess, config.getTargetNumber());

                    System.out.println(result);

                if ("CORRECT".equals(result)) {
                    isWin = true;
                    System.out.println("🎉 You guessed it in " + attempts + " attempts!");
                    break;
                } else {
                    if (hintCount < config.getMaxHints()) {
                        hintCount++;
                        System.out.println(
                                HintService.generateHint(
                                        config.getTargetNumber(), hintCount));
                    }

                } catch (InvalidInputException e) {
                    System.out.println(e.getMessage());
                }
            }

        StorageService.saveResult(playerName, attempts, isWin);

        System.out.println("Game Over");
        scanner.close();
    }
}
