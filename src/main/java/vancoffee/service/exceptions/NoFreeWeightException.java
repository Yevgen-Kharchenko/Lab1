package vancoffee.service.exceptions;
import vancoffee.model.Coffee;

public class NoFreeWeightException extends RuntimeException {
    public NoFreeWeightException() {
        super(String.format("No free weight in Van for load of coffee") );
    }
}
