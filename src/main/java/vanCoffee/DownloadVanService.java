package vanCoffee;

public class DownloadVanService {
    private Van van = new Van();


    public void createVan(double deposit, int carrying, int capacity) {
        van.setDeposit(deposit);
        van.setCarrying(carrying);
        van.setCapacity(capacity);
    }

    public void setNewDeposit(double sum) {
        double i = van.getDeposit();
        van.setDeposit(i -= sum);
        System.out.println(van.getDeposit());//для перевірки
    }
    public void setNewCarrying(int quantity) {
        int i = van.getCarrying();
        van.setCarrying(i -= quantity);
        System.out.println(van.getCarrying());//для перевірки
    }
    public void setNewCapacity(int quantity) {
        int i = van.getCarrying();
        van.setCarrying(i -= quantity);
        System.out.println(van.getCarrying());// для перевірки
    }

    public double getDeposit() {
        return van.getDeposit();
    }

    public int getCarrying() {
        return van.getCarrying();
    }

    public int getCapacity() {
        return van.getCapacity();
    }
}


