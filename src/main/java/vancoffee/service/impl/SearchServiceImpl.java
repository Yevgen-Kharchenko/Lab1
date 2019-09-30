package vancoffee.service.impl;

import vancoffee.model.Coffee;
import vancoffee.model.Van;
import vancoffee.service.SearchService;

import java.util.HashMap;
import java.util.Map;

public class SearchServiceImpl implements SearchService {
    @Override
    public Map<Coffee, Integer> search(Van van, int coffeeSort, int coffeeType) {
        Map<Coffee, Integer> goods = van.getPurchase().getGoods();
        Map<Coffee, Integer> foundGoods = new HashMap<>();
        for (Map.Entry<Coffee, Integer> currentEntry : goods.entrySet()) {
            if (coffeeSort == 4) {
                if (currentEntry.getKey().getCoffeeType().getTypeId() == coffeeType) {
                    foundGoods.put(currentEntry.getKey(), currentEntry.getValue());
                }
            }
            if (coffeeType == 5) {
                if (currentEntry.getKey().getCoffeeSort().getSortId() == coffeeSort) {
                    foundGoods.put(currentEntry.getKey(), currentEntry.getValue());
                }
            }
            if ((currentEntry.getKey().getCoffeeSort().getSortId() == coffeeSort)
                    && (currentEntry.getKey().getCoffeeType().getTypeId() == coffeeType)) {
                foundGoods.put(currentEntry.getKey(), currentEntry.getValue());
            }
            if ((coffeeSort == 4) && (coffeeType == 5)) {
                foundGoods.put(currentEntry.getKey(), currentEntry.getValue());
            }
        }

        return foundGoods;
    }
}
