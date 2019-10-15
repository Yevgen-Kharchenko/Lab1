package vancoffee.exceptions;

import org.apache.log4j.Logger;
import vancoffee.model.Coffee;

public class SmallBalanceException extends RuntimeException {
    private static final Logger LOG = Logger.getLogger(NoAvailableCapacityException.class);

    public SmallBalanceException(Coffee coffee, int amount) {
        super(String.format("Не вистачає коштів для завантаження %s ящ. %s %s", amount, coffee.getName(), coffee.getType()));
        LOG.error("invalid !! ");
    }
}
