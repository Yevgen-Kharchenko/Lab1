package vancoffee.exceptions;

import vancoffee.model.Coffee;

public class NoAvailableCapacityException extends RuntimeException {
    public NoAvailableCapacityException(Coffee coffee, int amount) {
        super(String.format("Фургону бракує об'єму для завантаження %s ящ. %s %s", amount, coffee.getName(), coffee.getType()));
    }
}
