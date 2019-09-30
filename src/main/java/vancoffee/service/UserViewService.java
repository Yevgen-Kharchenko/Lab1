package vancoffee.service;

import vancoffee.model.Coffee;

import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class UserViewService {

    public void showMessage(String message) {
        System.out.println(message);
    }

    public void lineInTable(int length) {
        for (int i = 1; i < length; i++) {
            System.out.printf("%s", "-");
        }
        System.out.println();
    }

    public void headInTable() {
        lineInTable(60);
        System.out.println("| Арт |   Сорт   |      Тип кави     |Вага (кг)|Ціна (грн)|");
        lineInTable(60);
    }

    public void showDownload(String message) throws InterruptedException {
        System.out.printf(message);
        int i = 0;
        while (i < 35) {
            System.out.printf(".");
            TimeUnit.MILLISECONDS.sleep(30);
            i++;
        }
        System.out.printf(" OK\n");
    }

    public void cleanConsole() {
        System.out.printf("\n\n\n\n\n\n\n\n\n\n\n\n\n");
    }

    public void showBalances(int weight, int capacity, double deposit) {
        System.out.printf("Ліміт ваги %18d кг.\nЛіміт об'єму %16d ящ.\nЛіміт коштів %15s грн.\n", weight, capacity, deposit);
    }

    public void showAllProductsTable(List<Coffee> products) {
        headInTable();
        for (Coffee coffee : products) {
            System.out.println(coffee);
            lineInTable(60);
        }
    }

    public void showFoundProductsTable(Map<Coffee, Integer> goods) {
        headInTable();
        for (Map.Entry<Coffee, Integer> entry : goods.entrySet()) {
            System.out.println(entry.getKey() + entry.getValue().toString());
            lineInTable(60);
        }
    }
}
