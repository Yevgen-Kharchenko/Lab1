package vancoffee.exceptions;

import org.apache.log4j.Logger;

public class NoItemSpecifiedException extends RuntimeException {
    private static final Logger LOG = Logger.getLogger(NoItemSpecifiedException.class);

    public NoItemSpecifiedException(int amount) {
        super(String.format("Ведений вами %s артикул не існує.Спробуйте ще раз.", amount));
        LOG.error("invalid !! ");
    }
}
