package vancoffee.entity;

public class CoffeeSort {
    private int id;
    private String sort;

    public CoffeeSort(int id, String sort) {
        this.id = id;
        this.sort = sort;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }
}
