package hu.targetshooting.model.service;

import hu.targetshooting.model.domain.ShotResult;

import java.util.List;
import java.util.stream.Collectors;

public class DataParser {

    private int id;

    public List<ShotResult> parse(List<String> lines) {
        lines.remove(0);
        return lines.stream()
                .map(line -> new ShotResult(++id, line))
                .collect(Collectors.toList());
    }
}
