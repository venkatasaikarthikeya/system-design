package LLD.B_design_patterns.behavioral.strategy.solution;

import java.util.ArrayList;
import java.util.List;

public class RoutePlotter {

    private String source;
    private String destination;
    private RouteComputer routeComputingStrategy;

    public RoutePlotter(String source, String destination) {
        this.source = source;
        this.destination = destination;
    }

    public RouteComputer getRouteComputingStrategy() {
        return routeComputingStrategy;
    }

    public void setRouteComputingStrategy(RouteComputer routeComputingStrategy) {
        this.routeComputingStrategy = routeComputingStrategy;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public List<Integer> plotRoute() {
        return routeComputingStrategy.computeRoute(this.source, this.destination);
    }
}

class CarRouteComputingStrategy implements RouteComputer {

    @Override
    public List<Integer> computeRoute(String source, String destination) {
        ArrayList<Integer> coordinates = new ArrayList<>();
        for (int i = 1; i < 50; i = i + 5)
            coordinates.add(i);
        return coordinates;
    }
}

class PublicTransportRouteComputingStrategy implements RouteComputer {

    @Override
    public List<Integer> computeRoute(String source, String destination) {
        ArrayList<Integer> coordinates = new ArrayList<>();
        for (int i = 1; i < 50; i = i + 3)
            coordinates.add(i);
        return coordinates;
    }
}

class WalkRouteComputingStrategy implements RouteComputer {

    @Override
    public List<Integer> computeRoute(String source, String destination) {
        ArrayList<Integer> coordinates = new ArrayList<>();
        for (int i = 1; i < 50; i = i + 1)
            coordinates.add(i);
        return coordinates;
    }
}

class BicycleRouteComputingStrategy implements RouteComputer {

    @Override
    public List<Integer> computeRoute(String source, String destination) {
        ArrayList<Integer> coordinates = new ArrayList<>();
        for (int i = 1; i < 50; i = i + 2)
            coordinates.add(i);
        return coordinates;
    }
}

class CabRouteComputingStrategy implements RouteComputer {

    @Override
    public List<Integer> computeRoute(String source, String destination) {
        ArrayList<Integer> coordinates = new ArrayList<>();
        for (int i = 1; i < 50; i = i + 6)
            coordinates.add(i);
        return coordinates;
    }
}

class AirplaneRouteComputingStrategy implements RouteComputer {

    @Override
    public List<Integer> computeRoute(String source, String destination) {
        ArrayList<Integer> coordinates = new ArrayList<>();
        for (int i = 1; i < 50; i = i + 25)
            coordinates.add(i);
        return coordinates;
    }
}
