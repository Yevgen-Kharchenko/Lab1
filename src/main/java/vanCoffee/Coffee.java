package vanCoffee;

public abstract class Coffee {
    protected int id;
    protected double price;
    protected int weight;
    protected CoffeeSort name;
    protected CoffeeType type;


    public double getPrice() {
        return price;
    }

    public int getWeight() {
        return weight;
    }

       public void setPrice(double price) {
        this.price = price;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getId() {
        return id;
    }

    public CoffeeSort getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setType(String type) {
        this.type = type;
    }
}
