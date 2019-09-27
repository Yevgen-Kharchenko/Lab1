package vancoffee;


import vancoffee.model.Coffee;
import vancoffee.model.Stock;
import vancoffee.model.Van;
import vancoffee.service.*;
import vancoffee.service.impl.DownloadVanServiceImpl;

public class App {
    private UserViewService userViewService;
    private UserInputService userInputService;
    private CreateProductService createProductService;
    private DownloadVanService downloadVanService;
    private SearchService searchService;
    private SortService sortService;

    private Van van;
    private Stock stock = new Stock();


    public static void main(String[] args) throws InterruptedException {
        App app = new App();
        app.setUserViewService(new UserViewService());
        app.setUserInputService(new UserInputService());
        app.setDownloadVanService(new DownloadVanServiceImpl());


        app.setupVanParameters();
        app.coffeeSales();
        app.productSearch();


    }


    private void setupVanParameters() {
        userViewService.showMessage("Ласкаво просимо на сторінку команії 'CoffeeOptTorg'!");
        int weight = userInputService.getUserInput("Введіть вантажопідйомність вашого автомобіля (кг):");
        int capacity = userInputService.getUserInput("Введіть об'єм вашого автомобіля (ящ):");
        double sum = userInputService.getUserInput("Введіть суму депозиту на яку бажаєте здійснити закупівлю (грн):");
        this.van = downloadVanService.createVan(weight, capacity);
        downloadVanService.setDeposit(van, sum);

        userInputService.anyKeyInput();
    }

    private void coffeeSales() {
        //Виводимо шапку з залишками
        // Виводимо шапку таблиці
        //Виводимо таблицю відсортованих видів з цінами

        for (Coffee coffee : stock.getProducts()) {
            System.out.println(coffee);
        }
        int art = userInputService.getUserInput("Введіть артикул вибраного товару");
        int amount = userInputService.getUserInput("Введіть кількість ящиків");


        try {
            downloadVanService.downloadGood(van, stock.getProductByArticle(art), amount);
        } catch (RuntimeException e) {
            userViewService.showMessage(e.getMessage());
        }

//        userViewService.showMessage("Ви придбали " + art + " в кількості" + quantity + "ящиків на суму:");
//        //цикл поки sum != 0
//        userViewService.showMessage("Ваш депозит: " + downloadVanService1.getDeposit() +
//                "   Залишок ваги: " + downloadVanService1.getCarrying() +
//                "   Залишок об'єму: " + downloadVanService1.getCapacity());
        userInputService.anyKeyInput();
    }

    private void productSearch() {
        boolean result = userInputService.showQuestion("Бажаєте знайти товар в своїй корзині?");// якщо да то на цикл ні- кінець
        System.out.println(result);
        int sort = userInputService.getUserInput("Введіть сорт кави який бажаєте знайти:");
        int type = userInputService.getUserInput("Введіть тип кави який бажаєте знайти:");
        // здійснюємо пошук за параметрами, якщо якогось параметра немає то виводим декілька товарів за одним параметром
        userViewService.showMessage("Ви придбали " + "sort" + type + "кави в кількості та на суму");
        // кінець циклу
        userViewService.showMessage("Дякуємо за покупку!");
        userInputService.anyKeyInput();
    }

    public void setUserViewService(UserViewService userViewService) {
        this.userViewService = userViewService;
    }

    public void setUserInputService(UserInputService userInputService) {
        this.userInputService = userInputService;
    }

    public void setCreateProductService(CreateProductService createProductService) {
        this.createProductService = createProductService;
    }

    public void setDownloadVanService(DownloadVanService downloadVanService) {
        this.downloadVanService = downloadVanService;
    }

    public void setSearchService(SearchService searchService) {
        this.searchService = searchService;
    }

    public void setSortService(SortService sortService) {
        this.sortService = sortService;
    }
}

