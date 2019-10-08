package vancoffee.exceptions;

public class NoItemSpecifiedException extends BaseException {
    public NoItemSpecifiedException(int amount) {
        super(String.format("Ведений вами %s артикул не існує.Спробуйте ще раз.", amount));
    }
}
