package vancoffee.service.impl;

import vancoffee.model.Coffee;
import vancoffee.model.Van;
import vancoffee.service.DownloadVanService;
import vancoffee.exceptions.*;
import org.apache.log4j.Logger;

public class DownloadVanServiceImpl implements DownloadVanService {
    private static final Logger LOG = Logger.getLogger(DownloadVanServiceImpl.class);

    @Override
    public Van createVan(int maxWeight, int maxCapacity) {
        return new Van(maxWeight, maxCapacity);
    }

    @Override
    public void setDeposit(Van van, double deposit) {
        van.getPurchase().setDeposit(deposit);
    }

    @Override
    public void downloadGood(Van van, Coffee coffee, int amount) {
        LOG.debug("Amount downloadGood is " + amount);
        validateDownload(van, coffee, amount);
        van.getPurchase().addGoods(coffee, amount);
        van.setLoadedCapacity(amount);
        van.setLoadedWeight(coffee.getWeight() * amount);
    }

    private void validateDownload(Van van, Coffee coffee, int amount) {
        LOG.debug("Amount validateDownload is " + amount);
        if (van.getFreeWeight() < (coffee.getWeight() * amount))
            throw new NoAvailableWeightException(coffee, amount);
        if (van.getFreeCapacity() < amount)
            throw new NoAvailableCapacityException(coffee, amount);
        if (van.getPurchase().getBalance() < (coffee.getPrice() * amount))
            throw new SmallBalanceException(coffee, amount);
    }

    public void validateBalances(Van van) {
        if (van.getFreeWeight() < 7)
            throw new NoFreeWeightException();
        if (van.getFreeCapacity() < 1)
            throw new NoFreeCapacityException();
        if (van.getPurchase().getBalance() < 1330)
            throw new NoFreeBalanceException();
    }


}
