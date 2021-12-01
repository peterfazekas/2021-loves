package hu.targetshooting.model.domain;

import hu.targetshooting.model.service.ShotResultHelper;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

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

    public Integer getShotCount() {
        return shots.length();
    }

    public String getSuccessShotIndexes() {
        return IntStream.range(0, shots.length())
                .filter(i -> shots.charAt(i) == '+')
                .mapToObj(i -> String.valueOf(i + 1))
                .collect(Collectors.joining(" "));
    }

    public long countSuccessShots() {
        return shots.chars()
                .filter(i -> (char) i == '+')
                .count();
    }

    public int getLongestSuccessSequenceSize() {
        return Arrays.stream(shots.split("-"))
                .mapToInt(String::length)
                .max()
                .getAsInt();
    }
}
