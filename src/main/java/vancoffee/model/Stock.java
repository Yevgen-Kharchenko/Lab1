package vancoffee.model;

import vancoffee.service.exceptions.NoItemSpecifiedException;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Stock {

    private final List<Coffee> products = Arrays.asList(

            new Coffee(1, 2450, 10, CoffeeSort.ARABICA, CoffeeType.BEANS),
            new Coffee(2, 2340, 9, CoffeeSort.ARABICA, CoffeeType.GROUND),
            new Coffee(3, 1600, 8, CoffeeSort.ARABICA, CoffeeType.JAR),
            new Coffee(4, 1610, 7, CoffeeSort.ARABICA, CoffeeType.STICK),

            new Coffee(5, 2200, 10, CoffeeSort.LIBERICA, CoffeeType.BEANS),
            new Coffee(6, 2295, 9, CoffeeSort.LIBERICA, CoffeeType.GROUND),
            new Coffee(7, 1520, 8, CoffeeSort.LIBERICA, CoffeeType.JAR),
            new Coffee(8, 1470, 7, CoffeeSort.LIBERICA, CoffeeType.STICK),

            new Coffee(9, 2100, 10, CoffeeSort.ROBUSTA, CoffeeType.BEANS),
            new Coffee(10, 2250, 9, CoffeeSort.ROBUSTA, CoffeeType.GROUND),
            new Coffee(11, 1440, 8, CoffeeSort.ROBUSTA, CoffeeType.JAR),
            new Coffee(12, 1330, 7, CoffeeSort.ROBUSTA, CoffeeType.STICK)
    );

    public Stock() {
        Collections.sort(products, (o1, o2) -> (int) (o1.getCorrelation() * 100) - (int) (o2.getCorrelation() * 100));
    }


    public Coffee getProductByArticle(int art) {
        for (Coffee coffee : products) {
            if (art == coffee.getArt()) {
                return coffee;
            }
        }
        throw new NoItemSpecifiedException(art);
    }

    public List<Coffee> getProducts() {
        return products;
    }
    public String getNameByArticle(int art) {
        for (Coffee coffee : products) {
            if (art == coffee.getArt()) {
                return coffee.getName()+" "+coffee.getType();
            }
        }
        throw new NoItemSpecifiedException(art);
    }
}
