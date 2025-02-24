import java.util.Scanner;

public class Game {

    Utils utils;
    Round round;
    Scanner scanner;

    public Game() {
        this.scanner = new Scanner(System.in);
        this.round = new Round();
        this.utils = new Utils();
    }

    public void startGame() {
        while (round.player.getPlayerPoints() < 3 && round.cpu.getCpuPoints() < 3) {
            Choice playerChoice = round.player.getPlayerChoice(scanner);
            Choice cpuChoice = round.cpu.getCpuChoice();

            System.out.println("Player chose: " + playerChoice);
            System.out.println("CPU chose: " + cpuChoice);

            round.determineWinner(playerChoice, cpuChoice);

            System.out.println("Player points: " + round.player.getPlayerPoints());
            System.out.println("CPU points: " + round.cpu.getCpuPoints());
            if (round.player.getPlayerPoints() < 3 && round.cpu.getCpuPoints() < 3) {
                utils.sleepAfterRound();
                utils.clearConsole();
            }
        }
        utils.sleepAfterRound();
        endGame();

    }

    private void endGame() {
        if (round.player.getPlayerPoints() == 3) {
            System.out.println("Congratulations! You won the game!");
        } else {
            System.out.println("CPU wins the game! Better luck next time.");
        }
    }

}
