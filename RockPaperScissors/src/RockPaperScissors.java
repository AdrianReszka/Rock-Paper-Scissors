import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class RockPaperScissors {
    private int playerPoints;
    private int cpuPoints;
    private final String[] options = {"Rock", "Paper", "Scissors"};

    private String choice;
    private String cpuChoice;

    RockPaperScissors() {}

    RockPaperScissors(int playerPoints, int cpuPoints, String choice, String[] options) {
        this.playerPoints = 0;
        this.cpuPoints = 0;
    }

    public void mainLoop() {

        while (playerPoints < 3 && cpuPoints < 3) {
            clearConsole();
            System.out.println("Rock, Paper, Scissors!");
            System.out.println("Player points: " + playerPoints);
            System.out.println("CPU points: " + cpuPoints);

            getChoices();
            mainSwitchCase();
            sleepAfterRound();
        }
        endgameInformation();
    }

    public void rockCase(String cpuChoice) {
        System.out.println("Cpu choice is: " + cpuChoice);
        switch (cpuChoice) {
            case "Paper" -> {
                System.out.println("You have lost this round!");
                cpuPoints++;
            }
            case "Scissors" -> {
                System.out.println("You have won this round!");
                playerPoints++;
            }
            case "Rock" -> System.out.println("Draw!");
        }
    }

    public void paperCase(String cpuChoice) {
        System.out.println("Cpu choice is: " + cpuChoice);
        switch (cpuChoice) {
            case "Paper" -> System.out.println("Draw!");
            case "Scissors" -> {
                System.out.println("You have lost this round!");
                cpuPoints++;
            }
            case "Rock" -> {
                System.out.println("You have won this round!");
                playerPoints++;
            }
        }
    }

    public void scissorsCase(String cpuChoice) {
        System.out.println("Cpu choice is: " + cpuChoice);
        switch (cpuChoice) {
            case "Paper" -> {
                System.out.println("You have won this round!");
                playerPoints++;
            }
            case "Rock" -> {
                System.out.println("You have lost this round!");
                cpuPoints++;
            }
            case "Scissors" -> System.out.println("Draw!");
        }
    }

    public void clearConsole() {
        try {
            if (System.getProperty("os.name").contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                new ProcessBuilder("clear").inheritIO().start().waitFor();
            }
        } catch (IOException | InterruptedException ex) {
            System.out.println("Error while trying to clear the console.");
        }
    }

    public void sleepAfterRound(){
        if (playerPoints < 3 && cpuPoints < 3) {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void endgameInformation(){
        if (playerPoints == 3) {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            clearConsole();
            System.out.println("Rock, Paper, Scissors!");
            System.out.println("Player points: " + playerPoints);
            System.out.println("CPU points: " + cpuPoints);
            System.out.println("Congratulations! You won the game.");
        } else if (cpuPoints == 3) {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            clearConsole();
            System.out.println("Rock, Paper, Scissors!");
            System.out.println("Player points: " + playerPoints);
            System.out.println("CPU points: " + cpuPoints);
            System.out.println("CPU wins the game. Better luck next time!");
        }
    }

    public void mainSwitchCase() {
        switch (choice) {
            case "Rock" -> rockCase(cpuChoice);
            case "Paper" -> paperCase(cpuChoice);
            case "Scissors" -> scissorsCase(cpuChoice);
            default -> {
                clearConsole();
                System.out.println("Invalid choice!");
                System.out.println("Choose a valid option:");
                for (String option : options) {
                    System.out.println(option);
                }
            }
        }
    }

    public void getChoices(){
        Scanner in = new Scanner(System.in);
        System.out.print("Please enter your choice (Rock, Paper, Scissors): ");
        choice = in.nextLine();
        for (int i = 0; i < choice.length(); i++) {
            choice = String.valueOf(Character.toUpperCase(choice.charAt(0))) + choice.substring(1).toLowerCase();
        }

        Random rand = new Random();
        int arrayIndex = rand.nextInt(options.length);
        cpuChoice = options[arrayIndex];
    }
}
