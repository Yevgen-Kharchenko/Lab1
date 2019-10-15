package vancoffee.exceptions;
import org.apache.log4j.Logger;

public class NoFreeCapacityException extends RuntimeException {
    private static final Logger LOG = Logger.getLogger(NoFreeCapacityException.class);
    public NoFreeCapacityException() {
        super(String.format("   УВАГА!\nФургону бракує об'єму для подальшого завантаження!"));
        LOG.error("invalid !! ");
    }
}
