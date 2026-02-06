import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class StorageService {

    public static void saveResult(String player, int attempts, boolean win) {

        try (BufferedWriter writer =
                     new BufferedWriter(new FileWriter("game_results.txt", true))) {

            writer.write(
                    "Player: " + player +
                            ", Attempts: " + attempts +
                            ", Result: " + (win ? "WIN" : "LOSE")
            );
            writer.newLine();

        } catch (IOException e) {
            System.out.println("Unable to save game result.");
        }
    }
}
