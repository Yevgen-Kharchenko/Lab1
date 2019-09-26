package vanCoffee;

import java.util.Scanner;

public class UserInputService {

   private Scanner scanner = new Scanner(System.in);

    public boolean showQuestion(String message) {
        while (true) {
            System.out.println(message);
            System.out.println("     < 1 - Так >     < 0 - Ні >");
            int answer = scanner.nextInt();
            if (answer == 1) {
                return true;
            } else if (answer == 0) {
                return false;
            } else {
                System.out.printf("ВІДПОВІДЬ НЕ ПРАВИЛЬНА!\n Будьте уважнішим при введені відповіді!\n");
            }
        }

    }
    public int getUserInput(String message) {
        System.out.println(message);
        int i = Integer.parseInt(scanner.next());
        return i;
    }
    public void anyKeyInput() {
        System.out.println("Натисніть будь-яку кнопку для продовження");
        scanner.next();


    }
}
