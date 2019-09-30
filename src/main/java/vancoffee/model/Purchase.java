package vancoffee.model;

import java.util.HashMap;
import java.util.Map;

public class Purchase {
    private double deposit;
    private double loadedPrice;
    private Map<Coffee, Integer> goods = new HashMap<>();

    Purchase() {
    }

       public void setDeposit(double deposit) {
        this.deposit = deposit;
    }

       public void addGoods(Coffee coffee, int amount) {
        Integer storedAmount = goods.get(coffee);
        if (storedAmount == null) {
            goods.put(coffee, amount);
        } else {
            storedAmount += amount;
            goods.put(coffee, storedAmount);
        }
        loadedPrice += (coffee.getPrice() * amount);
    }

    public double getBalance() {
        return deposit - loadedPrice;
    }

    public double getLoadedPrice() {
        return loadedPrice;
    }

    public Map<Coffee, Integer> getGoods() {
        return goods;
    }
}
