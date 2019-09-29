package vancoffee.model;

public enum CoffeeSort {
    ARABICA("Арабіка", 1),
    ROBUSTA("Робуста", 2),
    LIBERICA("Ліберіка", 3);

    private final String name;
    private final int id;

    CoffeeSort(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public String getSortName() {
        return this.name;
    }

        public int getSortId() {
        return this.id;
    }

     public String toString() {
         return name;
    }
}
