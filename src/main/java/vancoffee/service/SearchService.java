package vancoffee.service;

import vancoffee.model.Coffee;
import vancoffee.model.CoffeeSort;
import vancoffee.model.Van;

import java.util.Map;

public interface SearchService {

    Map<Coffee, Integer> search(Van van, int coffeeSort, int coffeeType);
}
