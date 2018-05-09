package barBossHouse;

public abstract class MenuItem {
    public static final int DEFAULT_COST = 0;
    private int cost;
    private String name;
    private String description;

    protected MenuItem(int name, String newName, DrinkTypeEnum type, String newDescription, double alcoholVol) {
        //todo: мы выносим дефолтные значения в константы с понятным именем
        //сделала
        this(DEFAULT_COST, newName, newDescription);
    }

    protected MenuItem(int cost, String name, String description) {
        //todo: наоборот, более узкий контейнер должен вызывать более широкий
        //сделала
        this.name = name;
        this.description = description;
        this.cost = cost;
    }

    public int getCost() {
        return cost;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        StringBuilder string = new StringBuilder();
        if (name != null) {
            string.append(this.name).append(",").append(" ");
        }
        if (cost != 0) {
            string.append(this.cost).append("р.");
        }
        return string.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (!(getClass() == obj.getClass())) {
            return false;
        }
        else
        {
            MenuItem comparison = (MenuItem) obj;
            return comparison.equals(name) &&
                    comparison.cost == this.cost;
        }
    }

    @Override
    public int hashCode() {
        return name.hashCode()^description.hashCode()^cost;
    }
}

