package vancoffee.exceptions;

import vancoffee.model.Coffee;

public class SmallBalanceException extends RuntimeException {
    public SmallBalanceException(Coffee coffee, int amount) {
        super(String.format("Не вистачає коштів для завантаження %s ящ. %s %s", amount, coffee.getName(), coffee.getType()));
    }
}
