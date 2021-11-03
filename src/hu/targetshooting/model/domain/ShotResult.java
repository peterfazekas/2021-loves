package hu.targetshooting.model.domain;

public class ShotResult {

    private final int id;
    private final String shots;
    private final int score;

    public ShotResult(int id, String shots) {
        this.id = id;
        this.shots = shots;
        this.score = 0;
    }

    public int getId() {
        return id;
    }

    public int getScore() {
        return score;
    }
}
