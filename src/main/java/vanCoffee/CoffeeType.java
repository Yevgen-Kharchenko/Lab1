package vanCoffee;

public enum CoffeeType {
    BEANS("Зернова", 1, 1d),
    GROUND("Мелена", 2,1.2d),
    JAR("Розчинна в банці", 3, 1.3d),
    STICK("Розчинна в пакеті", 4,1.4d);

    private final String name;
    private final int id;
    private final double coef;

    CoffeeType(String name, int id, double coef) {
        this.name = name;
        this.id = id;
        this.coef = coef;
    }

    public String getTypeName() {
        return this.name;
    }

       public int getTypeId() {
        return this.id;
    }
    public double getTypeCoef() {
        return this.coef;
    }

      public String toString() {
        String s= "Type name is: "+ name;
        return s;
    }
}
