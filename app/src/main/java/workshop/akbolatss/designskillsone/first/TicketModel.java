package workshop.akbolatss.designskillsone.first;

import java.util.List;

/**
 * Author: Akbolat Sadvakassov
 * Date: 23.11.2017
 */

public class TicketModel {

    private String number;
    private String date;
    private boolean isPassed;
    private boolean isPending;
    private List<FlightModel> flightModels;

    public TicketModel(String number, String date, boolean isPassed, boolean isPending, List<FlightModel> flightModels) {
        this.number = number;
        this.date = date;
        this.isPassed = isPassed;
        this.isPending = isPending;
        this.flightModels = flightModels;
    }

    public String getNumber() {
        return number;
    }

    public String getDate() {
        return date;
    }

    public boolean isPassed() {
        return isPassed;
    }

    public boolean isPending() {
        return isPending;
    }

    public List<FlightModel> getFlightModels() {
        return flightModels;
    }
}
