package vancoffee.service.impl;

import vancoffee.model.Coffee;
import vancoffee.model.Van;
import vancoffee.service.DownloadVanService;
import vancoffee.service.exceptions.NoAvailableCapacityException;
import vancoffee.service.exceptions.NoAvailableWeightException;
import vancoffee.service.exceptions.SmallBalanceException;

public class DownloadVanServiceImpl implements DownloadVanService {
    @Override
    public Van createVan(int maxWeight, int maxCapacity) {
        return new Van(maxWeight, maxCapacity);
    }

    @Override
    public Van setDeposit(Van van, double deposit) {
        van.getPurchase().setDeposit(deposit);
        return van;
    }

    @Override
    public Van downloadGood(Van van, Coffee coffee, int amount) {
        validateDownload(van, coffee, amount);
        van.getPurchase().addGoods(coffee, amount);
        return van;
    }

    private void validateDownload(Van van, Coffee coffee, int amount) {
        if (van.getFreeWeight() < (coffee.getWeight() * amount))
            throw new NoAvailableWeightException(coffee, amount);
        if (van.getFreeCapacity() < amount)
            throw new NoAvailableCapacityException(coffee, amount);
        if (van.getPurchase().getBalance() < (coffee.getPrice() * amount))
            throw new SmallBalanceException(coffee, amount);
    }


}
