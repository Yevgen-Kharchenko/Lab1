package vancoffee.service.exceptions;

import vancoffee.model.Coffee;

public class SmallBalanceException extends RuntimeException {
    public SmallBalanceException(Coffee coffee, int amount) {
        super(String.format("Small balance for this Purchase for load %s of coffee %s", amount, coffee) );
    }
}
