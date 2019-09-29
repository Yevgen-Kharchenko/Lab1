package vancoffee.model;

import java.util.HashMap;
import java.util.Map;

public class Purchase {
    private double deposit;
    private double loadedPrice;
    private Map<Coffee, Integer> goods = new HashMap<>();

    public Purchase() {
    }

    public Purchase(double deposit) {
        this.deposit = deposit;
    }

    public void setDeposit(double deposit) {
        this.deposit = deposit;
    }

    public double getDeposit() {
        return deposit;
    }

    public void addGoods(Coffee coffee, int amount) {
        goods.get(coffee);
        loadedPrice += (coffee.getPrice() * amount);
    }

    public double getBalance(){
        return deposit-loadedPrice;
    }

    public double getLoadedPrice() {
        return loadedPrice;
    }
}

