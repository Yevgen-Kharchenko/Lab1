package vanCoffee;

public class Van {
    private double deposit;
    private int carrying;
    private int capacity;

    public Van() {
    }

    public Van(double deposit, int carrying, int capacity) {
        this.deposit = deposit;
        this.carrying = carrying;
        this.capacity = capacity;
    }

    public void setDeposit(double deposit) {
        this.deposit = deposit;
    }

    public void setCarrying(int carrying) {
        this.carrying = carrying;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }


    public double getDeposit() {
        return deposit;
    }

    public int getCarrying() {
        return carrying;
    }

    public int getCapacity() {
        return capacity;
    }
}
