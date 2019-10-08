package vancoffee.exceptions;

public class NoFreeBalanceException extends BaseException {
    public NoFreeBalanceException() {
        super(String.format("   УВАГА!\nВам бракує коштів для подальшого завантаження!"));
    }
}
