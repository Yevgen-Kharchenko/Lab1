package vanCoffee;

import java.util.HashMap;
import java.util.Map;

public class Purchase {
    private double deposit;
    private Map<Coffee,Integer> goods = new HashMap<>();

    public Purchase(double deposit) {
        this.deposit = deposit;
    }

    public double getDeposit() {
        return deposit;
    }
    private void addGoods(Coffee coffee,int amount){
        goods.get(coffee);
    }
}

