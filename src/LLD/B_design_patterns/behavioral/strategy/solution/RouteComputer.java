package LLD.B_design_patterns.behavioral.strategy.solution;

import java.util.List;

public interface RouteComputer {
    List<Integer> computeRoute(String source, String destination);
}