class Address {
    private String city;
    private String street;

    public Address(String city, String street) {
        this.city = city;
        this.street = street;
    }

    public void showAddress() {
        System.out.println("City: " + city + ", Street: " + street);
    }
}

class Person {
    private String name;
    private Address address; 

    public Person(String name, Address address) {
        this.name = name;
        this.address = address;
    }

    public void showPersonInfo() {
        System.out.println("Name: " + name);
        address.showAddress();
    }
}

// Главный класс
public class Association {
    public static void main(String[] args) {
        Address address = new Address("Almaty", "Muratbaeva");
        Person person = new Person("Temirlan", address);

        person.showPersonInfo();
    }
}
