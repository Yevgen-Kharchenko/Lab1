package vancoffee.service.exceptions;
import vancoffee.model.Coffee;

public class NoItemSpecifiedException extends RuntimeException {
    public NoItemSpecifiedException(int amount) {
        super(String.format("Ведений вами %s артикул не існує.Спробуйте ще раз.", amount) );
    }
}
