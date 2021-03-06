package vancoffee.model;

public class Van {
    private Purchase purchase = new Purchase();
    private final int maxWeight;
    private final int maxCapacity;
    private int loadedWeight;
    private int loadedCapacity;

    public Van(int maxWeight, int maxCapacity) {
        this.maxWeight = maxWeight;
        this.maxCapacity = maxCapacity;
    }

    public Purchase getPurchase() {
        return purchase;
    }

    public void setLoadedWeight(int loadedWeight) {
        this.loadedWeight += loadedWeight;
    }

    public void setLoadedCapacity(int loadedCapacity) {
        this.loadedCapacity += loadedCapacity;
    }

    public int getFreeCapacity() {
        return maxCapacity - loadedCapacity;
    }

    public int getFreeWeight() {
        return maxWeight - loadedWeight;
    }

}
