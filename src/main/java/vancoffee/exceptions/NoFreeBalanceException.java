package vancoffee.exceptions;

public class NoFreeBalanceException extends RuntimeException {
    public NoFreeBalanceException() {
        super(String.format("   УВАГА!\nВам бракує коштів для подальшого завантаження!"));
    }
}
