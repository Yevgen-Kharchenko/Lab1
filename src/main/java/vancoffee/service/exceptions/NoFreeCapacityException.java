package vancoffee.service.exceptions;

public class NoFreeCapacityException extends RuntimeException {
    public NoFreeCapacityException() {
        super(String.format("No free capacity in Van for load of coffee") );
    }
}
