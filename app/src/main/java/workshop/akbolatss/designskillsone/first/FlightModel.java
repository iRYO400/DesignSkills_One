package workshop.akbolatss.designskillsone.first;

/**
 * Author: Akbolat Sadvakassov
 * Date: 23.11.2017
 */

public class FlightModel {

    private String name;
    private String flight;

    public FlightModel(String name, String flight) {
        this.name = name;
        this.flight = flight;
    }

    public String getName() {
        return name;
    }

    public String getFlight() {
        return flight;
    }
}
