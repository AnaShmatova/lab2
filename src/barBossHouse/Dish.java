package barBossHouse;

public class Dish extends MenuItem {



    public Dish(int cost, String name, String description){
        super(cost, name, description);
    }

    public Dish (String newName, String newDescription) {
        super(DEFAULT_COST, newName, newDescription);
    }

    @Override
    public String toString() {
        StringBuilder string = new StringBuilder();
        string.append("Dish:").append(" ");
        if(getName() != null) {
            string.append(this.getName()).append(",");
        }
        if(getCost() != 0) {
            string.append(this.getCost()).append("р.").append(" ");
        }
        if (getDescription() != null) {
            string.append(this.getDescription());
        }
        return string.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == null) {
            return false;
        }

        if(!(getClass() == obj.getClass()))
            return false;
        else
        {
            Dish comparison = (Dish) obj;
            return comparison.equals(getName()) &&
                    comparison.equals(getDescription()) &&
                    comparison.getCost() == this.getCost();
        }
    }

    @Override
    public int hashCode() {
        return getName().hashCode()^getDescription().hashCode()^getCost();
    }
}
