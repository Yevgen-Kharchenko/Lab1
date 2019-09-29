package vancoffee;


import vancoffee.model.Coffee;
import vancoffee.model.Stock;
import vancoffee.model.Van;
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
            userViewService.lineInTable(60);
            userViewService.headInTable();
            userViewService.lineInTable(60);
            /* виводимо табличку з відсортованими товарами*/
            for (Coffee coffee : stock.getProducts()) {
                System.out.println(coffee);
                userViewService.lineInTable(60);
            }

            int art = userInputService.getUserInput("Введіть артикул вибраного товару:");
//                    System.out.println(stock.getProductByArticle(art));
            int amount = userInputService.getUserInput("Введіть кількість ящиків:");
            /*робимо продаж*/
            try {
                downloadVanService.downloadGood(van, stock.getProductByArticle(art), amount);// не вірно вибраний товар
            } catch (RuntimeException e) {
                userViewService.showMessage(e.getMessage());
            }
            /* вивести товар, кількість і загальну суму*/
            userViewService.showMessage("Ви придбали " + art + " в кількості " +amount+ " ящиків на суму: "+van.getPurchase().getLoadedPrice());
            /*перевіряємо можливість подальшого продажу*/
            downloadVanService.validateBalances(van);
            /*програма переривається, а повинна перейти на наступний рівень*/
        }
    }

    private void productSearch() throws InterruptedException {
        while (userInputService.showQuestion("Бажаєте знайти товар в своїй корзині?")) {
            int sort = userInputService.getUserInput("Введіть сорт кави який бажаєте знайти:"+"/*вивести список сортів enam*/");
            /*відповідно вибраному sort id будемо шукати в списку покупок*/
            int type = userInputService.getUserInput("Введіть тип кави який бажаєте знайти:"+"/*вивести список типів enam*/");
            /*відповідно вибраному type id будемо шукати в списку покупок*/
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

