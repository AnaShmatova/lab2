package barBossHouse;

public final class Customer {

    private final String firstName;
    private final String secondName;
    private final int age;
    private final Address address;

    public static final Customer MATURE_UNKNOWN_CUSTOMER = new Customer(21);
    public static final Customer NOT_MATURE_UNKNOWN_CUSTOMER = new Customer(14);

    public Customer(){
        this(null, null, 0, Address.EMPTY_ADDRESS);
    }

    public Customer(int age){
        this(null, null, 0, Address.EMPTY_ADDRESS);
    }

    public Customer(String firstName, String secondName, int age, Address address) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.age = age;
        this.address = address;
    }

    public int getAge() {
        return age;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public Address getAddress() {
        return address;
    }

    @Override
    public String toString() {
        StringBuilder string = new StringBuilder();
        string.append("Customer:").append(" ");
        if (secondName != null) {
            string.append(this.secondName).append(" ");
        }
        if (firstName != null) {
            string.append(this.firstName).append(",").append(" ");
        }
        if (age != 0 | age != -1) {
            string.append(this.age).append(",").append(" ");
        }
        if (address != null | address.getBuildingNumber() != -1) {
            string.append(this.address);
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
            Customer comparison = (Customer) obj;
            return comparison.equals(secondName) &&
                    comparison.equals(firstName) &&
                    comparison.age == this.age &&
                    comparison.address == this.address;
        }
    }

    @Override
    public int hashCode() {
        return secondName.hashCode()^firstName.hashCode()^age^address.hashCode();
    }
}
