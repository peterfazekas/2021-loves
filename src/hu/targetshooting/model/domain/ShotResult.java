package hu.targetshooting.model.domain;

import hu.targetshooting.model.service.ShotResultHelper;

public class ShotResult {

    private final int id;
    private final String shots;
    private final int score;

    public ShotResult(int id, String shots) {
        this.id = id;
        this.shots = shots;
        this.score = ShotResultHelper.getScore(shots);
    }

    public int getId() {
        return id;
    }

    public int getScore() {
        return score;
    }

    public boolean hasTwoSuccessShotsInRow() {
        return shots.contains("++");
    }
}
