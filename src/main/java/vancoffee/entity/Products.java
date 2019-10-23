package vancoffee.entity;

public class Products {
    private int id;
    private int art;
    private int sort_id;
    private int type_id;
    private double price;

    public Products(int id, int art, int sort_id, int type_id, double price) {
        this.id = id;
        this.art = art;
        this.sort_id = sort_id;
        this.type_id = type_id;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getArt() {
        return art;
    }

    public void setArt(int art) {
        this.art = art;
    }

    public int getSort_id() {
        return sort_id;
    }

    public void setSort_id(int sort_id) {
        this.sort_id = sort_id;
    }

    public int getType_id() {
        return type_id;
    }

    public void setType_id(int type_id) {
        this.type_id = type_id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
