package vancoffee.exceptions;

public class NoFreeCapacityException extends RuntimeException {
    public NoFreeCapacityException() {
        super(String.format("   УВАГА!\nФургону бракує об'єму для подальшого завантаження!"));
    }
}
