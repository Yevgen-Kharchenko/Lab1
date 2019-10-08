package vancoffee.model;

import java.util.Objects;

public final class Coffee {
    private final int art;
    private final double price;
    private final int weight;
    private final CoffeeSort name;
    private final CoffeeType type;

    public Coffee(int art, double price, int weight, CoffeeSort name, CoffeeType type) {
        if (weight == 0) throw new RuntimeException("Weight can't be 0");
        this.art = art;
        this.price = price;
        this.weight = weight;
        this.name = name;
        this.type = type;
    }

    double getCorrelation() {
        if (weight == 0) throw new RuntimeException("Weight can't be 0");
        return price / weight;
    }

    int getArt() {
        return art;
    }

    public double getPrice() {
        return price;
    }

    public int getWeight() {
        return weight;
    }

    public String getName() {
        return name.getSortName();
    }

    public String getType() {
        return type.getTypeName();
    }

    public CoffeeSort getCoffeeSort() {
        return name;
    }

    public CoffeeType getCoffeeType() {
        return type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coffee coffee = (Coffee) o;
        return art == coffee.art &&
                Double.compare(coffee.price, price) == 0 &&
                weight == coffee.weight &&
                name == coffee.name &&
                type == coffee.type;
    }

    @Override
    public int hashCode() {
        return Objects.hash(art, price, weight, name, type);
    }

    @Override
    public String toString() {
        return (String.format("| %-3s | %-8s | %-17s | %7s | %8s |", art, name, type, weight, price));
    }
}
