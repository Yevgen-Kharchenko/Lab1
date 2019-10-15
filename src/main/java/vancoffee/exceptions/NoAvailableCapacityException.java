package vancoffee.exceptions;

import org.apache.log4j.Logger;
import vancoffee.model.Coffee;

public class NoAvailableCapacityException extends RuntimeException {
    private static final Logger LOG = Logger.getLogger(NoAvailableCapacityException.class);

    public NoAvailableCapacityException(Coffee coffee, int amount) {
        super(String.format("Фургону бракує об'єму для завантаження %s ящ. %s %s", amount, coffee.getName(), coffee.getType()));
        LOG.error("invalid !! ");
    }
}
