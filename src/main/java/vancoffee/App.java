package vancoffee;

import vancoffee.model.*;
import vancoffee.service.DownloadVanService;
import vancoffee.service.SearchService;
import vancoffee.service.UserInputService;
import vancoffee.service.UserViewService;
import vancoffee.service.impl.DownloadVanServiceImpl;
import vancoffee.service.impl.SearchServiceImpl;

import java.util.Map;

public class App {
    private UserViewService userViewService;
    private UserInputService userInputService;
    private DownloadVanService downloadVanService;
    private SearchService searchService;
    private Van van;
    private Stock stock = new Stock();

    public static void main(String[] args) throws InterruptedException {
        App app = new App();
        app.setUserViewService(new UserViewService());
        app.setUserInputService(new UserInputService());
        app.setDownloadVanService(new DownloadVanServiceImpl());
        app.setSearchService(new SearchServiceImpl());

        app.setupVanParameters();
        app.coffeeSales();
        app.productSearch();
    }

    private void setupVanParameters() {
        userViewService.showMessage("Ласкаво просимо на сторінку команії 'CoffeeOptTorg'!");
        int weight = userInputService.getUserInput("Введіть вантажопідйомність фургона (кг):");
        userViewService.showMessage("Введіть об'єм фургона (ящ):");
        int capacity = userInputService.getUserInput("(рекомендовано " + weight / 10 + " - " + weight / 7 + ")");
        userViewService.showMessage("Введіть суму депозиту на яку бажаєте здійснити закупівлю (грн):");
        double sum = userInputService.getUserInput("(рекомендовано " + capacity * 1330 + " - " + capacity * 2450 + ")");
        this.van = downloadVanService.createVan(weight, capacity);
        downloadVanService.setDeposit(van, sum);
        userViewService.showMessage("Ви можете завантажити " + weight + " кг. загальним об'ємом " +
                capacity + " ящ. на загальну суму " + sum + " грн.");
    }

    private void coffeeSales() {
        while (userInputService.showQuestion("Бажаєте завантажити фургон?")) {
            userViewService.cleanConsole();
            userViewService.showBalances(van.getFreeWeight(), van.getFreeCapacity(), van.getPurchase().getBalance());
            userViewService.showMessage("Товар відсортований по співвідношенню ціни до ваги");
            userViewService.showAllProductsTable(stock.getProducts());
            int art = userInputService.validateInputUserService("Введіть артикул вибраного товару:", 12);
            userViewService.headInTable();
            System.out.println(stock.getProductByArticle(art));
            userViewService.lineInTable(60);
            int amount = userInputService.validateInputUserService("Введіть кількість ящиків:", van.getFreeCapacity());

            try {
                downloadVanService.downloadGood(van, stock.getProductByArticle(art), amount);
                userViewService.showMessage("Ви завантажили " + stock.getNameByArticle(art) +
                        " в кількості " + amount + " ящ. на суму: " +
                        van.getPurchase().getLoadedPrice() + " грн.");
                userViewService.showMessage("");
            } catch (RuntimeException e) {
                userViewService.showMessage(e.getMessage());
            }
            try {
                downloadVanService.validateBalances(van);
            } catch (RuntimeException e) {
                userViewService.showMessage(e.getMessage());
                break;
            }
            userViewService.showMessage("Ви можете завантажити " + van.getFreeWeight() +
                    " кг. загальним об'ємом " + van.getFreeCapacity() +
                    " ящ. на загальну суму " + van.getPurchase().getBalance() + " грн.");
            userViewService.showMessage("");
            userViewService.showMessage("");
        }
    }

    private void productSearch() throws InterruptedException {
        while (userInputService.showQuestion("Бажаєте знайти товар в своїй корзині?")) {
            userViewService.cleanConsole();
            userViewService.showMessage(String.format("%-9s - 1\n%-9s - 2\n%-9s - 3\nБудь-який - 4\n", CoffeeSort.ARABICA,
                    CoffeeSort.ROBUSTA, CoffeeSort.LIBERICA));
            int sort = userInputService.validateInputUserService("Введіть сорт кави який бажаєте знайти:", 4);
            userViewService.showMessage(String.format("%-17s - 1\n%-17s - 2\n%-17s - 3\n%s - 4\nБудь-який         - 5\n", CoffeeType.BEANS,
                    CoffeeType.GROUND, CoffeeType.JAR, CoffeeType.STICK));
            int type = userInputService.validateInputUserService("Введіть тип кави який бажаєте знайти:", 5);
            userViewService.showDownload("Зачекайте, йде пошук");
            Map<Coffee, Integer> foundGoods = searchService.search(van, sort, type);
            userViewService.showFoundProductsTable(foundGoods);
        }
        userViewService.cleanConsole();
        userViewService.showGoodBye("Д Я К У Є М О   З А   П О К У П К У!\n Чекаємо на Вас знову!");
    }

    private void setUserViewService(UserViewService userViewService) {
        this.userViewService = userViewService;
    }

    private void setUserInputService(UserInputService userInputService) {
        this.userInputService = userInputService;
    }

    private void setDownloadVanService(DownloadVanService downloadVanService) {
        this.downloadVanService = downloadVanService;
    }

    private void setSearchService(SearchService searchService) {
        this.searchService = searchService;
    }
}
