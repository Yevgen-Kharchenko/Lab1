package vancoffee.exceptions;

import org.apache.log4j.Logger;

public class NoFreeBalanceException extends RuntimeException {
    private static final Logger LOG = Logger.getLogger(NoFreeBalanceException.class);

    public NoFreeBalanceException() {
        super(String.format("   УВАГА!\nВам бракує коштів для подальшого завантаження!"));
        LOG.error("invalid !! ");
    }
}
