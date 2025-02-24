public class Round {

    Player player;
    Cpu cpu;

    Round() {
        this.player = new Player();
        this.cpu = new Cpu();
    }

    public void determineWinner(Choice playerChoice, Choice cpuChoice) {
        if (playerChoice == cpuChoice) {
            System.out.println("It's a draw!");
        } else if ((playerChoice == Choice.ROCK && cpuChoice == Choice.SCISSORS) ||
                (playerChoice == Choice.PAPER && cpuChoice == Choice.ROCK) ||
                (playerChoice == Choice.SCISSORS && cpuChoice == Choice.PAPER)) {
            System.out.println("You win this round!");
            player.addPlayerPoints();
        } else {
            System.out.println("CPU wins this round!");
            cpu.addCpuPoints();
        }
    }

}
