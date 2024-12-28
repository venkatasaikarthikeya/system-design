package LLD.B_design_patterns.behavioral.strategy.problem;

import LLD.B_design_patterns.behavioral.strategy.CommuteType;

public class StrategyApp {

    public static void main(String[] args) {
        // Take Google Maps as use case

        // User Enters the Source and Destination in app
        String source = "Long Beach";
        String destination = "San Francisco";

        // User Selects the commute type
        String commuteType = CommuteType.COMMUTE_TYPE_CAR;

        // Route Plotter object is created to find the shortest path
        RoutePlotter routePlotter = new RoutePlotter(source, destination, commuteType);

        // The Route Plotter computes the shortest path and returns the application a list of coordinates that the application plots
        System.out.println(routePlotter.plot()); // Plot, so that user can see it.

        // User selects another commute type through the icon in app
        routePlotter.setCommuteType(CommuteType.COMMUTE_TYPE_AIRPLANE);
        System.out.println(routePlotter.plot());
    }
}
