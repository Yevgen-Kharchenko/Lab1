public abstract class Coffee {
    int id;
    double price;
    int weight;
    int capacity;
    String name;
    String type;
    double correlation;

    public double getPrice() {
        return price;
    }

    public int getWeight() {
        return weight;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
}
