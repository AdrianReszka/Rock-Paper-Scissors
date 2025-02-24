public enum Choice {
    ROCK,
    PAPER,
    SCISSORS;

    public static Choice fromString(String input) {
        try {
            return Choice.valueOf(input.trim().toUpperCase());
        } catch (IllegalArgumentException e) {
            return null;
        }
    }
}
