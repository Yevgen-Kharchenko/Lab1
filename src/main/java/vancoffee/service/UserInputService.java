package vancoffee.service;

import java.util.Scanner;

public class UserInputService {

    private Scanner scanner = new Scanner(System.in);
    private String error = " ВІДПОВІДЬ НЕ ПРАВИЛЬНА!\nБудьте уважнішим при введені!\n";

    public boolean showQuestion(String message) {
        while (true) {
            System.out.println(message);
            System.out.println();
            System.out.println("     < 1 - Так >     < 0 - Ні >");
            int answer = scanner.nextInt();
            if (answer == 1) {
                return true;
            } else if (answer == 0) {
                return false;
            } else {
                System.out.print(error);
            }
        }
    }

    public int getUserInput(String message) {
        System.out.println(message);
        int i;
        while (true) {
            i = Integer.parseInt(scanner.next());
            if (i > 0) {
                break;
            } else {
                System.out.print(error);
            }
        }
        return i;
    }

    public int validateInputUserService(String message, int option) {
        int value;
        while (true) {
            value = getUserInput(message);
            if (value > 0 && value <= option) {
                break;
            } else {
                System.out.print(error);
            }
        }
        return value;
    }
}
