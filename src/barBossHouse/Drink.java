package barBossHouse;

public class Drink extends MenuItem implements Alcoholable {

    private double alcoholVol;
    private DrinkTypeEnum type;

    public Drink(int cost, String name, String description){
        super(cost, name, description);
    }

    public Drink(String name, DrinkTypeEnum type) {
        this(0,name,type, null, 0);
    }

    public Drink(int newCost, String newName, DrinkTypeEnum type, String newDescription) {
        this(newCost, newName,type,newDescription,0);
    }

    public Drink(int cost, String name, DrinkTypeEnum type, String description, double alcoholVol){
        super(cost, name, description);
        this.type = type;
        this.alcoholVol = alcoholVol;
    }

    @Override
    public boolean isAlcoholicDrink() {
        if (alcoholVol != 0)
            return true;
        else return false;
    }

    @Override
    public double getAlcoholVol() {
        return alcoholVol;
    }

    public DrinkTypeEnum getType() {
        return type;
    }

    @Override
    public String toString() {
        return String.format("Drink: %s %s, %dp. Alcholol: %d%. %s", type, getName(), getCost(), alcoholVol, description);
       /* StringBuilder string = new StringBuilder();
        string.append("Drink:").append(" ");
        string.append(super.toString());
        if (type != null) {
            string.append(this.type).append(" ");
        }
        string.append("Alcholol:");
        if (alcoholVol != 0) {
            string.append(this.alcoholVol).append("%.");
        }
        if (super.description != null) {
            string.append(this.description);
        }
        return string.toString();*/
    }

    @Override
    public boolean equals(Object obj) {
            return super.equals(obj) &&
                    ((Drink) obj).description.equals(super.description) &&
                    //todo аналогичная Customer и Address ошибка сравнения ты должна сравнивать атрибуты description объектов this и obj
                    //сделала
                    ((Drink) obj).alcoholVol == this.alcoholVol &&
                    ((Drink) obj).type == this.type;
    }

    @Override
    public int hashCode() {
        return super.hashCode()^type.hashCode()^Double.hashCode(this.alcoholVol);
    }
}
