package vanCoffee;


public class App {
    private UserViewService userViewService;
    private UserInputService userInputService;
    private CreateProductService createProductService;
    private DownloadVanService downloadVanService;
    private SearchService searchService;
    private SortService sortService;


    public static void main(String[] args) throws InterruptedException {
        App app = new App();
        app.setUserViewService(new UserViewService());
        app.setUserInputService(new UserInputService());


        app.setupPrice();
        app.setupVanParameters();
        app.coffeeSales();
        app.productSearch();


    }


    private void setupPrice() throws InterruptedException {
        System.out.println(downloadVanService.getCapacity());
        userViewService.showMessage("УВАГА! АДМІНІСТРАТИВНА СТОРІНКА! ВСТАНОВЛЮЄМО ПРОДАЖНІ ЦІНИ!");
        int price = userInputService.getUserInput("Введіть ціну 1 кг кави сорту " + "Aрабіка");
        /*тут повинен бути цикл щоб призначити ціну всім сортам*/
        userViewService.showMessage("ОЧІКУЙТЕ! ЙДЕ ОБРОБКА ДАНИХ!");
        userViewService.showDownload("ДОСТАВКА ");
        userViewService.showDownload("ОБЖАРКА  ");
        userViewService.showDownload("ПОМОЛ    ");
        userViewService.showDownload("ПАКУВАННЯ");
        userViewService.showDownload("НА СКЛАД ");
        userViewService.showMessage("Дякуємо за очікування!");
        userInputService.anyKeyInput();

        //створюємо об'єкти, призначаємо параметри ціни, ваги тощо.
    }

    private void setupVanParameters() {
        userViewService.cleanConsole();
        userViewService.showMessage("Ласкаво просимо на сторінку команії 'CoffeeOptTorg'!");

        int weight = userInputService.getUserInput("Введіть вантажопідйомність вашого автомобіля (кг):");
        int capacity = userInputService.getUserInput("Введіть об'єм вашого автомобіля (ящ):");
        double sum = userInputService.getUserInput("Введіть суму депозиту на яку бажаєте здійснити закупівлю (грн):");
  //      downloadVanService.createVan(sum, weight, capacity);
        userViewService.cleanConsole();
//        userViewService.showMessage("Ваш депозит: " + downloadVanService.getDeposit() +
//                "   Залишок ваги: " + downloadVanService.getCarrying() +
//                "   Залишок об'єму: " + downloadVanService.getCapacity());
        userInputService.anyKeyInput();
    }

    private void coffeeSales() {
        //Виводимо шапку з залишками
        // Виводимо шапку таблиці
        //Виводимо таблицю відсортованих видів з цінами
        int art = userInputService.getUserInput("Введіть артикул вибраного товару");
        double quantity = userInputService.getUserInput("Введіть кількість ящиків");
//        downloadVanService.setNewDeposit(quantity);
        userViewService.showMessage("Ви придбали " + art + " в кількості" + quantity + "ящиків на суму:");
        //цикл поки sum != 0
        userViewService.showMessage("Ваш депозит: " + downloadVanService.getDeposit() +
                "   Залишок ваги: " + downloadVanService.getCarrying() +
                "   Залишок об'єму: " + downloadVanService.getCapacity());
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

