package LLD.B_design_patterns.behavioral.strategy.solution;

public class StrategyMain {

    public static void main(String[] args) {
        // Take Google Maps as use case

        // User Enters the Source and Destination in app
        String source = "Long Beach";
        String destination = "San Francisco";

        // Route Plotter object is created to find the shortest path
        RoutePlotter routePlotter = new RoutePlotter(source, destination);

        // User Selects the commute type - based on the commute type this object will be created dynamically at runtime
        CarRouteComputingStrategy carRouteComputingStrategy = new CarRouteComputingStrategy();
        routePlotter.setRouteComputingStrategy(carRouteComputingStrategy);
        System.out.println(routePlotter.plotRoute());

        // User Selects another commute type
        AirplaneRouteComputingStrategy airplaneRouteComputingStrategy = new AirplaneRouteComputingStrategy();
        routePlotter.setRouteComputingStrategy(airplaneRouteComputingStrategy);
        System.out.println(routePlotter.plotRoute());
    }
}
