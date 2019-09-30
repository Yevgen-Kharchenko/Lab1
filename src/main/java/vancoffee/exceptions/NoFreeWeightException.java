package vancoffee.exceptions;

public class NoFreeWeightException extends RuntimeException {
    public NoFreeWeightException() {
        super(String.format("   УВАГА!\nЛіміт ваги вичерпано!"));
    }
}
