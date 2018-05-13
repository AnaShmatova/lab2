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
        super.toString();
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
            return super.equals((Object) obj) &&
                    comparison.equals(getDescription());
        }
    }
    //todo equals toString() вызывайреализацию изсуперкласса идобавляй кним особенностиэтого класса
}
