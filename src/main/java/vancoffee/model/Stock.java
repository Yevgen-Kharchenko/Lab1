package vancoffee.model;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Stock {

    private final List<Coffee> products = Arrays.asList(

            new Coffee(1, 23.45, 30, CoffeeSort.ARABICA, CoffeeType.BEANS),
            new Coffee(2, 23.45, 30, CoffeeSort.ARABICA, CoffeeType.GROUND),
            new Coffee(3, 23.45, 30, CoffeeSort.ARABICA, CoffeeType.JAR),
            new Coffee(4, 23.45, 30, CoffeeSort.ARABICA, CoffeeType.STICK),

            new Coffee(5, 23.45, 30, CoffeeSort.LIBERICA, CoffeeType.BEANS),
            new Coffee(6, 23.45, 30, CoffeeSort.LIBERICA, CoffeeType.GROUND),
            new Coffee(7, 23.45, 30, CoffeeSort.LIBERICA, CoffeeType.JAR),
            new Coffee(8, 23.45, 30, CoffeeSort.LIBERICA, CoffeeType.STICK),

            new Coffee(9, 23.45, 30, CoffeeSort.ROBUSTA, CoffeeType.BEANS),
            new Coffee(10, 23.45, 30, CoffeeSort.ROBUSTA, CoffeeType.GROUND),
            new Coffee(11, 23.45, 30, CoffeeSort.ROBUSTA, CoffeeType.JAR),
            new Coffee(12, 23.45, 30, CoffeeSort.ROBUSTA, CoffeeType.STICK)
    );

    public Stock() {
        Collections.sort(products, (o1, o2) -> (int) (o1.getCorrelation() * 100) - (int) (o2.getCorrelation() * 100));
    }

    public Coffee getProductByArticle(int art) {
        return products.get(art - 1);
    }

    public List<Coffee> getProducts() {
        return products;
    }
}
