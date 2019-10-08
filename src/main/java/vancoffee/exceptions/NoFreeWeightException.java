package vancoffee.exceptions;

public class NoFreeWeightException extends BaseException {
    public NoFreeWeightException() {
        super(String.format("   УВАГА!\nЛіміт ваги вичерпано!"));
    }
}
