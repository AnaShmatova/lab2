package barBossHouse;

public class Order
{
    private int size;
    private Dish[] dishes;

    public Order()
    {
        dishes = new Dish[16];
    }

    public Order(int newSize)
    {
        size = newSize;
        dishes = new Dish[newSize];
    }

    public Order(Dish[] newDishes)
    {
        dishes = newDishes;
    }

    public boolean addDishInOrder(Dish dish)
    {
        for (int i = 0; i < 16; i++)
        {
            if (dishes[i] == null)
            {
                dishes[i] = dish;
                return true;
            }
        }
        return false;
    }

    public boolean removeDishInOrder(String nameDish)
    {
        for (int i = 0; i < size; i++)
        {
            if (dishes[i].getName().equals(nameDish))
            {
                System.arraycopy(dishes, i, dishes, i + 1, size - i - 1);
                size--;
                return true;
            }
        }
        return false;
    }

    public int removeAll(String nameDish)
    {
        int count = 0;
        for (int i = 0; i < size; i++)
        {
            if (dishes[i].getName().equals(nameDish))
            {
                System.arraycopy(dishes, i, dishes, i + 1, size - i - 1);
                dishes[size--]=null;
                size--;
                i--;
                count++;
            }
        }
        return count;
    }

    public int dishQuantity()
    {
        return size;
    }

    public Dish[] getDishes()
    {
        return dishes;
    }

    public double costTotal()
    {
        double sum = 0;
        for (int i = 0; i < size ; i++)
        {
            sum+=dishes[i].getCost();
        }
        return sum;
    }

    public int dishQuantity(String dishName)
    {
        int count = 0;
        for (int i = 0; i < size; i++)
        {
            if (dishes[i].getName().equals(dishName))
            {
                count++;
            }
        }
        return count;
    }

    public String[] dishesNames()
    {
        String[] dishesNames = new String[size];
        for (int i = 0; i < size ; i++)
        {
            dishesNames[i] = dishes[i].getName();
        }
        return dishesNames;
    }

    public Dish[] sortedDishesByCostDesc()
    {
        Dish temp;
        for (int i = 0; i < dishes.length; i++)
        {
            for (int j = 0; j < dishes.length-1; j++)
            {
                if (dishes[j].getCost() < dishes[j+1].getCost())
                {
                    temp = dishes[j];
                    dishes[j] = dishes[j+1];
                    dishes[j+1] = temp;
                }
            }
        }
        return dishes;
    }
}