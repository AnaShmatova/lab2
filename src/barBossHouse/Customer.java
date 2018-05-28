package barBossHouse;

import java.time.LocalDate;

public final class Customer {

    private final String firstName;
    private final String secondName;
    private final LocalDate birthDate;
    private final Address address;

    public static final Customer MATURE_UNKNOWN_CUSTOMER = new Customer(21);
    public static final Customer NOT_MATURE_UNKNOWN_CUSTOMER = new Customer(14);

    public Customer(){
        this(null, null, null, Address.EMPTY_ADDRESS);
    }

    public Customer(int age){
        this(null, null, null, Address.EMPTY_ADDRESS);
    }

    public Customer(String firstName, String secondName, LocalDate birthDate, Address address) {

        LocalDate now = LocalDate.now();

        if (now.getYear() < birthDate.getYear() | (now.getYear() == birthDate.getYear() & now.getMonthValue() < birthDate.getMonthValue()) | ((now.getYear() == birthDate.getYear() & now.getMonthValue() == birthDate.getMonthValue() & now.getDayOfMonth() < birthDate.getDayOfMonth())))
            throw new IllegalArgumentException();

        this.firstName = firstName;
        this.secondName = secondName;
        this.birthDate = birthDate;
        this.address = address;
    }

    public int getAge() {
        LocalDate now = LocalDate.now();
        return now.getYear() - birthDate.getYear();
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
        if (birthDate != null) {
            string.append(this.birthDate).append(",").append(" ");
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
            return comparison.secondName.equals(this.secondName) && //todo ты сравниваешь экземпляр класса Customer с атрибутом - secondName,
                //А нужно сравнивать атрибут secondName этого экземпляра c твоим атрибутом secondName

                    //сделала
                    comparison.equals(this.firstName) &&
                    comparison.birthDate == this.birthDate &&
                    comparison.address == this.address;
        }
    }

    @Override
    public int hashCode() {
        return secondName.hashCode()^firstName.hashCode()^birthDate.hashCode()^address.hashCode();
    }
}
