package LLD.B_design_patterns.behavioral.strategy.problem;

import LLD.B_design_patterns.behavioral.strategy.CommuteType;

import java.util.ArrayList;
import java.util.List;

public class RoutePlotter {

    private String commuteType;
    private String source;
    private String destination;

    public RoutePlotter(String source, String destination, String commuteType) {
        this.source = source;
        this.destination = destination;
        this.commuteType = commuteType;
    }

    public String getCommuteType() {
        return commuteType;
    }

    public void setCommuteType(String commuteType) {
        this.commuteType = commuteType;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public List<Integer> plot() {
        ArrayList<Integer> coordinates = new ArrayList<>();
        switch (commuteType) {
            case CommuteType.COMMUTE_TYPE_CAR:
                for (int i = 1; i < 50; i = i + 5)
                    coordinates.add(i);
                break;
            case CommuteType.COMMUTE_TYPE_PUBLIC_TRANSPORT:
                for (int i = 1; i < 50; i = i + 3)
                    coordinates.add(i);
                break;
            case CommuteType.COMMUTE_TYPE_WALK:
                for (int i = 1; i < 50; i = i + 1)
                    coordinates.add(i);
                break;
            case CommuteType.COMMUTE_TYPE_BICYCLE:
                for (int i = 1; i < 50; i = i + 2)
                    coordinates.add(i);
                break;
            case CommuteType.COMMUTE_TYPE_CAB:
                for (int i = 1; i < 50; i = i + 6)
                    coordinates.add(i);
                break;
            case CommuteType.COMMUTE_TYPE_AIRPLANE:
                for (int i = 1; i < 50; i = i + 25)
                    coordinates.add(i);
                break;
            default: // Consider CAR by default
                for (int i = 1; i < 50; i = i + 5)
                    coordinates.add(i);
        }
        return coordinates;
    }
}
