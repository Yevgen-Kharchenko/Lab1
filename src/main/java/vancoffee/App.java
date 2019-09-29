package vancoffee;


import vancoffee.model.*;
import vancoffee.service.*;
import vancoffee.service.impl.DownloadVanServiceImpl;

public class App {
    private UserViewService userViewService;
    private UserInputService userInputService;
    private DownloadVanService downloadVanService;
    private Van van;


    private Stock stock = new Stock();


    public static void main(String[] args) throws InterruptedException {
        App app = new App();
        app.setUserViewService(new UserViewService());
        app.setUserInputService(new UserInputService());
        app.setDownloadVanService(new DownloadVanServiceImpl());

        System.out.println();


        app.setupVanParameters();
        app.coffeeSales();
        app.productSearch();


    }


    private void setupVanParameters() {
        userViewService.showMessage("Ласкаво просимо на сторінку команії 'CoffeeOptTorg'!");
        int weight = userInputService.getUserInput("Введіть вантажопідйомність вашого автомобіля (кг):");
        userViewService.showMessage("Введіть об'єм вашого автомобіля (ящ):");
        int capacity = userInputService.getUserInput("(рекомендовано " + weight / 10 + " - " + weight / 7 + ")");
        userViewService.showMessage("Введіть суму депозиту на яку бажаєте здійснити закупівлю (грн):");
        double sum = userInputService.getUserInput("(рекомендовано " + capacity * 1330 + " - " + capacity * 2450 + ")");
        this.van = downloadVanService.createVan(weight, capacity);
        downloadVanService.setDeposit(van, sum);
        userViewService.showMessage("Ви можете придбати " + weight + " кг. вантажу загальним об'ємом " + capacity + " ящ. на загальну суму " + sum + " грн.");

    }

    private void coffeeSales() {
        while (userInputService.showQuestion("Бажаєте придбати товар?")) {
            userViewService.cleanConsole();
            userViewService.showBalances(van.getFreeWeight(), van.getFreeCapacity(), van.getPurchase().getBalance());
            userViewService.showMessage("Товар відсортований по співвідношенню ціни до ваги");

            /* sort table*/
            userViewService.headInTable();
            for (Coffee coffee : stock.getProducts()) {
                System.out.println(coffee);
                userViewService.lineInTable(60);
            }

            int art = userInputService.getUserInput("Введіть артикул вибраного товару:");
            userViewService.headInTable();
            System.out.println(stock.getProductByArticle(art));
            userViewService.lineInTable(60);
            int amount = userInputService.getUserInput("Введіть кількість ящиків:");
            /*sale*/
            try {
                downloadVanService.downloadGood(van, stock.getProductByArticle(art), amount);// не вірно вибраний товар
            } catch (RuntimeException e) {
                userViewService.showMessage(e.getMessage());
            }
            userViewService.showMessage("Ви придбали " + stock.getNameByArticle(art) + " в кількості " + amount + " ящ. на суму: " + van.getPurchase().getLoadedPrice() + " грн.");

            downloadVanService.validateBalances(van);
            /*програма переривається, а повинна перейти на наступний рівень*/
        }
    }

    private void productSearch() throws InterruptedException {
        while (userInputService.showQuestion("Бажаєте знайти товар в своїй корзині?")) {
            System.out.printf("%-8s - 1\n%-8s - 2\n%s - 3\n", CoffeeSort.ARABICA, CoffeeSort.ROBUSTA, CoffeeSort.LIBERICA);
            int sort = userInputService.getUserInput("Введіть сорт кави який бажаєте знайти:");
            /*потрібна валідація на правильне введення*/
            System.out.printf("%-17s - 1\n%-17s - 2\n%-17s - 3\n%s - 4\n", CoffeeType.BEANS, CoffeeType.GROUND, CoffeeType.JAR, CoffeeType.STICK);
            int type = userInputService.getUserInput("Введіть тип кави який бажаєте знайти:");
            /*потрібна валідація на правильне введення*/
            /*відповідно вибраному  будемо шукати в списку покупок*/
            // здійснюємо пошук за параметрами, якщо якогось параметра немає то виводим декілька товарів за одним параметром
            userViewService.showDownload("Зачекайте, йде пошук");
            userViewService.showMessage("Ви придбали " + "sort" + type + "кави в кількості та на суму");


        }
        userViewService.showMessage("Дякуємо за покупку!");
    }

    public void setUserViewService(UserViewService userViewService) {
        this.userViewService = userViewService;
    }

    public void setUserInputService(UserInputService userInputService) {
        this.userInputService = userInputService;
    }


    public void setDownloadVanService(DownloadVanService downloadVanService) {
        this.downloadVanService = downloadVanService;
    }


}

