package vanCoffee;

import java.io.IOException;

public class App {
    private UserViewService userViewService;

    public static void main(String[] args) throws IOException, InterruptedException {
        App app = new App();
        app.setUserViewService(new UserViewService());

        app.setupPrice();
        app.setupVanParameters();
        app.coffeeSales();
        app.productSearch();


    }


    private void setupPrice() throws InterruptedException {
        userViewService.showMessage("УВАГА! АДМІНІСТРАТИВНА СТОРІНКА! ВСТАНОВЛЮЄМО ПРОДАЖНІ ЦІНИ!");
        int price = userViewService.getUserInput("Введіть ціну 1 кг кави сорту " + "Aрабіка");
        /*тут повинен бути цикл щоб призначити ціну всім сортам*/
        userViewService.showMessage("ОЧІКУЙТЕ! ЙДЕ ОБРОБКА ДАНИХ!");
        userViewService.showDownload("ДОСТАВКА ");
        userViewService.showDownload("ОБЖАРКА  ");
        userViewService.showDownload("ПОМОЛ    ");
        userViewService.showDownload("ПАКУВАННЯ");
        userViewService.showDownload("НА СКЛАД ");
        userViewService.showMessage("Дякуємо за очікування!");
        userViewService.anyKeyInput();
        //створюємо об'єкти, призначаємо параметри ціни, ваги тощо.
    }

    private void setupVanParameters() {
        userViewService.cleanConsole();
        userViewService.showMessage("Ласкаво просимо на сторінку команії 'CoffeeOptTorg'!");
        int sum = userViewService.getUserInput("Введіть суму депозиту на яку бажаєте здійснити закупівлю (грн):");
        int weight = userViewService.getUserInput("Введіть вантажопідйомність вашого автомобіля (кг):");
        int capacity = userViewService.getUserInput("Введіть об'єм вашого автомобіля (ящ):");
        userViewService.cleanConsole();
        userViewService.showMessage("Ваш депозит: " + sum + "   Залишок ваги: " + weight + "   Залишок об'єму: " + capacity);
        userViewService.anyKeyInput();
    }

    private void coffeeSales() {
        //Виводимо шапку з залишками
        // Виводимо шапку таблиці
        //Виводимо таблицю відсортованих видів з цінами
        int art = userViewService.getUserInput("Введіть артикул вибраного товару");
        int quantity = userViewService.getUserInput("Введіть кількість ящиків");
        userViewService.showMessage("Ви придбали " + art + " в кількості" + quantity + "ящиків на суму:");
        //цикл поки sum != 0
        userViewService.anyKeyInput();
    }

    private void productSearch() {
        boolean result = userViewService.showQuestion("Бажаєте знайти товар в своїй корзині?");// якщо да то на цикл ні- кінець
        System.out.println(result);
        int sort = userViewService.getUserInput("Введіть сорт кави який бажаєте знайти:");
        int type = userViewService.getUserInput("Введіть тип кави який бажаєте знайти:");
        // здійснюємо пошук за параметрами, якщо якогось параметра немає то виводим декілька товарів за одним параметром
        userViewService.showMessage("Ви придбали " + "sort" + type + "кави в кількості та на суму");
        // кінець циклу
        userViewService.showMessage("Дякуємо за покупку!");
        userViewService.anyKeyInput();
    }

    public void setUserViewService(UserViewService userViewService) {
        this.userViewService = userViewService;
    }


}

