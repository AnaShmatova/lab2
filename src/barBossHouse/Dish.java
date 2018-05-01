package barBossHouse;

public class Dish {
    public static final int DEFAULT_COST = 0;
    private double cost;
    private String name;
    private String description;

    public Dish(String newName, String newDescription) {
        //todo: мы выносим дефолтные значения в константы с понятным именем
        //сделала
        this(DEFAULT_COST, newName, newDescription);
    }

    public Dish(double cost, String name, String description1) {
        //todo: наоборот, более узкий контейнер должен вызывать более широкий
        //сделала
        this.name = name;
        this.description = description;
        this.cost = cost;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

