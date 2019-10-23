package vancoffee.entity;

public class CoffeeType {
    private int id;
    private String type;
    private int weight;

    public CoffeeType(int id, String type, int weight) {
        this.id = id;
        this.type = type;
        this.weight = weight;
    }

    public int getWeight() {
        return weight;
    }

    public String getType() {
        return type;
    }

    public int getId() {
        return id;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setType(String type) {
        this.type = type;
    }
}
