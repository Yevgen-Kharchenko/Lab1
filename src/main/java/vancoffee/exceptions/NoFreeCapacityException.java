package vancoffee.exceptions;

public class NoFreeCapacityException extends BaseException {
    public NoFreeCapacityException() {
        super(String.format("   УВАГА!\nФургону бракує об'єму для подальшого завантаження!"));
    }
}
