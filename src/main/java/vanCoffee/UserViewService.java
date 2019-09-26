package vanCoffee;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class UserViewService {
    Scanner scanner = new Scanner(System.in);
    ;


    public void showMessage(String message) {
        System.out.println(message);
    }

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

    public void showDownload(String message) throws InterruptedException {
        System.out.printf(message);
        int i = 0;
        while (i < 30) {
            System.out.printf(".");
            TimeUnit.MILLISECONDS.sleep(1);
            i++;
        }
        System.out.printf(" OK\n");
    }

    public void cleanConsole() {
        System.out.printf("\n\n\n\n\n\n\n\n\n\n");
    }

    public void anyKeyInput() {
        System.out.println("Натисніть будь-яку кнопку для продовження");
        scanner.next();


    }
}



