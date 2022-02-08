package ir.maktab.homeserviceprovider.entity;

public enum Score {
    VERY_WEAK(1),
    WEAK(2),
    MEDIUM(3),
    GOOD(4),
    PERFECT(5);

    private int score;

    private Score(int score) {
        this.score = score;
    }

    public int getScore() {
        return score;
    }
}