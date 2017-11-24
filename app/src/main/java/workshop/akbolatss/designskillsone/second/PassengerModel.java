package workshop.akbolatss.designskillsone.second;

/**
 * Author: Akbolat Sadvakassov
 * Date: 25.11.2017
 */

public class PassengerModel {
    private String name;
    private String id;

    public PassengerModel(String name, String id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }
}
