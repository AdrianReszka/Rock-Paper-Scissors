import java.util.Scanner;

public class Player {

    private int playerPoints;

    public Player() {}

    public int getPlayerPoints() {
        return playerPoints;
    }

    public void addPlayerPoints() {
        this.playerPoints++;
    }

    public Choice getPlayerChoice(Scanner scanner) {
        Choice choice = null;

        while (choice == null) {
            System.out.print("Please enter your choice (Rock, Paper, Scissors): ");
            String input = scanner.nextLine();
            choice = Choice.fromString(input);

            if (choice == null) {
                System.out.println("Invalid choice! Please enter Rock, Paper, or Scissors.");
            }
        }

        return choice;
    }
}
