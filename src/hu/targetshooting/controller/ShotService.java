package hu.targetshooting.controller;

import hu.targetshooting.model.domain.ShotResult;

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

    public String getTwoSuccessShotIds2() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < results.size(); i++) {
            ShotResult result = results.get(i);
            if (result.hasTwoSuccessShotsInRow()) {
                int id = result.getId();
                sb = sb.append(id).append(" ");
            }
        }
        return sb.toString();
    }
}
