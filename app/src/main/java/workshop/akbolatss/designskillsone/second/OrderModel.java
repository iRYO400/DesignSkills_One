package workshop.akbolatss.designskillsone.second;

/**
 * Author: Akbolat Sadvakassov
 * Date: 24.11.2017
 */

public class OrderModel {

    private String flightNum;
    private String companyLogo;
    private String flightName;
    private String startTime;
    private String startCityCode;
    private String startDate;

    private String flightTime;

    private String endTime;
    private String endCityCode;
    private String endDate;

    private boolean isHaveWaitTime;
    private String waitTime;

    public OrderModel(String flightNum, String companyLogo, String flightName, String startTime, String startCityCode, String startDate, String flightTime, String endTime, String endCityCode, String endDate, boolean isHaveWaitTime, String waitTime) {
        this.flightNum = flightNum;
        this.companyLogo = companyLogo;
        this.flightName = flightName;
        this.startTime = startTime;
        this.startCityCode = startCityCode;
        this.startDate = startDate;
        this.flightTime = flightTime;
        this.endTime = endTime;
        this.endCityCode = endCityCode;
        this.endDate = endDate;
        this.isHaveWaitTime = isHaveWaitTime;
        this.waitTime = waitTime;
    }

    public String getFlightNum() {
        return flightNum;
    }


    public String getCompanyLogo() {
        return companyLogo;
    }

    public String getFlightName() {
        return flightName;
    }

    public String getStartTime() {
        return startTime;
    }

    public String getStartCityCode() {
        return startCityCode;
    }

    public String getStartDate() {
        return startDate;
    }

    public String getFlightTime() {
        return flightTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public String getEndCityCode() {
        return endCityCode;
    }

    public String getEndDate() {
        return endDate;
    }

    public boolean isHaveWaitTime() {
        return isHaveWaitTime;
    }

    public String getWaitTime() {
        return waitTime;
    }
}
