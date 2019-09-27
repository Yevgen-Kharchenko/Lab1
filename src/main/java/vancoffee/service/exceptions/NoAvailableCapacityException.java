package vancoffee.service.exceptions;

import vancoffee.model.Coffee;

public class NoAvailableCapacityException extends RuntimeException {
    public NoAvailableCapacityException(Coffee coffee, int amount) {
        super(String.format("No free capacity in Van for load %s of coffee %s", amount, coffee) );
    }
}
