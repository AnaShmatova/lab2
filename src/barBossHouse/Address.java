package barBossHouse;

public final class Address {

    private final String cityName;
    private final String streetName;
    private final int zipCode;
    private final int buildingNumber;
    private final char buildingLetter;
    private final int apartmentNumber;

    public static final Address EMPTY_ADDRESS = new Address();

    public Address(){
        this(null,null,-1,-1,' ', -1);
    }

    public Address(String streetName, int buildingNumber, char buildingLetter, int apartmentNumber){
        this("Самара", null, -1,0,' ', 0);

    }

    public Address(String cityName, String streetName, int zipCode, int buildingNumber, char buildingLetter, int apartmentNumber) {
        this.cityName = cityName;
        this.streetName = streetName;
        this.zipCode = zipCode;
        this.buildingNumber = buildingNumber;
        this.buildingLetter = buildingLetter;
        this.apartmentNumber = apartmentNumber;

    }

    public String getCityName() {
        return cityName;
    }


    public String getStreetName() {
        return streetName;
    }

    public int getZipCode() {
        return zipCode;
    }

    public int getBuildingNumber() {
        return buildingNumber;
    }

    public char getBuildingLetter() {
        return buildingLetter;
    }

    public int getApartmentNumber() {
        return apartmentNumber;
    }

    @Override
    public String toString() {
        StringBuilder string = new StringBuilder();
        string.append("Address:").append(" ");
        if(cityName != null) {
            string.append(this.cityName).append(" ");
        }
        if(zipCode != -1 | zipCode != 0) {
            string.append(this.zipCode).append(",").append(" ");
        }
        if (streetName != null) {
            string.append(this.streetName).append(" ");
        }
        if (buildingNumber != -1 | buildingNumber != 0) {
            string.append(this.buildingNumber);
        }
        if (buildingLetter != -1 | buildingLetter != 0) {
            string.append(this.buildingLetter).append("-");
        }
        if (apartmentNumber != -1 | apartmentNumber != 0) {
            string.append(this.apartmentNumber);
        }
        return string.toString();
    }

    public boolean equals(Object obj) {
        if(obj == null) {
            return false;
        }

        if(!(getClass() == obj.getClass()))
            return false;
        else
        {
            Address comparison = (Address) obj;
            return comparison.cityName.equals(cityName) && //todo ты сравниваешь экземпляр класса Address с атрибутом - название города (строка),
                    //А нужно сравнивать атрибут cityName этого экземпляра c твоим атрибутом cityName
                    comparison.streetName.equals(streetName) && //todo  аналогично

                    //сделала
                    comparison.zipCode == this.zipCode &&
                    comparison.buildingNumber == this.buildingNumber &&
                    comparison.buildingLetter == this.buildingLetter &&
                    comparison.apartmentNumber == this.apartmentNumber;
        }
    }

    @Override
    public int hashCode() {
        return cityName.hashCode()^streetName.hashCode()^zipCode^buildingNumber^buildingLetter^apartmentNumber;
    }
}
