package vancoffee.exceptions;

import org.apache.log4j.Logger;

public class NoFreeWeightException extends RuntimeException {
    private static final Logger LOG = Logger.getLogger(NoFreeWeightException.class);

    public NoFreeWeightException() {
        super(String.format("   УВАГА!\nЛіміт ваги вичерпано!"));
        LOG.error("invalid !! ");
    }
}
