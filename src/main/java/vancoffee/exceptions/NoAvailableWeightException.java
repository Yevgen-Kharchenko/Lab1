package vancoffee.exceptions;

import org.apache.log4j.Logger;
import vancoffee.model.Coffee;

public class NoAvailableWeightException extends RuntimeException {
    private static final Logger LOG = Logger.getLogger(NoAvailableCapacityException.class);

    public NoAvailableWeightException(Coffee coffee, int amount) {
        super(String.format("Фургону бракує вагового ліміту для завантаження %s ящ. %s %s", amount, coffee.getName(), coffee.getType()));
        LOG.error("invalid !! ");
    }

}
