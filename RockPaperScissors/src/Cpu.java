import java.util.Random;

public class Cpu {

    private int cpuPoints;
    private final Random random;

    public Cpu() {
        this.random = new Random();
    }

    public Choice getCpuChoice() {
        Choice[] choices = Choice.values();
        int index = random.nextInt(choices.length);
        return choices[index];
    }

    public int getCpuPoints() {
        return cpuPoints;
    }

    public void addCpuPoints() {
        this.cpuPoints++;
    }
}
