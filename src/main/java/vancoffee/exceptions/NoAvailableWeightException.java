package vancoffee.exceptions;

import vancoffee.model.Coffee;

public class NoAvailableWeightException extends BaseException {
    public NoAvailableWeightException(Coffee coffee, int amount) {
        super(String.format("Фургону бракує вагового ліміту для завантаження %s ящ. %s %s", amount, coffee.getName(), coffee.getType()));
    }
}
