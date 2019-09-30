package vancoffee.exceptions;

public class NoItemSpecifiedException extends RuntimeException {
    public NoItemSpecifiedException(int amount) {
        super(String.format("Ведений вами %s артикул не існує.Спробуйте ще раз.", amount));
    }
}
