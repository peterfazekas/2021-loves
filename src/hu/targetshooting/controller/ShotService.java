package hu.targetshooting.controller;

import hu.targetshooting.model.domain.ShotResult;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ShotService {

    private final List<ShotResult> results;

    public ShotService(List<ShotResult> results) {
        this.results = results;
    }

    public String getTwoSuccessShotIds() {
        return results.stream()
                .filter(ShotResult::hasTwoSuccessShotsInRow)
                .map(ShotResult::getId)
                .map(String::valueOf)
                .collect(Collectors.joining(" "));
    }

    public int getLongestShotSequenceId() {
        return results.stream()
                .max(Comparator.comparing(ShotResult::getShotCount))
                .map(ShotResult::getId)
                .get();
    }

    public String getSuccessShotIndexesById(int id) {
        return getResultById(id).getSuccessShotIndexes();
    }

    public long countSuccessShotsById(int id) {
        return getResultById(id).countSuccessShots();
    }

    public int getScoreById(int id) {
        return getResultById(id).getScore();
    }

    private ShotResult getResultById(int id) {
        return results.stream()
                .filter(i -> i.getId() == id)
                .findFirst()
                .get();
    }


}
