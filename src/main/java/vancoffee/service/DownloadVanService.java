package vancoffee.service;

import vancoffee.model.Coffee;
import vancoffee.model.Van;

public interface DownloadVanService {
    Van createVan(int maxWeight, int maxCapacity);

    void setDeposit(Van van, double deposit);

    void downloadGood(Van van, Coffee coffee, int amount);

    void validateBalances(Van van);
}
