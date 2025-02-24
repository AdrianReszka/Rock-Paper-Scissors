import java.io.IOException;

public class Utils {

    Player player;
    Cpu cpu;
    Round round;

    public Utils() {
        this.player = new Player();
        this.cpu = new Cpu();
        this.round = new Round();
    }

    public void sleepAfterRound(){
        if (round.player.getPlayerPoints() < 3 && round.cpu.getCpuPoints() < 3) {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
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

}
