package vancoffee.service.exceptions;

import vancoffee.model.Coffee;

public class NoAvailableWeightException extends RuntimeException {
    public NoAvailableWeightException(Coffee coffee, int amount) {
        super(String.format("No free weight in Van for load %s of coffee %s", amount, coffee) );
    }
}
