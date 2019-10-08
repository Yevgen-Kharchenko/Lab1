package vancoffee.service;

import vancoffee.model.Coffee;
import vancoffee.model.Stock;
import vancoffee.model.Van;

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
        System.out.print(message);
        int i = 0;
        while (i < 35) {
            System.out.print(".");
            TimeUnit.MILLISECONDS.sleep(30);
            i++;
        }
        System.out.print(" OK\n");
    }

    public void cleanConsole() {
        System.out.print("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
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
        if (goods.size() > 0) {
            for (Map.Entry<Coffee, Integer> entry : goods.entrySet()) {
                headInTable();
                System.out.println(entry.getKey());
                System.out.printf("Ви завантажили %s ящ. на загальну суму %s\n", entry.getValue().toString(), (entry.getValue() * entry.getKey().getPrice()));
                lineInTable(60);
            }
        } else {
            System.out.println("Вибраний товар відсутній у фургоні!");
        }
    }

    public void showGoodBye(String message) throws InterruptedException {
        char[] result = message.toCharArray();
        for (char c : result) {
            System.out.print(c);
            TimeUnit.MILLISECONDS.sleep(75);
        }

    }

    public void showTable(Van van, Stock stock) {
        cleanConsole();
        showBalances(van.getFreeWeight(), van.getFreeCapacity(), van.getPurchase().getBalance());
        showMessage("Товар відсортований по співвідношенню ціни до ваги");
        showAllProductsTable(stock.getProducts());
    }

    public void showSelectionTable(Stock stock, int art) {
        headInTable();
        showMessage(stock.getProductByArticle(art).toString());
        lineInTable(60);
    }
}
