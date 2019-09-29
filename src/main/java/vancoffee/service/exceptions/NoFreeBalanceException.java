package vancoffee.service.exceptions;

public class NoFreeBalanceException extends RuntimeException {
    public NoFreeBalanceException() {
        super(String.format("No free capacity in Van for load of coffee") );
    }
}
