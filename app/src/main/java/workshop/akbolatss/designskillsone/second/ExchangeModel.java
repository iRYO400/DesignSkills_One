package workshop.akbolatss.designskillsone.second;

/**
 * Author: Akbolat Sadvakassov
 * Date: 24.11.2017
 */

public class ExchangeModel {

    private String number;
    private String name;
    private String description;
    private int type;
    private boolean isPassed;
    private String date;

    public ExchangeModel(String number, String name, String description, int type, boolean isPassed, String date) {
        this.number = number;
        this.name = name;
        this.description = description;
        this.type = type;
        this.isPassed = isPassed;
        this.date = date;
    }

    public String getNumber() {
        return number;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getType() {
        return type;
    }

    public boolean isPassed() {
        return isPassed;
    }

    public String getDate() {
        return date;
    }
}
