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
        string.append(super.toString()); //todo а получаемую от super.toString() кто в билдер апендить будет?
        //сделала
        if (getDescription() != null) {
            string.append(this.getDescription());
        }
        return string.toString();
    }

    @Override
    public boolean equals(Object obj) {
        //todo в super.equals(obj) уже есть проеврка на null и сравнение типов, не нужно это здесь делать
        //сделала

        if(!(getClass() == obj.getClass()))
            return false;
        else
        {
            Dish comparison = (Dish) obj;
            return super.equals(obj) &&
                    comparison.getDescription().equals(getDescription()) &&
                    super.equals(obj);
            //todo аналогичная Customer и Address ошибка сравнения ты должна сравнивать атрибуты description объектов this и obj
            //сделала
        }
    }
}
