package barBossHouse;

public class Dish {
    private double cost;
    private String name;
    private String description;

    public Dish(String newName, String newDescription) {
        //todo: мы выносим дефолтные значения в константы с понятным именем
        cost = 0;
        name = newName;
        description = newDescription;
    }

    public Dish(double newCost1, String newName1, String newDescription1) {
        //todo: наоборот, более узкий контейнер должен вызывать более широкий
        this(newName1, newDescription1);
        cost = newCost1;
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

