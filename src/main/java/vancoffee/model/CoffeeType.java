package vancoffee.model;

public enum CoffeeType {
    BEANS("Зернова", 1),
    GROUND("Мелена", 2),
    JAR("Розчинна в банці", 3),
    STICK("Розчинна в пакеті", 4);



    private final String name;
    private final int id;


    CoffeeType(String name, int id) {
        this.name = name;
        this.id = id;

    }

    public String getTypeName() {
        return this.name;
    }

    public int getTypeId() {
        return this.id;
    }

    public String toString() {
        return name;
    }
}
