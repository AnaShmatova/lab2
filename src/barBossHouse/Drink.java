package barBossHouse;

public class Drink extends MenuItem implements Alcoholable {

    private int newCost;
    private String newName;
    private double alcoholVol;
    private DrinkTypeEnum type;
    private String newDescription;

    public Drink(int cost, String name, String description){
        super(cost, name, description);
    }

    public Drink(String name, DrinkTypeEnum type) {
        this(0,name,type, null, 0);
    }

    public Drink(int newCost, String newName, DrinkTypeEnum type, String newDescription) {
        this(newCost, newName,type,newDescription,0);
    }

    public Drink(int newCost, String newName, DrinkTypeEnum type, String newDescription, double alcoholVol){
        super(newCost, newName, type, newDescription, alcoholVol);
        this.newCost = newCost;
        this.newName = newName;
        this.type = type;
        this.newDescription = newDescription;
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
        StringBuilder string = new StringBuilder();
        string.append("Drink:").append(" ");
        if (type != null) {
            string.append(this.type).append(" ");
        }
        if (newName != null) {
            string.append(this.newName).append(",").append(" ");
        }
        if (newCost != 0) {
            string.append(this.newCost).append("р.").append(" ");
        }
        string.append("Alcholol:");
        if (alcoholVol != 0) {
            string.append(this.alcoholVol).append("%.");
        }
        if (newDescription != null) {
            string.append(this.newDescription);
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
            Drink comparison = (Drink) obj;
            return comparison.equals(newName) &&
                    comparison.equals(newDescription) &&
                    comparison.newCost == this.newCost &&
                    comparison.alcoholVol == this.alcoholVol &&
                    comparison.type == this.type;
        }
    }

    @Override
    public int hashCode() {
        return newName.hashCode()^newDescription.hashCode()^newCost^type.hashCode();
    }
}
